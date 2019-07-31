package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calc = new Calculator();

     @Test
     public void testAdd() {

         String failMessage = "Expected calculator to handle integer addition.";

         assertEquals(failMessage, 5, calc.add(2, 3));
         assertEquals(failMessage, 17, calc.add(20, -3));
         assertEquals(failMessage, 1, calc.add(0, 1));
     }

     @Test
     public void testSubtract() {

         String failMessage = "Expected calculator to handle integer subtraction.";

         assertEquals(failMessage, -1, calc.subtract(2, 3));
         assertEquals(failMessage,  23, calc.subtract(20, -3));
         assertEquals(failMessage, 10, calc.subtract(11, 1));
     }

     @Test
     public void testMultiply() {

         String failMessage = "Expected calculator to handle integer multiplication.";

         assertEquals(failMessage, 6, calc.multiply(2, 3));
         assertEquals(failMessage, -60, calc.multiply(20, -3));
         assertEquals(failMessage, 0, calc.multiply(0, 1));
     }

     @Test
     public void testDivide() {

         String failMessage = "Expected calculator to handle integer division.";

         assertEquals(failMessage, 1, calc.divide(4, 3));
         assertEquals(failMessage, -5, calc.divide(20, -4));
         assertEquals(failMessage, 3, calc.divide(18, 5));
     }
}
