package com.java.method;

/**
 * <h2>InstanceMethod Class</h2>
 * <p>
 * Process for Displaying InstanceMethod
 * </p>
 * 
 * @author User
 *
 */
public class InstanceMethod {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // Creating an object of the class
        InstanceMethod obj = new InstanceMethod();
        // invoking instance method
        System.out.println("The sum is: " + obj.add(12, 13));
    }

    int s;

    // user-defined method because we have not used static keyword
    public int add(int a, int b) {
        s = a + b;
        // returning the sum
        return s;
    }

}
