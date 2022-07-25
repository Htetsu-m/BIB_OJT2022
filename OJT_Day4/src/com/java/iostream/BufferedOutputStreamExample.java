package com.java.iostream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * <h2>BufferedOutputStreamExample Class</h2>
 * <p>
 * Process for Displaying BufferedOutputStreamExample
 * </p>
 * 
 * @author User
 *
 */
public class BufferedOutputStreamExample {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        FileOutputStream fout = new FileOutputStream(
                "D:\\ojt-javatraining-workspace\\OJT_Day4\\src\\com\\java\\iostream\\test4.txt");
        BufferedOutputStream bout = new BufferedOutputStream(fout);
        String s = "Welcome to java.";
        byte b[] = s.getBytes();
        bout.write(b);
        bout.flush();
        bout.close();
        fout.close();
        System.out.println("success");
    }

}
