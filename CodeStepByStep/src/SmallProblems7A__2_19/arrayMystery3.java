/*
 * Consider the following method:
 * 
 * public static void mystery3(int[] nums) {
 *     for (int i = 0; i < nums.length - 1; i++) {
 *         if (nums[i] > nums[i + 1]) {
 *             nums[i + 1]++;
 *         }
 *     }
 * }
 * 
 * For each array below, indicate what the array's contents would be after 
 * the method mystery were called and passed that array as its parameter.
 */

package SmallProblems7A__2_19;

import java.util.Arrays;

public class arrayMystery3 {
    public static void main(String[] args) {
        int[] nums = {12, 11, 10, 10, 8, 7};
        System.out.println(Arrays.toString(mystery3(nums)));
    }

    public static int[] mystery3(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
            nums[i + 1]++;
            }
        }
        return nums;
    }           
}