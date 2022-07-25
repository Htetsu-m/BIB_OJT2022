package com.java.iostream;

import java.io.*;

/**
 * <h2> FilterInputStreamExample Class</h2>
 * <p>
 * Process for Displaying FilterInputStreamExample
 * </p>
 * 
 * @author User
 *
 */
public class FilterInputStreamExample {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        File data = new File("D:\\ojt-javatraining-workspace\\OJT_Day4\\src\\com\\java\\iostream\\test3.txt");
        FileInputStream file = new FileInputStream(data);
        FilterInputStream filter = new BufferedInputStream(file);
        int k = 0;
        while ((k = filter.read()) != -1) {
            System.out.print((char) k);
        }
        file.close();
        filter.close();
    }

} 
