package com.java.exception;

/**
 * <h2>ClassNotFoundException_Demo Class</h2>
 * <p>
 * Process for Displaying ClassNotFoundException_Demo
 * </p>
 * 
 * @author User
 *
 */
public class ClassNotFoundException_Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Class.forName("Class1"); // Class1 is not defined
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            System.out.println("Class Not Found...");
        }
    }

}
