package com.java.statement;

public class ReturnExample {
    /**
     * <h2>CompareNum</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return int
     */
    public int CompareNum() {
        int x = 3;
        int y = 8;
        System.out.println("x = " + x + "\ny = " + y);
        if (x > y)
            return x;
        else
            return y;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReturnExample obj = new ReturnExample();
        int result = obj.CompareNum();
        System.out.println("The greater number among x and y is: " + result);
    }

}
