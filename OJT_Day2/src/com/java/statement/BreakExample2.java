package com.java.statement;

public class BreakExample2 {

    /**
     * <h2>main</h2>
     * <p>
     * 
     * </p>
     *
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for (int i = 0; i < 3; i++) {
            one: { // label one
                two: { // label two
                    three: { // label three
                        System.out.println("i=" + i);
                        if (i == 0)
                            break one; // break to label one
                        if (i == 1)
                            break two; // break to label two
                        if (i == 2)
                            break three; // break to label three
                    }
                    System.out.println("after label three");
                }
                System.out.println("after label two");
            }
            System.out.println("after label one");
        }
    }

}
