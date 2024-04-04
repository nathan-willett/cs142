package w1_lab1___4_2;

import java.util.Arrays;

public class ArrayReference {
    public static void main(String[] args) {
        int[] nums = { 2, 4, -1, 3 };
        incrementAll(nums);
        // HERE!
        System.out.println(Arrays.toString(nums[0]));
    }

    public static void incrementAll(int[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i]++;
        }
    }
}
