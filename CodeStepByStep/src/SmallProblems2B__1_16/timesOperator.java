package SmallProblems2B__1_16;

/*
 *
 * Suppose a real number variable x is defined. Write a single Java statement that stores as a variable y the result of the computation below, 
 * modifying the expression to use the * operator exactly four times when computing an equivalent value. (Hint: how could you factor out x here?)
 * 
 * y = 12.3x4 - 9.1x3 + 19.3x2 - 4.6x + 34.2
 * 
*/

public class timesOperator {
    public static void main(String[] args) {
        double x = 3;
        double y = x * (x * (x * (12.3 * x - 9.1) + 19.3) - 4.6) + 34.2;
        System.out.println(y);
    }
}