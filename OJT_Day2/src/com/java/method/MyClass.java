package com.java.method;

/**
 * <h2>MyClass Class</h2>
 * <p>
 * Process for Displaying MyClass
 * </p>
 * 
 * @author User
 *
 */
public class MyClass extends AbstractMethod {
    // method implementation
    /**
     * <h2>display</h2>
     * <p>
     * 
     * </p>
     * 
     */
    void display() {
        System.out.println("Abstract method?");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // creating object of abstract class
        AbstractMethod obj = new MyClass();
        // invoking abstract method
        obj.display();
    }

}
