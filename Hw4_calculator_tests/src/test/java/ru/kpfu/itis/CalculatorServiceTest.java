package ru.kpfu.itis;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.service.CalculatorService;

public class CalculatorServiceTest {
    private static CalculatorService calculatorService;
    private static String uri;
    private static final String incorrectURI = "/calc5-5";
    private static final String correctMultiExp = "/calc/5.89*4.5";
    private static final String correctPlusExp = "/calc/5.89+4.5";
    private static final String correctMinusExp = "/calc/5.89-4.5";
    private static final String correctDivExp = "/calc/5.89/4.5";
    private static final String incorrectExp = "/calc/-89";
    private static final String incorrectUriAnswer = "Неверный uri";
    private static final String incorrectExpAnswer = "Неверное выражение";
    private static final Double correctMultExpAnswer = 5.89 * 4.5;
    private static final Double correctDivExpAnswer = 5.89 / 4.5;
    private static final Double correctMinusExpAnswer = 5.89 - 4.5;
    private static final Double correctPlusExpAnswer = 5.89 + 4.5;
    private static final double DELTA = 10e-2;

    @BeforeClass
    public static void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    public void calculateShouldReturnCorrectAnswerWhenUriIsIncorrect() {
        uri = incorrectURI;
        String result = calculatorService.calculate(uri);
        Assert.assertEquals(incorrectUriAnswer, result);
    }


    @Test
    public void calculateShouldReturnCorrectAnswerWhenExpIsIncorrect() {
        uri = incorrectExp;
        String result = calculatorService.calculate(uri);
        Assert.assertEquals(incorrectExpAnswer, result);
    }

    @Test
    public void calculateShouldReturnCorrectAnswerWhenMultExpIsCorrect() {
        uri = correctMultiExp;
        Double result = Double.valueOf(calculatorService.calculate(uri));
        Assert.assertEquals(correctMultExpAnswer, result, DELTA);
    }

    @Test
    public void calculateShouldReturnCorrectAnswerWhenPlusExpIsCorrect() {
        uri = correctPlusExp;
        Double result = Double.valueOf(calculatorService.calculate(uri));
        Assert.assertEquals(correctPlusExpAnswer, result, DELTA);
    }

    @Test
    public void calculateShouldReturnCorrectAnswerWhenDivMultExpIsCorrect() {
        uri = correctDivExp;
        Double result = Double.valueOf(calculatorService.calculate(uri));
        Assert.assertEquals(correctDivExpAnswer, result, DELTA);
    }

    @Test
    public void calculateShouldReturnCorrectAnswerWhenMinusExpIsCorrect() {
        uri = correctMinusExp;
        Double result = Double.valueOf(calculatorService.calculate(uri));
        Assert.assertEquals(correctMinusExpAnswer, result, DELTA);
    }
}
