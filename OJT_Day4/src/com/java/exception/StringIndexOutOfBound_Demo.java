package com.java.exception;

/**
 * <h2>StringIndexOutOfBound_Demo Class</h2>
 * <p>
 * Process for Displaying StringIndexOutOfBound_Demo
 * </p>
 * 
 * @author User
 *
 */
public class StringIndexOutOfBound_Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            String a = "This is like chipping "; // length is 22
            char c = a.charAt(24); // accessing 25th element
            System.out.println(c);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException");
        }
    }

}
