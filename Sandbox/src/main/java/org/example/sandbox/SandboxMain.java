package org.example.sandbox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.CommonMain;

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
        CommonMain commonMain = new CommonMain();
        commonMain.foo();
    }

    private static void demoLogging() {
        System.out.println("Log4j2 config file loaded? " + (SandboxMain.class.getResource("/log4j2-test.xml") != null));

        LOGGER.info("Hello SandboxMain info");
        LOGGER.debug("Hello SandboxMain debug");
        LOGGER.warn("Hello SandboxMain warn");
        LOGGER.error("Hello SandboxMain error");
        CommonMain.main(null);
    }
}