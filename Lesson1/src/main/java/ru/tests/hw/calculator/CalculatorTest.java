package ru.tests.hw.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {
    public static void main(String[] args) {
        // Валидные данные
        assertThat(Calculator.calculatingDiscount(100, 2))
                .isEqualTo(98, withPrecision(0.0001));
        assertThat(Calculator.calculatingDiscount(Integer.MAX_VALUE, 41))
                .isEqualTo(1267015351.73, withPrecision(0.0001));
        assertThat(Calculator.calculatingDiscount(2.756, 100))
                .isEqualTo(0);
        assertThat(Calculator.calculatingDiscount(43634725.2355, 0))
                .isEqualTo(43634725.2355);
        assertThat(Calculator.calculatingDiscount(0.2353464576783567, 13))
                .isEqualTo(0.20475, withPrecision(0.0001));

        // Невалидные данные
        assertThatThrownBy(() -> Calculator.calculatingDiscount(-7, 12))
                .isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() -> Calculator.calculatingDiscount(-7, 120))
                .isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() -> Calculator.calculatingDiscount(-7, -1))
                .isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() -> Calculator.calculatingDiscount(1241353, -7))
                .isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() -> Calculator.calculatingDiscount(1241353, 101))
                .isInstanceOf(ArithmeticException.class);

    }

}