package controller;

public class Calculator {
    public double add(double x, double y) {
        return x + y;
    }

    public double del(double x, double y) {
        return x - y;
    }

    public double mul(double x, double y) {
        return x * y;
    }

    public double div(double x, double y) throws RuntimeException {

        return x / y;
    }
}
