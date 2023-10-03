package levochka108.main.calculator;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @Test
    public void testCalculateDiscount() {
        // Проверка правильного расчета скидки
        double purchaseAmount = 100.0;
        double discountPercentage = 20.0;
        double expectedDiscountedAmount = 80.0;
        assertThat(Calculator.calculateDiscount(purchaseAmount, discountPercentage))
                .isEqualTo(expectedDiscountedAmount);

        // Проверка скидки в 0%
        double noDiscount = 0.0;
        assertThat(Calculator.calculateDiscount(purchaseAmount, noDiscount))
                .isEqualTo(purchaseAmount);

        // Проверка скидки в 100%
        double fullDiscount = 100.0;
        assertThat(Calculator.calculateDiscount(purchaseAmount, fullDiscount))
                .isEqualTo(0.0);

        // Проверка выбрасывания исключения при недопустимых аргументах
        assertThatThrownBy(() -> Calculator.calculateDiscount(-10.0, 20.0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("Invalid input");

        assertThatThrownBy(() -> Calculator.calculateDiscount(100.0, -20.0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("Invalid input");

        assertThatThrownBy(() -> Calculator.calculateDiscount(100.0, 120.0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("Invalid input");
    }
}
