package SmallProblems4B__1_29;

/*
 * For each call to the following method, indicate what output is produced.
 */

public class ifElseMystery2 {
    public static void main(String[] args) {
        mystery2(7, 6); // pass a and b to mystery2
    }

    public static void mystery2(int a, int b) {
        if (a % b == 0) {
            a = a / b;
            if (a < b) {
                b = b - a;
            }
        } else if (b % 2 == 0) {
            b = b / 2;
        } else {
            a = a - b;
        }
        System.out.println(a + " " + b);
    }
}