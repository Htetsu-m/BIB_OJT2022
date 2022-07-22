package com.java.inheri;

/**
 * <h2>SuperClass Class</h2>
 * <p>
 * Process for Displaying SuperClass
 * </p>
 * 
 * @author User
 *
 */
class SuperClass {
    int num = 20;

    // display method of superclass
    /**
     * <h2>display</h2>
     * <p>
     * 
     * </p>
     *
     * @return void
     */
    public void display() {
        System.out.println("This is the display method of superclass");
    }
}

/**
 * <h2>SubClass Class</h2>
 * <p>
 * Process for Displaying SubClass
 * </p>
 * 
 * @author User
 *
 */
public class SubClass extends SuperClass {
    int num = 10;

    // display method of sub class
    /**
     * <h2>display</h2>
     * <p>
     * 
     * </p>
     * 
     */
    public void display() {
        System.out.println("This is the display method of subclass");
    }

    /**
     * <h2>my_method</h2>
     * <p>
     * 
     * </p>
     *
     * @return void
     */
    public void my_method() {
        SubClass sub = new SubClass();
        sub.display();
        super.display();

        System.out.println("value of the variable named num in sub class:" + sub.num);

        System.out.println("value of the variable named num in super class:" + super.num);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SubClass obj = new SubClass();
        obj.my_method();
    }

}
