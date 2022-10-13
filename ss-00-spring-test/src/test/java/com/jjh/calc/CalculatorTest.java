package com.jjh.calc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void testAddOneToCalculator() {
        Calculator calc = new Calculator();
        calc.add(1);
        double result = calc.value();
        assertEquals(1.0, result, "Expected result should be 1.0");
    }

}
