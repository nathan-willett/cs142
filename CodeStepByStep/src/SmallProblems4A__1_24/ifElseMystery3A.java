package SmallProblems4A__1_24;

/*
 * For each call to the following method, indicate what output is produced.
 */

public class ifElseMystery3A {
    public static void main(String[] args) {
        mystery(40);
        mystery(8);
        mystery(0);
        mystery(12);
        mystery(20);
    }
    
    public static void mystery(int n) {
        System.out.print(n + " ");
        if (n > 10) {
            n = n / 2;
        } else {
            n = n + 7;
        }
        if (n * 2 < 25) {
            n = n + 10;
        }
        System.out.println(n);
    }
}
