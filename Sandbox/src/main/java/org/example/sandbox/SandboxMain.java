package org.example.sandbox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SandboxMain {
    private static final Logger LOGGER = LogManager.getLogger(SandboxMain.class);

    public static void main(String[] args) {
        System.out.println("Hello SandboxMain!");
        demoLogging();
        demoRecord();
    }

    private static void demoRecord() {
        System.out.println("demo record");

        MQConnection conPro = new MQConnection("127.0.0.1", 1415, "mgr1", "channel1", "userId1");
        System.out.println(conPro);

    }

    private static void demoLogging() {
        LOGGER.info("Hello SandboxMain info");
        LOGGER.debug("Hello SandboxMain debug");
        LOGGER.warn("Hello SandboxMain warn");
        LOGGER.error("Hello SandboxMain error");
    }
}