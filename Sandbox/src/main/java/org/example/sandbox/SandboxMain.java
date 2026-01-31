package org.example.sandbox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SandboxMain {
    private static final Logger LOGGER = LogManager.getLogger(SandboxMain.class);

    public static void main(String[] args) {

        System.out.println("Hello SandboxMain!");
        demoLogging();
    }

    private static void demoLogging() {
        LOGGER.info("Hello SandboxMain info");
        LOGGER.debug("Hello SandboxMain debug");
        LOGGER.warn("Hello SandboxMain warn");
        LOGGER.error("Hello SandboxMain error");
    }
}