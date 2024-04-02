package SmallProblems3B__1_22;

/*
 * The following code generates four lines of output. What are they?
 */

public class printMaxMin {
    public static void main(String[] args) {
        int max;
        int min = 10;
        max = 17 - 4 / 10;
        max = max + 6;
        min = max - min;
        System.out.println(max * 2);
        System.out.println(max + min);
        System.out.println(max);
        System.out.println(min);
    }
}