package com.java.iostream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <h2>FileMerge Class</h2>
 * <p>
 * Process for Displaying FileMerge
 * </p>
 * 
 * @author User
 *
 */
public class FileMerge {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        PrintWriter pw = new PrintWriter(
                "D:\\ojt-javatraining-workspace\\OJT_Day4\\src\\com\\java\\iostream\\file3.txt");

        BufferedReader br1 = new BufferedReader(
                new FileReader("D:\\ojt-javatraining-workspace\\OJT_Day4\\src\\com\\java\\iostream\\file1.txt"));
        BufferedReader br2 = new BufferedReader(
                new FileReader("D:\\ojt-javatraining-workspace\\OJT_Day4\\src\\com\\java\\iostream\\file2.txt"));
        String line1 = br1.readLine();
        String line2 = br2.readLine();
        while (line1 != null || line2 != null) {
            if (line1 != null) {
                pw.println(line1);
                line1 = br1.readLine();
            }

            if (line2 != null) {
                pw.println(line2);
                line2 = br2.readLine();
            }
        }

        pw.flush();

        br1.close();
        br2.close();
        pw.close();

        System.out.println("Merged file1.txt and file2.txt alternatively into file3.txt");

    }

}
