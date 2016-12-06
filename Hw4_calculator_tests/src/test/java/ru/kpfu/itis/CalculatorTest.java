package ru.kpfu.itis;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static Calculator calculator;
    private static final double FIRST_NUM = 2.0d;
    private static final double SECOND_NUM = 5.6d;
    private static final double DELTA = 10e-2;
    private static final double CORRECT_ANSWER_FOR_DIV = FIRST_NUM / SECOND_NUM;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void sumShouldReturnCorrectSum() {
        Assert.assertEquals(FIRST_NUM + SECOND_NUM, calculator.sum(FIRST_NUM, SECOND_NUM), DELTA);
    }


    @Test
    public void subShouldReturnCorrectSub() {
        Assert.assertEquals(FIRST_NUM - SECOND_NUM, calculator.sub(FIRST_NUM, SECOND_NUM), DELTA);
    }

    @Test
    public void divShouldReturnCorrectValue() {
        Assert.assertEquals(CORRECT_ANSWER_FOR_DIV, calculator.div(FIRST_NUM, SECOND_NUM), DELTA);
    }

    @Test
    public void multShouldReturnCorrectValue() {
        Assert.assertEquals(FIRST_NUM * SECOND_NUM, calculator.mult(FIRST_NUM, SECOND_NUM), DELTA);
    }


    @Test(expected = ArithmeticException.class)
    public void divShouldReturnCorrectResultWhenDividerIsZero() {
        calculator.div(FIRST_NUM, 0);
    }

}
