package org.example;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        Charge charge = new Charge(); // Create a single instance of Charge

        Inmatning inmatning = new Inmatning(); // Create a single instance of Inmatning
        boolean pricesEntered = false; // check if prices are entered

        while (running) {
            System.out.println("Elpriser");
            System.out.println("========");
            System.out.println("1. Inmatning");
            System.out.println("2. Min, Max och Medel");
            System.out.println("3. Sortera");
            System.out.println("4. Bästa Laddningstid (4h)");
            System.out.println("e. Avsluta");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("Du valde Inmatning.");
                inmatning.inputPrices();
                pricesEntered = true; // Set flag to true once prices are entered


            } else if (choice.equals("2")) {
                System.out.println("You chose Min, Max och Medel.");

                int[] prices = inmatning.getPrices(); // Get the prices array
                MinMaxMedel.calculateAndPrintStats(prices);
            }


            else if (choice.equals("3")) {
                System.out.println("You chose 'Sortera' ");
                // Sort the prices
                int[] prices = inmatning.getPrices(); // Get the prices array
                Arrays.sort(prices);
                System.out.println("prices are sorted from the lowest to the highest");
                for (int i = 0; i < 24; i++) {
                    if (prices[i] > 0) {
                        LocalTime time = LocalTime.of(i, 1);
                        System.out.println("Hour " + time + ": " + prices[i] + " öre");
                    } else {
                        System.out.println("Price does not exist");
                    }
                }
            } else if (choice.equals("4")) {
                if (!pricesEntered) {
                    System.out.println("You need to store the prices first.");
                    continue; // Skip if prices aren't entered
                }

                System.out.println("You chose Bästa Laddningstid (4h).");
                int[] prices = inmatning.getPrices();
                Charge.ChargingResult result = charge.findBestChargingTime(prices);

                System.out.println("Best time to start charging: " + result.getStartTime() + " O'clock");
                System.out.println("Average price during these 4 hours: " + result.getAveragePrice() + " öre");


            } else if (choice.equals("e") || choice.equals("E")) {
                System.out.println("Exiting...");
                running = false;
            } else {
                System.out.println("Invalid choice, please choose a number from 1-4 or e to exit.");
            }
        }
    }
}
