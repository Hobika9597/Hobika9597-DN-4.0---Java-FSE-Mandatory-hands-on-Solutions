public class FinancialForecast {

    // Recursive method to calculate future value
    public static double forecast(double currentValue, double growthRate, int years) {
        if (years == 0) return currentValue;
        return forecast(currentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double initialValue = 10000;  // Initial amount in ₹
        double growthRate = 0.10;     // 10% annual growth rate
        int years = 5;                // Forecast for 5 years

        double futureValue = forecast(initialValue, growthRate, years);
        System.out.printf("Future value after %d years: Rupees %.2f\n", years, futureValue);
    }
}
