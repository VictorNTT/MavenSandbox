package org.example.sandbox.chroniclequeue.demo;

import net.openhft.chronicle.queue.ChronicleQueue;
import net.openhft.chronicle.queue.ExcerptTailer;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueueBuilder;
import java.time.Instant;
import java.time.ZonedDateTime;

/*
Run with VM option:
--add-opens=java.base/java.time=ALL-UNNAMED --add-opens=java.base/sun.nio=ALL-UNNAMED --add-opens=java.base/sun.nio.ch=ALL-UNNAMED --add-opens=java.base/java.lang.reflect=ALL-UNNAMED --add-opens=java.base/java.util=ALL-UNNAMED --add-opens=java.base/java.security.util=ALL-UNNAMED  --add-opens=java.base/java.internal.reflect=ALL-UNNAMED --add-exports=java.base/jdk.internal.misc=ALL-UNNAMED  --add-exports=jdk.unsupported/sun.misc=ALL-UNNAMED
*/

public class MsgReplayApp {
    public static void main(String[] args) {
        String path = DemoConfig.CHRONICLE_QUEUE_TRADE;

        // Define our target window to read messages
        long startMillis = Instant.parse("2026-02-01T23:10:01.108Z").toEpochMilli();
        long endMillis = Instant.parse("2026-02-01T23:10:01.133Z").toEpochMilli();

        try (ChronicleQueue queue = SingleChronicleQueueBuilder.single(path).build()) {
            ExcerptTailer tailer = queue.createTailer();

            // 1. Jump to the start of the target DAY (Cycle)
            // For RollCycles.FAST_DAILY, the cycle is days since epoch
            int targetCycle = (int) (startMillis / (24 * 60 * 60 * 1000L));
            long startIndex = queue.rollCycle().toIndex(targetCycle, 0);
            tailer.moveToIndex(startIndex);

            System.out.println("Searching from start of cycle: " + targetCycle);

            // 2. Define filter logic
            TradeListener replayer = (timestamp, symbol, price, quantity) -> {

                if (timestamp >= startMillis && timestamp <= endMillis) {
                    // this is the message between the target window, do something with it
                    System.out.printf("[REPLAY] At %d: %s %d @ %.2f%n",
                            timestamp, symbol, quantity, price);
                }
            };

            var reader = tailer.methodReader(replayer);

            // 3. Scan and filter
            boolean foundEnd = false;
            while (reader.readOne() && !foundEnd) {
                // If we've passed the end window, we can stop scanning early
                // We access the last read timestamp via a shared variable or custom logic
                // For simplicity, we just scan the cycle here.
            }
        }
    }
}
