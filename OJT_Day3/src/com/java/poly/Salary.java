package com.java.poly;

/**
 * <h2>Salary Class</h2>
 * <p>
 * Process for Displaying Salary
 * </p>
 * 
 * @author User
 *
 */
public class Salary extends Employee {
    private double salary; // Annual salary

    public Salary(String name, String address, int number, double salary) {
        super(name, address, number);
        setSalary(salary);
    }

    /**
     * <h2>mailCheck</h2>
     * <p>
     * 
     * </p>
     * 
     */
    public void mailCheck() {
        System.out.println("Within mailCheck of Salary class ");
        System.out.println("Mailing check to " + getName() + " with salary " + salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        if (newSalary >= 0.0) {
            salary = newSalary;
        }
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
        System.out.println("Computing salary pay for " + getName());
        return salary / 52;
    }

}
