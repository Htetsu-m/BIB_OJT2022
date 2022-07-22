package com.java.poly;

/**
 * <h2>Vehicle Class</h2>
 * <p>
 * Process for Displaying Vehicle
 * </p>
 * 
 * @author User
 *
 */
class Vehicle {

    /**
     * <h2>run</h2>
     * <p>
     * defining a method
     * </p>
     *
     * @return void
     */
    void run() {
        System.out.println("Vehicle is moving");
    }
}

/**
 * <h2>Car Class</h2>
 * <p>
 * Process for Displaying Car
 * </p>
 * 
 * @author User
 *
 */
public class Car extends Vehicle {
    /**
     * <h2>run</h2>
     * <p>
     * defining the same method as in the parent class
     * </p>
     * 
     */
    void run() {
        System.out.println("car is running safely");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Car obj = new Car();// creating object
        obj.run();// calling method
    }

}
