/*
 * What element values are stored in a after the
 * following code runs?
 * 
 * int[] a = {1, 7, 5, 6, 4, 14, 11};
 * for (int i = 0; i < a.length - 1; i++) {
 *     if (a[i] > a[i + 1]) {
 *         a[i + 1] = a[i + 1] * 2;
 *     }
 * }
 * 
 */

package SmallProblems7A__2_19;

public class arrayMystery7 {
    public static void main(String[] args) {
        int[] a = {1, 7, 5, 6, 4, 14, 11};
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                a[i + 1] = a[i + 1] * 2;
            }
        }
        System.out.println();
    }
}