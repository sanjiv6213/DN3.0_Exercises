public class RecursiveForecasts    {

    public static double calculateFutureValue(double initialValue, double growthRate, int years) {
        if (years == 0) {
            return initialValue;
        }
        return calculateFutureValue(initialValue, growthRate, years - 1) * (1 + growthRate);
    }
}
public class Main {

    public static void main(String[] args) {
        double initialValue = 1000.0; // Example initial value
        double growthRate = 0.05;    // Example annual growth rate (5%)
        int years = 10;              // Number of years to forecast

        // Call the recursive method from RecursiveForecast class
        double futureValue = RecursiveForecasts.calculateFutureValue(initialValue, growthRate, years);

        // Output the result
        System.out.printf("Future Value after %d years: %.2f%n", years, futureValue);
    }
}
