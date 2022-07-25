package com.java.exception;

/**
 * <h2>NumberFormat_Demo Class</h2>
 * <p>
 * Process for Displaying NumberFormat_Demo
 * </p>
 * 
 * @author User
 *
 */
public class NumberFormat_Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            // "akki" is not a number
            int num = Integer.parseInt("akki");

            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Number format exception");
        }
    }

}
