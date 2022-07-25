package com.java.exception;

import java.util.Scanner;

/**
 * <h2>IOException_Demo Class</h2>
 * <p>
 * Process for Displaying IOException_Demo
 * </p>
 * 
 * @author User
 *
 */
public class IOException_Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // Create a new scanner with the specified String
        // Object
        Scanner scan = new Scanner("Hello Geek!");

        // Print the line
        System.out.println("" + scan.nextLine());

        // Check if there is an IO exception
        System.out.println("Exception Output: " + scan.ioException());

        scan.close();
    }

}
