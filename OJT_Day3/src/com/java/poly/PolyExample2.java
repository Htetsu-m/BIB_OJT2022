package com.java.poly;

/**
 * <h2>Shapes Class</h2>
 * <p>
 * Process for Displaying Shapes
 * </p>
 * 
 * @author User
 *
 */
class Shapes {
    public void area() {
        System.out.println("Find area ");
    }

    public void area(int r) {
        System.out.println("Circle area = " + 3.14 * r * r);
    }

    public void area(double b, double h) {
        System.out.println("Triangle area=" + 0.5 * b * h);
    }

    public void area(int l, int b) {
        System.out.println("Rectangle area=" + l * b);
    }

}

/**
 * <h2>PolyExample2 Class</h2>
 * <p>
 * Process for Displaying PolyExample2
 * </p>
 * 
 * @author User
 *
 */
public class PolyExample2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Shapes myShape = new Shapes(); // Create a Shapes object

        myShape.area();
        myShape.area(5);
        myShape.area(6.0, 1.2);
        myShape.area(6, 2);
    }

}
