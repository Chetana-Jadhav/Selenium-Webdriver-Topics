package com.operation;

public class runProgram {
    //creation of main method
    public static void main(String[]args){
        //creation of object
        addition object = new addition(2,5);
        //calling method
        object.add();

        substraction object1 = new substraction(8,3);
        object1.sub();

        multiplication object2 = new multiplication(4,2);
        object2.mul();

    }
}
