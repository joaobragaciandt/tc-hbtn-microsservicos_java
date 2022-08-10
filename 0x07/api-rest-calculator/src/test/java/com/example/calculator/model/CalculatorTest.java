package com.example.calculator.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CalculatorTest {

    Calculator calculadora;

    @BeforeEach
    void setup() {
        calculadora = new Calculator();
    }

    @Test
    void sumTest() {
        Assertions.assertEquals(calculadora.sum(2.0,3.0),5.0);
    }

    @Test
    public void numbersNullSumTest() {
        Assertions.assertThrows(NullPointerException.class,() -> calculadora.sum(null,2.0),"Número 1 e número 2 são obrigatórios.");
    }

    @Test
    void subTest() {
        Assertions.assertEquals(calculadora.sub(15.0,3.0),12.0);
    }

    @Test
    void divideTest() {
        Assertions.assertEquals(calculadora.divide(15.0,3.0),5.0);
    }

    @Test
    public void divisionByZeroTest() {
        Assertions.assertThrows(ArithmeticException.class,() -> calculadora.divide(4.0,0.0));
    }

    @Test
    void factorialTest() {
        Assertions.assertEquals(calculadora.factorial(6),720);
    }

    @Test
    void integerToBinaryTest() {
        Assertions.assertEquals(calculadora.integerToBinary(20),10100);
    }

    @Test
    void integerToHexadecimalTest() {
        Assertions.assertEquals(calculadora.integerToHexadecimal(170),"aa");
    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate date1 = LocalDate.of(2022, 8, 9);
        LocalDate date2 = LocalDate.of(2022, 8, 26);
        Assertions.assertEquals(calculadora.calculeDayBetweenDate(date1,date2),17);
    }
}
