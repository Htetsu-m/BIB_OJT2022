package com.java.exception;

/**
 * <h2>UncheckedExceptionExample Class</h2>
 * <p>
 * Process for Displaying UncheckedExceptionExample
 * </p>
 * 
 * @author User
 *
 */
public class UncheckedExceptionExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // Here we are dividing by 0
        // which will not be caught at compile time
        // as there is no mistake but caught at runtime
        // because it is mathematically incorrect
        int x = 0;
        int y = 10;
        int z = y / x;
    }

}
