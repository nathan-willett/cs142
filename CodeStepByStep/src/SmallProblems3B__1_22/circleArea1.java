package SmallProblems3B__1_22;

/*
 * 
 * Write a method named circleArea that accepts the radius of a circle as a parameter (as a real number) and 
 * returns the area of a circle with that radius. For example, the call of circleArea(2.0) should return 
 * 12.566370614359172. You may assume that the radius passed is a non-negative number.
 * 
 */

public class circleArea1 {
    static double radius = 2.0;

    public static void main(String[] args) {
        System.out.println(circleArea(radius));
    }

    public static double circleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }
}