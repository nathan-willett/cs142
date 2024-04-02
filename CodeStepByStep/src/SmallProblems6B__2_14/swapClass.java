/*
 * Write a method called swap that accepts an array of integers and two indexes as parameters and swaps the elements 
 * at those indexes.
 * 
 * int[] a1 = {12, 34, 56};
 * swap(a1, 1, 2);
 * System.out.println(Arrays.toString(a1));
 * 
 * The above code should output [12, 56, 34].
 */

package SmallProblems6B__2_14;

import java.util.Arrays;

public class swapClass {
    public static void main(String[] args) {
        int[] a1 = {12, 34, 56};
        swap(a1, 1, 2);
        System.out.println(Arrays.toString(a1)); // Expected output: [12, 56, 34]
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i]; // Save the original value of a[i] in temp
        a[i] = a[j];     // Assign the value of a[j] to a[i]
        a[j] = temp;     // Assign the saved original value of a[i] (in temp) to a[j]
    }
}