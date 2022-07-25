package com.java.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * <h2>CheckedExceptionExample Class</h2>
 * <p>
 * Process for Displaying CheckedExceptionExample
 * </p>
 * 
 * @author User
 *
 */
public class CheckedExceptionExample {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        // Reading file from path in local directory
        FileReader file = new FileReader("D:\\ojt-javatraining-workspace\\OJT_Day4\\src\\com\\java\\exception\\test.txt");

        // Creating object as one of ways of taking input
        BufferedReader fileInput = new BufferedReader(file);

        // Printing first 3 lines of file "C:\test\a.txt"
        for (int counter = 0; counter < 3; counter++)
            System.out.println(fileInput.readLine());

        // Closing file connections
        // using close() method
        fileInput.close();
    }

}
