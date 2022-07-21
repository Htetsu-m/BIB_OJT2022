package com.java.statement;

public class ContinueExample {

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
        for (int i = 0; i < 10; i++) {
            if (i == 6) {
                System.out.println();
                // using continue keyword
                // to skip the current iteration
                continue;
            }
            System.out.println(i);
        }
    }

}
