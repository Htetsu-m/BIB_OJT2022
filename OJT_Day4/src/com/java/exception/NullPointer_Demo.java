package com.java.exception;

/**
 * <h2>NullPointer_Demo Class</h2>
 * <p>
 * Process for Displaying NullPointer_Demo
 * </p>
 * 
 * @author User
 *
 */
public class NullPointer_Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            String a = null; // null value
            System.out.println(a.charAt(0));
        } catch (NullPointerException e) {
            System.out.println("NullPointerException..");
        }
    }

}
