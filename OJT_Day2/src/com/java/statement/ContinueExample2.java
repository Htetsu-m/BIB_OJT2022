package com.java.statement;

public class ContinueExample2 {

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
        int i;
        for (i = 1; i <= 10; i++) {
            if (i == 5)
                continue;
            System.out.println(i);
        }
    }

}
