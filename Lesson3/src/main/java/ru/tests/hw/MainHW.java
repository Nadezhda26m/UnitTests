package ru.tests.hw;

public class MainHW {

    // HW 3.1. Напишите тесты, покрывающие на 100% метод evenOddNumber, который проверяет,
    // является ли переданное число четным или нечетным. (код из презентации)

    public boolean evenOddNumber(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // HW 3.2. Нужно написать метод который проверяет, попадает ли переданное
    // число в интервал (25;100) и возвращает true, если попадает и false - если нет,
    // покрыть тестами метод на 100%

    public boolean numberInInterval(int n) {
        return n > 25 && n < 100;
    }
}
