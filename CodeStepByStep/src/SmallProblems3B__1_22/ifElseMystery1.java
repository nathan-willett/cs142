package SmallProblems3B__1_22;

public class ifElseMystery1 {
    public static void main(String[] args) {
    mystery(0);
    }
    public static void mystery(int n) {
        System.out.print(n + " ");
        if (n > 0) {
            n = n - 5;
        }
        if (n < 0 ) {
            n = n + 7;
        } else {
            n = n * 2;
        }
        System.out.println(n);
    }
}