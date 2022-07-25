package com.java.iostream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

/**
 * <h2>FilterOutputStreamExample Class</h2>
 * <p>
 * Process for Displaying FilterOutputStreamExample
 * </p>
 * 
 * @author User
 *
 */
public class FilterOutputStreamExample {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        File data = new File("D:\\ojt-javatraining-workspace\\OJT_Day4\\src\\com\\java\\iostream\\test4.txt");
        FileOutputStream file = new FileOutputStream(data);
        FilterOutputStream filter = new FilterOutputStream(file);
        String s = "Welcome to java FilterOutputStream Example.";
        byte b[] = s.getBytes();
        filter.write(b);
        filter.flush();
        filter.close();
        file.close();
        System.out.println("Success...");
    }

}
