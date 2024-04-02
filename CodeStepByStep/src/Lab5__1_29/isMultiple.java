package Lab5__1_29;

import java.util.Scanner;

/*
 * Write a method named isMultiple that accepts two non-negative integer parameters a and b, and returns true 
 * if a is a multiple of b, and false otherwise. For example, the call of isMultiple(15, 5) would return true 
 * because 15 = 5 * 3. You may assume that a and b are non-negative integers and that b is not 0.
 */

public class isMultiple {
    public static void main(String[] args) {
        isMultipleMethod(15, 3);
    }
    public static boolean isMultipleMethod(int a, int b) {
        return a % b == 0;
    }
}
