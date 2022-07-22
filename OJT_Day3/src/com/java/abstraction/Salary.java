package com.java.abstraction;

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
    private double salary;

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

    /**
     * <h2>setSalary</h2>
     * <p>
     * 
     * </p>
     *
     * @param newSalary
     * @return void
     */
    private void setSalary(double newSalary) {
        // TODO Auto-generated method stub
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
     */
    public double computePay() {
        System.out.println("Computing salary pay for " + getName());
        return salary / 52;
    }
}
