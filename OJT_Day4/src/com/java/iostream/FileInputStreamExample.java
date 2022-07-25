package com.java.iostream;

import java.io.FileInputStream;

/**
 * <h2>FileInputStreamExample Class</h2>
 * <p>
 * Process for Displaying FileInputStreamExample
 * </p>
 * 
 * @author User
 *
 */
public class FileInputStreamExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            FileInputStream fin = new FileInputStream("D:\\ojt-javatraining-workspace\\OJT_Day4\\src\\com\\java\\iostream\\test1.txt");

            System.out.println(fin.getChannel());

            System.out.println(fin.getFD());

            System.out.println("Number of remaining bytes:" + fin.available());

            System.out.println("FileContents :");
            int i = 0;
            while ((i = fin.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println();
            fin.close();
            
            FileInputStream in = new FileInputStream("D:\\ojt-javatraining-workspace\\OJT_Day4\\src\\com\\java\\iostream\\test1.txt");
            in.skip(4);
            System.out.println("Skipped FileContents :");
            int sk = 0;
            while ((sk = in.read()) != -1) {
                System.out.print((char) sk);
            }
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
