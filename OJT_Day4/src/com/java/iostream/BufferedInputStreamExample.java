package com.java.iostream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * <h2>BufferedInputStreamExample Class</h2>
 * <p>
 * Process for Displaying BufferedInputStreamExample
 * </p>
 * 
 * @author User
 *
 */
public class BufferedInputStreamExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            FileInputStream fin = new FileInputStream(
                    "D:\\ojt-javatraining-workspace\\OJT_Day4\\src\\com\\java\\iostream\\test2.txt");
            BufferedInputStream bin = new BufferedInputStream(fin);
            int i;
            while ((i = bin.read()) != -1) {
                System.out.print((char) i);
            }
            bin.close();
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
