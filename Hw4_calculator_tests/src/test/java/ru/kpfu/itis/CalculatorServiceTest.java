package ru.kpfu.itis;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.service.CalculatorService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculatorServiceTest {
    private static CalculatorService calculatorService;
    private static Calculator calculator;
    private static final String INCORRECT_URI = "/calc5-5";
    private static final String CORRECT_MULTI_EXP = "/calc/5.89*4.5";
    private static final String CORRECT_PLUS_EXP = "/calc/5.89+4.5";
    private static final String CORRECT_MINUS_EXP = "/calc/5.89-4.5";
    private static final String CORRECT_DIV_EXP = "/calc/5.89/4.5";
    private static final String INCORRECT_EXP = "/calc/-89";
    private static final String INCORRECT_URI_ANSWER = "Неверный uri";
    private static final String INCORRECT_EXP_ANSWER = "Неверное выражение";
    private static final Double CORRECT_MULT_EXP_ANSWER = 5.89 * 4.5;
    private static final Double CORRECT_DIV_EXP_ANSWER = 5.89 / 4.5;
    private static final Double CORRECT_MINUS_EXP_ANSWER = 5.89 - 4.5;
    private static final Double CORRECT_PLUS_EXP_ANSWER = 5.89 + 4.5;
    private static final double DELTA = 10e-2;
    private static final double FIRST_NUM = 5.89;
    private static final double SECOND_NUM = 4.5;

    @BeforeClass
    public static void setUp() {
        calculator = mock(Calculator.class);
        when(calculator.div(FIRST_NUM, SECOND_NUM)).thenReturn(CORRECT_DIV_EXP_ANSWER);
        when(calculator.sum(FIRST_NUM, SECOND_NUM)).thenReturn(CORRECT_PLUS_EXP_ANSWER);
        when(calculator.mult(FIRST_NUM, SECOND_NUM)).thenReturn(CORRECT_MULT_EXP_ANSWER);
        when(calculator.sub(FIRST_NUM, SECOND_NUM)).thenReturn(CORRECT_MINUS_EXP_ANSWER);
        when(calculator.div(FIRST_NUM, 0)).thenThrow(ArithmeticException.class);
        calculatorService = new CalculatorService(calculator);
    }

    @Test
    public void calculateShouldReturnCorrectAnswerWhenUriIsIncorrect() {
        String result = calculatorService.calculate(INCORRECT_URI);
        Assert.assertEquals(INCORRECT_URI_ANSWER, result);
    }


    @Test
    public void calculateShouldReturnCorrectAnswerWhenExpIsIncorrect() {
        String result = calculatorService.calculate(INCORRECT_EXP);
        Assert.assertEquals(INCORRECT_EXP_ANSWER, result);
    }

    @Test
    public void calculateShouldReturnCorrectAnswerWhenMultExpIsCorrect() {
        Double result = Double.valueOf(calculatorService.calculate(CORRECT_MULTI_EXP));
        Assert.assertEquals(CORRECT_MULT_EXP_ANSWER, result, DELTA);
    }

    @Test
    public void calculateShouldReturnCorrectAnswerWhenPlusExpIsCorrect() {
        Double result = Double.valueOf(calculatorService.calculate(CORRECT_PLUS_EXP));
        Assert.assertEquals(CORRECT_PLUS_EXP_ANSWER, result, DELTA);
    }

    @Test
    public void calculateShouldReturnCorrectAnswerWhenDivExpIsCorrect() {
        Double result = Double.valueOf(calculatorService.calculate(CORRECT_DIV_EXP));
        Assert.assertEquals(CORRECT_DIV_EXP_ANSWER, result, DELTA);
    }

    @Test
    public void calculateShouldReturnCorrectAnswerWhenMinusExpIsCorrect() {
        Double result = Double.valueOf(calculatorService.calculate(CORRECT_MINUS_EXP));
        Assert.assertEquals(CORRECT_MINUS_EXP_ANSWER, result, DELTA);
    }
}
