/*TASK 3

Currency Selection: Allow the user to choose the base currency and the target
currency.
Currency Rates: Fetch real-time exchange rates from a reliable API.
Amount Input: Take input from the user for the amount they want to convert.
Currency Conversion: Convert the input amount from the base currency to the
target currency using the fetched exchange rate.
Display Result: Show the converted amount and the target currency symbol
to the user.

import java.util.HashMap;
import java.util.Scanner;*/

public class CurrencyConverter {

    // Static method to simulate fetching exchange rates
    public static HashMap<String, Double> getExchangeRates() {
        HashMap<String, Double> rates = new HashMap<>();
        rates.put("USD_TO_EUR", 0.85);  // USD to EUR exchange rate
        rates.put("EUR_TO_USD", 1.18);  // EUR to USD exchange rate
        rates.put("USD_TO_GBP", 0.75);  // USD to GBP exchange rate
        rates.put("GBP_TO_USD", 1.33);  // GBP to USD exchange rate
        // Add more currency pairs as needed
        return rates;
    }

    // Method to perform the currency conversion
    public static double convertCurrency(double amount, String baseCurrency, String targetCurrency, HashMap<String, Double> rates) {
        String key = baseCurrency + "_TO_" + targetCurrency;
        if (rates.containsKey(key)) {
            double rate = rates.get(key);
            return amount * rate;
        } else {
            System.out.println("Exchange rate not available for the selected currencies.");
            return 0;
        }
    }

    // Method to display the result
    public static void displayResult(double amount, String targetCurrency) {
        System.out.printf("Converted Amount: %.2f %s\n", amount, targetCurrency);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Fetch exchange rates (In real-world, this would be fetched from an API)
        HashMap<String, Double> exchangeRates = getExchangeRates();

        // Currency selection
        System.out.print("Enter base currency (e.g., USD, EUR, GBP): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter target currency (e.g., USD, EUR, GBP): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Input amount to convert
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        // Perform conversion
        double convertedAmount = convertCurrency(amount, baseCurrency, targetCurrency, exchangeRates);

        // Display the result
        if (convertedAmount != 0) {
            displayResult(convertedAmount, targetCurrency);
        }

        scanner.close();
    }
}

 /*Output:
Enter base currency (e.g., USD, EUR, GBP): USD
Enter target currency (e.g., USD, EUR, GBP): GBP
Enter the amount to convert: 7000
Converted Amount: 5250.00 GBP

Enter base currency (e.g., USD, EUR, GBP): eur
Enter target currency (e.g., USD, EUR, GBP): usd
Enter the amount to convert: 10000
Converted Amount: 11800.00 USD */