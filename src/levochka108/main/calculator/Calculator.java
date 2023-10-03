package levochka108.main.calculator;

public class Calculator {
    public static double calculateDiscount(double purchaseAmount, double discountPercentage) {
        if (purchaseAmount < 0 || discountPercentage < 0 || discountPercentage > 100) {
            throw new ArithmeticException("Invalid input. Purchase amount and discount percentage must be non-negative, and discount percentage must be between 0 and 100.");
        }

        double discountAmount = (purchaseAmount * discountPercentage) / 100.0;
        return purchaseAmount - discountAmount;
    }
}
