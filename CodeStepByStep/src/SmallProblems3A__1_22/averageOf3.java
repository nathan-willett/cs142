package SmallProblems3A__1_22;

/*
 * Write a method named averageOf3 that accepts three integers as parameters and returns the average of the three integers 
 * as a real number. For example, the call of averageOf3(4, 7, 13) returns 8.0.
 */

public class averageOf3 {
    static int one = 1;
    static int two = 2;
    static int three = 3;

    public static void main(String[] args) {
        System.out.println(averageOf3(one, two, three));
    }

    public static double averageOf3(int one, int two, int three) {
        return (one + two + three) / 3.0;
    }
}