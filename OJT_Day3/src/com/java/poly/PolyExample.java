package com.java.poly;

/**
 * <h2>PolyExample Class</h2>
 * <p>
 * Process for Displaying PolyExample
 * </p>
 * 
 * @author User
 *
 */
public class PolyExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
        Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);
        System.out.println("Call mailCheck using Salary reference --");
        s.mailCheck();
        System.out.println("\n Call mailCheck using Employee reference--");
        e.mailCheck();
    }

}
