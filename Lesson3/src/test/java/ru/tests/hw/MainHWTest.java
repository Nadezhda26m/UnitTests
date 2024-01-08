package ru.tests.hw;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainHWTest {

    @ParameterizedTest
    @CsvSource({"0", "18", "-4"})
    void isEvenNumber(int n) {
        MainHW mainHW = new MainHW();
        assertTrue(mainHW.evenOddNumber(n));
    }

    @ParameterizedTest
    @CsvSource({"5", "117", "-7"})
    void isNotEvenNumber(int n) {
        MainHW mainHW = new MainHW();
        assertFalse(mainHW.evenOddNumber(n));
    }

    @ParameterizedTest
    @CsvSource({"26", "84", "99"})
    void numberInIntervalTest(int n) {
        MainHW mainHW = new MainHW();
        assertTrue(mainHW.numberInInterval(n));
    }

    @ParameterizedTest
    @CsvSource({"25", "4", "117", "100"})
    void numberNotInIntervalTest(int n) {
        MainHW mainHW = new MainHW();
        assertFalse(mainHW.numberInInterval(n));
    }
}
