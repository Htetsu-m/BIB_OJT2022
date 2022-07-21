package com.java.loop;

import java.util.Scanner;

public class DoWhileLoopExample {

    /**
     * <h2>main</h2>
     * <p>
     * 
     * </p>
     *
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int sum = 0;
        int number = 0;

        // create an object of Scanner class
        Scanner input = new Scanner(System.in);

        // do...while loop continues
        // until entered number is positive
        do {
            // add only positive numbers
            sum += number;
            System.out.println("Enter a number");
            number = input.nextInt();
        } while (number >= 0);

        System.out.println("Sum = " + sum);
        input.close();
    }

}
