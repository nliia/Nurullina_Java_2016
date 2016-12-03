package ru.kpfu.itis;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static Calculator calculator;

    private static final double firstNum = 2.0d;
    private static final double secondNum = 5.6d;
    private static final double DELTA = 10e-2;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void sumShouldReturnCorrectSum() {
        Assert.assertEquals(firstNum + secondNum, calculator.sum(firstNum, secondNum), DELTA);
    }


    @Test
    public void subShouldReturnCorrectSub() {
        Assert.assertEquals(firstNum - secondNum, calculator.sub(firstNum, secondNum), DELTA);
    }

    @Test
    public void divShouldReturnCorrectValue() {
        Assert.assertEquals(firstNum / secondNum, calculator.div(firstNum, secondNum), DELTA);
    }

    @Test
    public void multShouldReturnCorrectValue() {
        Assert.assertEquals(firstNum * secondNum, calculator.mult(firstNum, secondNum), DELTA);
    }
}
