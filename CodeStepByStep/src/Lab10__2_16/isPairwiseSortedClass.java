/*
 * Write a static method called isPairwiseSorted that takes an array of integers as a parameter and that returns 
 * whether or not the array is pairwise sorted. An array is considered to be pairwise sorted if it contains a 
 * sequence of pairs where each pair is in sorted (nondecreasing) order. For example, if a variable list is 
 * defined as follows:
 * 
 * int[] list = {3, 8, 2, 15, -3, 5, 2, 3, 4, 4};
 * 
 * then the call isPairwiseSorted(list) would return true because the array is composed of a sequence of pairs 
 * that are each in sorted order ((3, 8) followed by (2, 15), followed by (-3, 5), and so on). If the array has 
 * an odd length, then your method should ignore the value at the end. Below are several examples of what value 
 * would be returned for a given array.
 * 
 * Array passed as parameter:	            Value Returned:
 * 
 * {}	                                        true
 * {6}	                                        true
 * {4, 12}	                                    true
 * {8, 5}	                                    false
 * {3, 8, 2, 15, -3, 5, 2, 3, 4, 4, 3, 1}	    false
 * {8, 13, 92, 92, 4, 4}	                    true
 * {1, 3, 5, 7, 9, 8}	                        false
 * 
 * You may not construct any extra data structures to solve this problem.
 */

package Lab10__2_16;

public class isPairwiseSortedClass {
    public static void main(String[] args) {
        int[] array = {4, 12};
        System.out.println(isPairwiseSorted(array)); // Print the result of the isPairwiseSorted method
    }

    public static boolean isPairwiseSorted(int[] array) {
        // Loop through the array in steps of 2 to check pairs
        for (int i = 0; i < array.length - 1; i += 2) {
            // Check if the current pair is not in nondecreasing order
            if (array[i] > array[i + 1]) {
                return false; // Return false immediately if a pair is not sorted
            }
        }
        // If we didn't find any unsorted pairs, return true
        return true;
    }
}