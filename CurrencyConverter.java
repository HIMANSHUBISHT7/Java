import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    private static final Map<String, Double> EXCHANGE_RATES = new HashMap<>();

    static {
        // Predefined exchange rates for some common currencies
        EXCHANGE_RATES.put("INR", 1.0);
        EXCHANGE_RATES.put("USD", 0.012156);
        EXCHANGE_RATES.put("EURO", 0.011081);
        EXCHANGE_RATES.put("British Pound", 0.0095);
        EXCHANGE_RATES.put("JPY", 1.691617);
        EXCHANGE_RATES.put("Chinese Yuan", 0.086974);
        EXCHANGE_RATES.put("Canadian Dollar", 0.016088);
    }

    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        if (EXCHANGE_RATES.containsKey(fromCurrency) && EXCHANGE_RATES.containsKey(toCurrency)) {
            double fromRate = EXCHANGE_RATES.get(fromCurrency);
            double toRate = EXCHANGE_RATES.get(toCurrency);
            return amount * (toRate / fromRate);
        } else {
            throw new IllegalArgumentException("Invalid currency code.");
        }
    }

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount: ");
        System.out.println();
        double amount = scanner.nextDouble();

        System.out.print("Enter the currency code to convert from (e.g., INR, USD, EURO, Britrish Pound, JPY, Chinese Yuan, Canadian Dollar): ");
        System.out.println();
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the currency code to convert to (e.g., INR, USD, EURO, British Pound, JPY, Chinese Yuan, Canadian Dollar): \n");
        System.out.println();
        String toCurrency = scanner.next().toUpperCase();

        scanner.close();

        try {
            double convertedAmount = converter.convertCurrency(amount, fromCurrency, toCurrency);
            System.out.println(amount + " " + fromCurrency + " is equal to " + convertedAmount + " " + toCurrency);
        } catch (IllegalArgumentException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
