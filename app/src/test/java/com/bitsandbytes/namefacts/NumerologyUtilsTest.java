package com.bitsandbytes.namefacts;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumerologyUtilsTest {

    @Test
    public void testSingleDigitsRemainUnchanged() {
        for (int i = 1; i <= 9; i++) {
            assertEquals(i, NumerologyUtils.reduce(i));
        }
    }

    @Test
    public void testMasterNumbersPreserved() {
        assertEquals(11, NumerologyUtils.reduce(11));
        assertEquals(22, NumerologyUtils.reduce(22));
    }

    @Test
    public void testReductionToMasterNumber11() {
        // 29 -> 2 + 9 = 11 (master number)
        assertEquals(11, NumerologyUtils.reduce(29));
        // 38 -> 3 + 8 = 11 (master number)
        assertEquals(11, NumerologyUtils.reduce(38));
        // 47 -> 4 + 7 = 11 (master number)
        assertEquals(11, NumerologyUtils.reduce(47));
    }

    @Test
    public void testReductionToSingleDigits() {
        // 10 -> 1 + 0 = 1
        assertEquals(1, NumerologyUtils.reduce(10));
        // 15 -> 1 + 5 = 6
        assertEquals(6, NumerologyUtils.reduce(15));
        // 25 -> 2 + 5 = 7
        assertEquals(7, NumerologyUtils.reduce(25));
        // 99 -> 9 + 9 = 18 -> 1 + 8 = 9
        assertEquals(9, NumerologyUtils.reduce(99));
    }
}
