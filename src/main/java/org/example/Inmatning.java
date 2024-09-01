package org.example;

import java.time.LocalTime;
import java.util.Scanner;

public class Inmatning {

    private final int[] prices = new int[24]; // Instance variable to store prices

    public void inputPrices() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput;

        for (int i = 0; i < 24; i++) {
            LocalTime time = LocalTime.of(i, 1); // Create a time like 00:00.
            do {
                System.out.println("Enter the price for " + time + " (in whole öre): ");
                String input = scanner.nextLine();

                try {
                    prices[i] = Integer.parseInt(input);
                    if (prices[i] < 0) {
                        System.out.println("Price cannot be negative. Please enter a valid price.");
                        validInput = false;
                    } else {
                        validInput = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    validInput = false;
                }
            } while (!validInput);
        }
    }

    public int[] getPrices() {
        return prices; // Return the array of prices
    }
}
