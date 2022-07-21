package com.java.loop;

/**
 * <h2>ForLoopExample Class</h2>
 * <p>
 * Process for Displaying ForLoopExample
 * </p>
 * 
 * @author User
 *
 */
public class ForLoopExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();// new line
        }
    }

}
