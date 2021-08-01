package com.operation;

public class addition {
//properties/variable declaration
int a;
int b;
int result;
//passing or setting values for a & b with the help of constructor
public addition(int num1, int num2){
    a =  num1;
    b = num2;
}
//creation of method
    public void add(){
        result = a + b;
       System.out.println("Result of addition is :" +result);
    }

   }

