package com.java.encap;

/**
 * <h2>EncapExample Class</h2>
 * <p>
 * Process for Displaying EncapExample
 * </p>
 * 
 * @author User
 *
 */
public class EncapExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        EncapTest encap = new EncapTest();
        encap.setName("James");
        encap.setAge(20);
        encap.setIdNum("12343ms");

        System.out.print("Name : " + encap.getName() + " Age : " + encap.getAge());
    }

}
