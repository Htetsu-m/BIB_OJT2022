package com.java.iostream;

import java.io.FileOutputStream;

/**
 * <h2>FileOutputStreamExample Class</h2>
 * <p>
 * Process for Displaying FileOutputStreamExample
 * </p>
 * 
 * @author User
 *
 */
public class FileOutputStreamExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            FileOutputStream fout = new FileOutputStream("D:\\ojt-javatraining-workspace\\OJT_Day4\\src\\com\\java\\iostream\\test2.txt");
            String s = "Welcome to java";
            byte b[] = s.getBytes();// converting string into byte array
            fout.write(b);
            fout.close();
            System.out.println("success...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
