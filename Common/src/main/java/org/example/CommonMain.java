package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommonMain {
    private static final Logger LOGGER = LogManager.getLogger(CommonMain.class);
    public static void main(String[] args) {
        CommonMain m = new CommonMain();
        System.out.println("Hello CommonMain!");
        System.out.println("Log4j2 config file loaded? " + (m.getClass().getResource("/log4j2-test.xml") != null));
        LOGGER.debug("CommonMain debug");
        LOGGER.info("CommonMain info");
        LOGGER.warn("CommonMain warn");
        LOGGER.error("CommonMain error");
    }

    public void foo() {
        System.out.printf("CommonMain.foo()");
    }
}