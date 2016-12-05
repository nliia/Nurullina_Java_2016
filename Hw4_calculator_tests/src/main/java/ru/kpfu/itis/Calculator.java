package ru.kpfu.itis;

public class Calculator {
    public double sum(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mult(double a, double b) {
        return a * b;
    }

    public String div(double a, double b) {

        if (b == 0)
            return "Ошибка деления";
        else {
            double result = a / b;
            return String.valueOf(result);
        }
    }
}
