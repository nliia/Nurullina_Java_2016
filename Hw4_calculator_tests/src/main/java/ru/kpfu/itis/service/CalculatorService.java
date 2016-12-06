package ru.kpfu.itis.service;

import ru.kpfu.itis.Calculator;
import ru.kpfu.itis.Operator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService implements Operator {
    private static Pattern uriPattern = Pattern.compile("/calc/(.*)");
    private static Pattern expressionPattern = Pattern.compile("(?<first>\\d+(\\.\\d+)*)(?<operator>(\\*|/|-|\\+)?)(?<second>\\d+(\\.\\d+)*)");
    private static Matcher m = null;
    private double firstNum;
    private double secondNum;
    private char operator;
    private String INVALID_EXP_RESULT = "Неверное выражение";
    private String INVALID_URL_RESULT = "Неверный uri";
    private String exp;
    private String result = null;
    public Calculator calculator;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    public String calculate(String uri) {

        m = uriPattern.matcher(uri);
        if (m.matches())
            exp = m.group(1);
        else
            return INVALID_URL_RESULT;
        m = expressionPattern.matcher(exp);
        if (m.matches()) {
            parseExp();
            calculateExpression();
        } else {
            result = INVALID_EXP_RESULT;
        }
        return result;
    }

    private void parseExp() {
        firstNum = Double.parseDouble(m.group("first"));
        secondNum = Double.parseDouble(m.group("second"));
        operator = m.group("operator").charAt(0);
    }

    private void calculateExpression() {
        switch (operator) {
            case PLUS:
                result = String.valueOf(calculator.sum(firstNum, secondNum));
                break;
            case MINUS:
                result = String.valueOf(calculator.sub(firstNum, secondNum));
                break;
            case MULTIPY:
                result = String.valueOf(calculator.mult(firstNum, secondNum));
                break;
            case DIVIDE:
                result = String.valueOf(calculator.div(firstNum, secondNum));
                break;
        }
    }
}
