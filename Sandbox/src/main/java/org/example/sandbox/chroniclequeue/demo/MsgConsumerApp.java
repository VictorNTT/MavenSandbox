package org.example.sandbox.chroniclequeue.demo;

import net.openhft.chronicle.queue.ChronicleQueue;
import net.openhft.chronicle.queue.ExcerptTailer;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueueBuilder;
import java.time.Instant;
/*
Run with VM option:
--add-opens=java.base/java.time=ALL-UNNAMED --add-opens=java.base/sun.nio=ALL-UNNAMED --add-opens=java.base/sun.nio.ch=ALL-UNNAMED --add-opens=java.base/java.lang.reflect=ALL-UNNAMED --add-opens=java.base/java.util=ALL-UNNAMED --add-opens=java.base/java.security.util=ALL-UNNAMED  --add-opens=java.base/java.internal.reflect=ALL-UNNAMED --add-exports=java.base/jdk.internal.misc=ALL-UNNAMED  --add-exports=jdk.unsupported/sun.misc=ALL-UNNAMED
*/
public class MsgConsumerApp {
    public static void main(String[] args) {
        String path = DemoConfig.CHRONICLE_QUEUE_TRADE;

        try (ChronicleQueue queue = SingleChronicleQueueBuilder.single(path).build()) {

            // A Tailer keeps track of where it is in the queue
            ExcerptTailer tailer = queue.createTailer();

            // Define how to handle the messages received
            TradeListener readerLogic = (timestamp, symbol, price, quantity) -> {
                System.out.printf("[%s] TRADE RECEIVED -> Symbol: %s, Price: %.2f, Qty: %d%n",
                        Instant.ofEpochMilli(timestamp), symbol, price, quantity);
            };

            // Wrap the logic in a MethodReader
            var methodReader = tailer.methodReader(readerLogic);

            System.out.println("Consuming messages...");

            // readOne returns true if a message was read, false if end of queue
            while (true) {
                if (!methodReader.readOne()) {
                    // Optional: Sleep or wait for more messages
                    Thread.yield();
                }
            }
        }
    }
}