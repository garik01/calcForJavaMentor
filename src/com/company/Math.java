package com.company;

public final class Math {

    public int calc(int a, char b, int c) {
        switch (b) {
            case ('+'):
                return plus(a, c);
            case ('-'):
                return minus(a, c);
            case ('*'):
                return mult(a, c);
            case ('/'):
                return div(a, c);
            default:
                throw new IllegalStateException("Unexpected value: " + b);
        }
    }

    private int plus(int a, int b) {
        return a + b;
    }

    private int minus(int a, int b) {
        return a - b;
    }

    private int mult(int a, int b) {
        return a * b;
    }

    private int div(int a, int b) {
        if (b > 0) {
            return a / b;
        }
        else
            return -1;
    }

}
