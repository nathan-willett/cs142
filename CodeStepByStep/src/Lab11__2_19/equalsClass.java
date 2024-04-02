/*
 * Write a method named equals that accepts a pair of arrays of integers as parameters and returns true if the arrays contain
 * the same elements in the same order. If the arrays are not the same length, your method should return false.
 * 
 * For example, if the following arrays are declared:
 * 
 * int[] a1 = {10, 20, 30, 40, 50, 60};
 * int[] a2 = {10, 20, 30, 40, 50, 60};
 * int[] a3 = {20, 3, 50, 10, 68};
 * 
 * The call equals(a1, a2) returns true but the call equals(a1, a3) returns false.
 */
package Lab11__2_19;

public class equalsClass {
    public static void main(String[] args) {
        // Initialize arrays a1, a2, a3
        int[] a1 = {10, 20, 30, 40, 50, 60};
        int[] a2 = {10, 20, 30, 40, 50, 60};
        int[] a3 = {20, 3, 50, 10, 68};

        // Print the results of the methods
        System.out.println(equals(a1, a2));
        System.out.println(equals(a1, a3));
    }

    public static boolean equals(int[] a, int[] b) {
        // if a and b are the same length
        if (a.length == b.length) {

            // then for each element of 'a'
            for (int i = 0; i < a.length; i++) {

                // check if the values of 'a' and 'b' are not the same
                if (a[i] != b[i]) {
                    
                    return false; // if so, return false
                }
            }
            return true; // if all values are the same, return true
        }
        return false; // if arrays 'a' and 'b' are not the same, return false
    }
}