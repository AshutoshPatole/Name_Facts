package com.bitsandbytes.namefacts;

public final class NumerologyUtils {

    private NumerologyUtils() {
        // Utility class
    }

    /**
     * Reduces a positive number by summing its digits repeatedly until it reaches
     * either a single digit (1-9) or a numerology master number (11, 22).
     */
    public static int reduce(int number) {
        while (number > 9 && number != 11 && number != 22) {
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            number = sum;
        }
        return number;
    }
}
