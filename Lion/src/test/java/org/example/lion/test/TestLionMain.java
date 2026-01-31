package org.example.lion.test;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestLionMain {
    @Test
    public void testLionMain() {
        System.out.println("\n\n>>>>>>>>>>>>>>>>>>>>>>> Test LionMain <<<<<<<<<<<<<<<<<<<<\n");
        assertFalse("Lion is the king".isEmpty());
    }
}
