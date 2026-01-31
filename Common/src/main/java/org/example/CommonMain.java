package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommonMain {
    private static final Logger LOGGER = LogManager.getLogger(CommonMain.class);
    public static void main(String[] args) {

        System.out.println("Hello CommonMain!");
        LOGGER.debug("CommonMain debug");
        LOGGER.info("CommonMain info");
        LOGGER.warn("CommonMain warn");
        LOGGER.error("CommonMain error");
    }
}