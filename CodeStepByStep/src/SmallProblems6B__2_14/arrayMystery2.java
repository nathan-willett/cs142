/*
 * Consider the following method:
 * 
 * For each array below, indicate what the array's contents would be after the method mystery 
 * were called and passed that array as its parameter.
 */

package SmallProblems6B__2_14;

import java.util.Arrays;

public class arrayMystery2 {
    public static void main(String[]args) {
        int[] list = {6, 3};
        mystery2(list); // Call the mystery2 method to modify the array
        System.out.println(Arrays.toString(list)); // Print the modified array
    }

    public static void mystery2(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            if (i % 2 == 0) {
                list[i]++;
            } else {
                list[i]--;
            }
        }
    }
}