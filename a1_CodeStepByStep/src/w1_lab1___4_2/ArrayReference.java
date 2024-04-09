package src.w1_lab1___4_2;

public class ArrayReference {
    public static void main(String[] args) {
        int[] nums = { 2, 4, -1, 3 };
        incrementAll(nums);

        System.out.println(nums[0]);
        System.out.println(nums[1]);
        System.out.println(nums[2]);
        System.out.println(nums[3]);
    }

    // increments the value of each element in the array by one
    public static void incrementAll(int[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i]++;
        }
    }
}
