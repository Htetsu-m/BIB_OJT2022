package com.java.inheri;

/**
 * <h2>Calculation Class</h2>
 * <p>
 * Process for Displaying Calculation
 * </p>
 * 
 * @author User
 *
 */
public class Calculation {
    int z;

    /**
     * <h2>addition</h2>
     * <p>
     * 
     * </p>
     *
     * @param x
     * @param y
     * @return void
     */
    public void addition(int x, int y) {
        z = x + y;
        System.out.println("The sum of the given numbers:" + z);
    }

    /**
     * <h2>Subtraction</h2>
     * <p>
     * 
     * </p>
     *
     * @param x
     * @param y
     * @return void
     */
    public void Subtraction(int x, int y) {
        z = x - y;
        System.out.println("The difference between the given numbers:" + z);
    }
}
