package org.example;

public class MinMaxMedel {

    public static void calculateAndPrintStats(int[] prices) {
        if (prices == null || prices.length == 0) {
            System.out.println("You need to store the prices first");
            return;
        }

        // Initialize min and max with the first element
        int min = prices[0];
        int max = prices[0];
        int minHour = 0;
        int maxHour = 0;
        int sum = prices[0];

        for (int i = 1; i < prices.length; i++) {
            sum += prices[i];

            if (prices[i] < min) {
                min = prices[i];
                minHour = i; // Store the hour directly as an index
            }
            if (prices[i] > max) {
                max = prices[i];
                maxHour = i;
            }
        }

        double avr = sum / (double) prices.length;

        System.out.println("The lowest öre price of the day is: " + min + " and it's at " + minHour + ":01 O'clock");
        System.out.println("The highest öre price of the day is: " + max + " and it's at " + maxHour + ":01 O'clock");
        System.out.println("The average öre price of the day is: " + avr);
    }
}
