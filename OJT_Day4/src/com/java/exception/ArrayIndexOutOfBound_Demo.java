package com.java.exception;

/**
 * <h2>ArrayIndexOutOfBound_Demo Class</h2>
 * <p>
 * Process for Displaying ArrayIndexOutOfBound_Demo
 * </p>
 * 
 * @author User
 *
 */
public class ArrayIndexOutOfBound_Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            int a[] = new int[5];
            a[6] = 9; // accessing 7th element in an array of
                      // size 5
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index is Out Of Bounds");
        }
    }

}
