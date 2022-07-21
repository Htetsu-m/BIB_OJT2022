package com.java.condition;

public class SwitchExample1 {

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
        String levelString = "Expert";
        int level = 0;
        switch (levelString) {
        // Using String Literal in Switch case
        case "Beginner":
            level = 1;
            break;
        case "Intermediate":
            level = 2;
            break;
        case "Expert":
            level = 3;
            break;
        default:
            level = 0;
            break;
        }
        System.out.println("Your Level is: " + level);
    }

}
