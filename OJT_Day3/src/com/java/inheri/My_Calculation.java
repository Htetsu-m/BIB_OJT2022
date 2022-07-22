package com.java.inheri;

/**
 * <h2>My_Calculation Class</h2>
 * <p>
 * Process for Displaying My_Calculation
 * </p>
 * 
 * @author User
 *
 */
public class My_Calculation extends Calculation {
    /**
     * <h2>multiplication</h2>
     * <p>
     * 
     * </p>
     *
     * @param x
     * @param y
     * @return void
     */
    public void multiplication(int x, int y) {
        z = x * y;
        System.out.println("The product of the given numbers:" + z);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a = 20, b = 10;
        My_Calculation demo = new My_Calculation();
        demo.addition(a, b);
        demo.Subtraction(a, b);
        demo.multiplication(a, b);
    }

}
