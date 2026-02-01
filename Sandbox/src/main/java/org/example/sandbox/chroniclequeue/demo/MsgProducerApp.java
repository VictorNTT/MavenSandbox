package org.example.sandbox.chroniclequeue.demo;

import net.openhft.chronicle.queue.ChronicleQueue;
import net.openhft.chronicle.queue.RollCycles;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueueBuilder;

import java.time.Instant;

/*
Run with VM option:
--add-opens=java.base/java.time=ALL-UNNAMED --add-opens=java.base/sun.nio=ALL-UNNAMED --add-opens=java.base/sun.nio.ch=ALL-UNNAMED --add-opens=java.base/java.lang.reflect=ALL-UNNAMED --add-opens=java.base/java.util=ALL-UNNAMED --add-opens=java.base/java.security.util=ALL-UNNAMED  --add-opens=java.base/java.internal.reflect=ALL-UNNAMED --add-exports=java.base/jdk.internal.misc=ALL-UNNAMED  --add-exports=jdk.unsupported/sun.misc=ALL-UNNAMED
*/
public class MsgProducerApp {
    public static void main(String[] args) {
        // Paths in Java use forward slashes or escaped backslashes
        String path = DemoConfig.CHRONICLE_QUEUE_TRADE;

        try (ChronicleQueue queue = SingleChronicleQueueBuilder.single(path)
                .rollCycle(RollCycles.FAST_DAILY) // Handles yyyymmdd logic
                .build()) {

            TradeListener writer = queue.methodWriter(TradeListener.class);
//            TradeListener writer = queue.acquireAppender().methodWriter(TradeListener.class);

            System.out.printf("[%s] Producing trade\n", Instant.ofEpochMilli(System.currentTimeMillis()));

            // Simulating message production
            writer.onTrade(System.currentTimeMillis(), "AAA", 150.25, 100);
            writer.onTrade(System.currentTimeMillis(), "BBB", 700.10, 50);
            writer.onTrade(System.currentTimeMillis(), "CCC", 2800.50, 10);

            System.out.printf("[%s] Messages persisted\n", Instant.ofEpochMilli(System.currentTimeMillis()));
        }
    }
}