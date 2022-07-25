package com.java.exception;

/**
 * <h2>ArithmeticException_Demo Class</h2>
 * <p>
 * Process for Displaying ArithmeticException_Demo
 * </p>
 * 
 * @author User
 *
 */
public class ArithmeticException_Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            int a = 30, b = 0;
            int c = a / b; // cannot divide by zero
            System.out.println("Result = " + c);
        } catch (ArithmeticException e) {
            System.out.println("Can't divide a number by 0");
        }
    }

}
