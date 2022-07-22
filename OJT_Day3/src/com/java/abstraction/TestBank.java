package com.java.abstraction;

/**
 * <h2>Bank Class</h2>
 * <p>
 * Process for Displaying Bank
 * </p>
 * 
 * @author User
 *
 */
abstract class Bank {
    abstract int getRateOfInterest();
}

/**
 * <h2>SBI Class</h2>
 * <p>
 * Process for Displaying SBI
 * </p>
 * 
 * @author User
 *
 */
class SBI extends Bank {
    int getRateOfInterest() {
        return 7;
    }
}

/**
 * <h2>PNB Class</h2>
 * <p>
 * Process for Displaying PNB
 * </p>
 * 
 * @author User
 *
 */
class PNB extends Bank {
    int getRateOfInterest() {
        return 8;
    }
}

/**
 * <h2>TestBank Class</h2>
 * <p>
 * Process for Displaying TestBank
 * </p>
 * 
 * @author User
 *
 */
class TestBank {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Bank b;
        b = new SBI();
        System.out.println("Rate of Interest is: " + b.getRateOfInterest() + " %");
        b = new PNB();
        System.out.println("Rate of Interest is: " + b.getRateOfInterest() + " %");
    }

}
