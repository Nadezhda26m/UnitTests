package ru.tests.hw.calculator;

public class Calculator {
    /*
    Задание 1. В классе Calculator создайте метод calculateDiscount, который принимает
    сумму покупки и процент скидки и возвращает сумму с учетом скидки. Ваша задача -
    проверить этот метод с использованием библиотеки AssertJ. Если метод calculateDiscount
    получает недопустимые аргументы, он должен выбрасывать исключение ArithmeticException.
    Не забудьте написать тесты для проверки этого поведения.
     */

    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        if (purchaseAmount < 0) {
            throw new ArithmeticException("Invalid data: purchaseAmount");
        }
        if (discountAmount < 0 || discountAmount > 100) {
            throw new ArithmeticException("Invalid data: discountAmount");
        }

        return purchaseAmount * ((100d - discountAmount) / 100);
    }
}