/*
 * Write a method named reverse that accepts an array of integers as a parameter and modifies the array to be
 * in reverse order. For example, if the array a stores {10, -2, 33, 55, 9}, the call of reverse(a) should 
 * modify it to store {9, 55, 33, -2, 10}.
 */

package Lab10__2_16;

import java.util.Arrays;

public class reverseClass {
    public static void main(String[] args) {
        int[] array = {10, -2, 33, 55, 9};
        reverse(array);
        System.out.println(Arrays.toString(array));
    }

    public static void reverse(int[] array) {
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = temp;
        }
    }
}