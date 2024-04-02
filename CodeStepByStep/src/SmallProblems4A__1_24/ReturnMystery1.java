package SmallProblems4A__1_24;

/*
 * The following console program uses returns and produces three lines of output. What are they?
 */

public class ReturnMystery1 {
    public static void main(String[] args) {
        int a = 4;
        int b = 2;
        int c = 5;
        a = mystery(c, b);
        c = mystery(b, a);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        }
        public static int mystery(int b, int c) {
        return c + 2 * b;
        }
}