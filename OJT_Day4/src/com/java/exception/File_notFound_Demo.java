package com.java.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * <h2>File_notFound_Demo Class</h2>
 * <p>
 * Process for Displaying File_notFound_Demo
 * </p>
 * 
 * @author User
 *
 */
public class File_notFound_Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {

            // Following file does not exist
            File file = new File("E://file.txt");

            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        }
    }

}
