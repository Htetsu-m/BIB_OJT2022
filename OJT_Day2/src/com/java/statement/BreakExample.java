package com.java.statement;

public class BreakExample {

    /**
     * <h2> main</h2>
     * <p>
     * 
     * </p>
     *
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 10;
        for (int i = 0; i < n; i++) {
            if (i == 6)
                break;
            System.out.println(i);
        }
    }

}
