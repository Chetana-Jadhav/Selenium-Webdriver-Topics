package com.operation;

public class multiplication {
    int a;
    int b;
    int result;

    public multiplication(int num1, int num2) {
        a = num1;
        b = num2;
    }

    public void mul() {
        result = a * b;
        System.out.println("Result of multiplication is:" + result);
    }
}
