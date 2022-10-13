package com.jjh.calc;

public class Calculator {
    private double memory = 0.0;

    public double add(double d) {
        return memory += d;
    }

    public double subtract(double d) {
        return memory -= d;
    }

    public void clear() {
        memory = 0.0;
    }

    public double value() {
        return memory;
    }
}
