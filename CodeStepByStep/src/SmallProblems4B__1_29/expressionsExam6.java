/*
 * Trace the evaluation of the following expressions, and give their resulting values. Make sure to give a value of the 
 * appropriate type (such as including "" quotes around a String or a .0 at the end of a double).
 */

package SmallProblems4B__1_29;

public class expressionsExam6 {
    public static void main(String[] args) {
        System.out.println(3 * (5 - 2) - 3 - 2 * 2);
        System.out.println(4 * 7 % 8 + 132 % 10 + 3 % 4);
        System.out.println(9 + 9 + "9 + 9" + 9 + 9);
        System.out.println(11 < 3 + 4 || !(5 / 2 == 2));
    }
}