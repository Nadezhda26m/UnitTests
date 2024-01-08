package ru.tests.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainHWTest {
    MainHW mainHW;

    @BeforeEach
    void setUp() {
        mainHW = new MainHW();
    }

    @ParameterizedTest
    @CsvSource({"0", "18", "-4"})
    void isEvenNumber(int n) {
        assertTrue(mainHW.evenOddNumber(n));
    }

    @ParameterizedTest
    @CsvSource({"5", "117", "-7"})
    void isNotEvenNumber(int n) {
        assertFalse(mainHW.evenOddNumber(n));
    }

    @ParameterizedTest
    @CsvSource({"26", "84", "99"})
    void numberInIntervalTest(int n) {
        assertTrue(mainHW.numberInInterval(n));
    }

    @ParameterizedTest
    @CsvSource({"25", "4", "117", "100"})
    void numberNotInIntervalTest(int n) {
        assertFalse(mainHW.numberInInterval(n));
    }
}
