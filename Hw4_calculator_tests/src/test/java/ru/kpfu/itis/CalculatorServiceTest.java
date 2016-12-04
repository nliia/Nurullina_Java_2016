package ru.kpfu.itis;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.service.CalculatorService;

public class CalculatorServiceTest {
    private static CalculatorService calculatorService;
    private static String uri;
    private static final String INCORRECT_URI = "/calc5-5";
    private static final String CORRECT_MULTI_EXP = "/calc/5.89*4.5";
    private static final String CORRECT_PLUS_EXP = "/calc/5.89+4.5";
    private static final String CORRECT_MINUS_EXP = "/calc/5.89-4.5";
    private static final String CORRECT_DIV_EXP = "/calc/5.89/4.5";
    private static final String INCORRECT_EXP = "/calc/-89";
    private static final String ZERO_DIVIDER_EXP = "/calc/6.8/0";
    private static final String INCORRECT_URI_ANSWER = "Неверный uri";
    private static final String INCORRECT_EXP_ANSWER = "Неверное выражение";
    private static final Double CORRECT_MULT_EXP_ANSWER = 5.89 * 4.5;
    private static final Double CORRECT_DIV_EXP_ANSWER = 5.89 / 4.5;
    private static final Double CORRECT_MINUS_EXP_ANSWER = 5.89 - 4.5;
    private static final Double CORRECT_PLUS_EXP_ANSWER = 5.89 + 4.5;
    private static final String CORRECT_ZERO_DIVIDER_ANSWER = "Ошибка деления";
    private static final double DELTA = 10e-2;

    @BeforeClass
    public static void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    public void calculateShouldReturnCorrectAnswerWhenUriIsIncorrect() {
        uri = INCORRECT_URI;
        String result = calculatorService.calculate(uri);
        Assert.assertEquals(INCORRECT_URI_ANSWER, result);
    }


    @Test
    public void calculateShouldReturnCorrectAnswerWhenExpIsIncorrect() {
        uri = INCORRECT_EXP;
        String result = calculatorService.calculate(uri);
        Assert.assertEquals(INCORRECT_EXP_ANSWER, result);
    }

    @Test
    public void calculateShouldReturnCorrectAnswerWhenMultExpIsCorrect() {
        uri = CORRECT_MULTI_EXP;
        Double result = Double.valueOf(calculatorService.calculate(uri));
        Assert.assertEquals(CORRECT_MULT_EXP_ANSWER, result, DELTA);
    }

    @Test
    public void calculateShouldReturnCorrectAnswerWhenPlusExpIsCorrect() {
        uri = CORRECT_PLUS_EXP;
        Double result = Double.valueOf(calculatorService.calculate(uri));
        Assert.assertEquals(CORRECT_PLUS_EXP_ANSWER, result, DELTA);
    }

    @Test
    public void calculateShouldReturnCorrectAnswerWhenDivMultExpIsCorrect() {
        uri = CORRECT_DIV_EXP;
        Double result = Double.valueOf(calculatorService.calculate(uri));
        Assert.assertEquals(CORRECT_DIV_EXP_ANSWER, result, DELTA);
    }

    @Test
    public void calculateShouldReturnCorrectAnswerWhenMinusExpIsCorrect() {
        uri = CORRECT_MINUS_EXP;
        Double result = Double.valueOf(calculatorService.calculate(uri));
        Assert.assertEquals(CORRECT_MINUS_EXP_ANSWER, result, DELTA);
    }

    @Test
    public void calculateShouldReturnCorrectAnswerWhenDividerIsZero() {
        uri = ZERO_DIVIDER_EXP;
        String result = calculatorService.calculate(uri);
        Assert.assertEquals(CORRECT_ZERO_DIVIDER_ANSWER, result);
    }
}
