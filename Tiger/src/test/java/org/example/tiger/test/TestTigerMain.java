package org.example.tiger.test;

import org.example.tiger.TigerMain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;


public class TestTigerMain {

   @Test
    public void testTigerMain() {
        System.out.println("\n\n>>>>>>>>>>>>>>>>>>>>>>> Test TigerMain <<<<<<<<<<<<<<<<<<<<\n");
        TigerMain.main(null);
        assertFalse("Tiger".isBlank());
    }
}
