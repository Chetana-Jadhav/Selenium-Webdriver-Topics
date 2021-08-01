package com.operation;

public class substraction {
    int a;
    int b;
    int result;
    public substraction(int num1, int num2){
        a =  num1;
        b = num2;
    }
    public void sub(){
        result = a - b;
        System.out.println("Result of subtraction is:" +result);
    }
}
