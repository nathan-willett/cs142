/*
 * For each of the five points labeled by comments, identify each of the assertions in the table below as either being
 * always true, never true, or sometimes true / sometimes false.
 */

package SmallProblems5B__2_5;

public class assertions1 {
    public static void main(String[] args) {
        mystery(2, 5);
        mystery(1, 6);
        mystery(-4, 3);
    }

    public static void mystery(int x, int y) {
        int z = 0;
        // Point A
        while (x >= y) {
            // Point B
            x = x - y;
            z++;
            if (x != y) {
                // Point C
                z = z * 2;
            }
            // Point D
        }
        // Point E
        System.out.println(z);
    }
}