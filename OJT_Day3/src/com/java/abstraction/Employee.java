package com.java.abstraction;

/**
 * <h2>Employee Class</h2>
 * <p>
 * Process for Displaying Employee
 * </p>
 * 
 * @author User
 *
 */
public abstract class Employee {
    private String name;
    private String address;
    private int number;

    public Employee(String name, String address, int number) {
        System.out.println("Constructing an Employee");
        this.name = name;
        this.address = address;
        this.number = number;
    }

    /**
     * <h2>computePay</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return double
     */
    public double computePay() {
        System.out.println("Inside Employee computePay");
        return 0.0;
    }

    /**
     * <h2>mailCheck</h2>
     * <p>
     * 
     * </p>
     *
     * @return void
     */
    public void mailCheck() {
        System.out.println("Mailing a check to " + this.name + " " + this.address);
    }

    public String toString() {
        return name + " " + address + " " + number;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String newAddress) {
        address = newAddress;
    }

    public int getNumber() {
        return number;
    }

}
