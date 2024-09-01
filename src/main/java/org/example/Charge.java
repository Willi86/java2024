package org.example;

import java.time.LocalTime;

public class Charge {

    public static class ChargingResult {
        private final LocalTime startTime;
        private final double averagePrice;

        public ChargingResult(LocalTime startTime, double averagePrice) {
            this.startTime = startTime;
            this.averagePrice = averagePrice;
        }

        public LocalTime getStartTime() {
            return startTime;
        }

        public double getAveragePrice() {
            return averagePrice;
        }
    }

    public ChargingResult findBestChargingTime(int[] prices) {
        int k = 4; // Window size (4 hours)

        if (prices.length < k) {
            throw new IllegalArgumentException("Not enough prices to calculate the best charging time.");
        }

        int minSum ;
        int currentSum = 0;
        int startIndex = 0;

        // Calculate the sum of the first window (first 4 hours)
        for (int i = 0; i < k; i++) {
            currentSum += prices[i];
        }
        minSum = currentSum;

        // Slide the window across the array
        for (int i = k; i < prices.length; i++) {
            currentSum += prices[i] - prices[i - k];
            if (currentSum < minSum) {
                minSum = currentSum;
                startIndex = i - k + 1;
            }
        }

        // Calculate the average price over the best 4-hour window
        double averagePrice = minSum / (double) k;

        // Convert startIndex to time format
        LocalTime startTime = LocalTime.of(startIndex, 1);

        return new ChargingResult(startTime, averagePrice);
    }
}
