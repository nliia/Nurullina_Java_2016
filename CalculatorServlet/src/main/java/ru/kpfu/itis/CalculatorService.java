package ru.kpfu.itis;

public class CalculatorService {

    private double result;

    public double calculate(double a, double b, Operator operator) {
        Calculator calculator = new Calculator();

        switch (operator) {
            case PLUS:
                result = calculator.sum(a, b);
                break;
            case MINUS:
                result = calculator.sub(a, b);
                break;
            case MULTIPLY:
                result = calculator.mult(a, b);
                break;
            case DIVIDE:
                result = calculator.div(a, b);
                break;
        }
        return result;
    }
}
