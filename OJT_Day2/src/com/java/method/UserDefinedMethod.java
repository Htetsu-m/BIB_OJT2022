package com.java.method;

import java.util.Scanner;

/**
 * <h2>UserDefinedMethod Class</h2>
 * <p>
 * Process for Displaying UserDefinedMethod
 * </p>
 * 
 * @author User
 *
 */
public class UserDefinedMethod {
    /**
     * <h2>findEvenOdd</h2>
     * <p>
     * 
     * </p>
     *
     * @param num
     * @return void
     */
    public static void findEvenOdd(int num) {
        // method body
        if (num % 2 == 0)
            System.out.println(num + " is even");
        else
            System.out.println(num + " is odd");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number: ");
        // reading value from the user
        int num = scan.nextInt();
        // method calling
        findEvenOdd(num);
    }

}
