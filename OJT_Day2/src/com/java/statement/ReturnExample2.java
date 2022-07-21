package com.java.statement;

class SumReturn {
    private int a;

    /**
     * <h2>Constructor for SumReturn</h2>
     * <p>
     * Constructor for SumReturn
     * </p>
     * 
     * @param i
     */
    public SumReturn(int i) {
        a = i;
    }

    /**
     * <h2>addition</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return SumReturn
     */
    public SumReturn addition() {
        SumReturn result = new SumReturn(a + 100);

        return result;
    }

    /**
     * <h2>display</h2>
     * <p>
     * 
     * </p>
     *
     * @return void
     */
    public void display() {
        System.out.println("Additon result: " + a);
    }
}

public class ReturnExample2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SumReturn obj1 = new SumReturn(50);
        SumReturn obj2;
        obj2 = obj1.addition();
        obj2.display();
    }

}
