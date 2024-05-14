package a1_CodeStepByStep.src.w6_exercises_B___5_13;

public class RecursionMystery5 {
    public static void main(String[] args) {
        System.out.println(recursionMystery5(11, 18));
        // System.out.println(recursionMystery5(26, 12));
        // System.out.println(recursionMystery5(32, 48));
    }

    public static int recursionMystery5(int a, int b) {
        if (a < 10 || b < 10) {
            return a + b;
        } else if (a > b) {
            int x = recursionMystery5(a / 2, b / 2);
            int y = recursionMystery5(b, a - b);
            return x + y;
        } else {
            return recursionMystery5(a, b / 2);
        }
    }
}
