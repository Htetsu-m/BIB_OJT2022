package com.java.exception;

/**
 * <h2>MyException Class</h2>
 * <p>
 * Process for Displaying MyException
 * </p>
 * 
 * @author User
 *
 */
class MyException extends Exception {
    public MyException(String s) {
        // Call constructor of parent Exception
        super(s);
    }
}

/**
 * <h2>UserDefinedException Class</h2>
 * <p>
 * Process for Displaying UserDefinedException
 * </p>
 * 
 * @author User
 *
 */
public class UserDefinedException {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            // Throw an object of user defined exception
            throw new MyException("GeeksGeeks");
        } catch (MyException ex) {
            System.out.println("Caught");

            // Print the message from MyException object
            System.out.println(ex.getMessage());
        }
    }

}
