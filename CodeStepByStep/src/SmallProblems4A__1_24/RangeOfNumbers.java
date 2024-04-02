package SmallProblems4A__1_24;

/*
 * Write a console program in a class named RangeOfNumbers that prompts the user to type two integers 
 * and prints the sequence of numbers between the two arguments, separated by commas and spaces. Print 
 * an increasing sequence if the first argument is smaller than the second; otherwise, print a decreasing 
 * sequence. If the two numbers are the same, that number should be printed by itself. Here is an example 
 * dialogue:
 * 
 * Start? 2
 * End? 8
 * 2, 3, 4, 5, 6, 7, 8
 * 
 * Your program should also be able to count downward if the end is less than the start. For example:
 * 
 * Start? 18
 * End? 11
 * 18, 17, 16, 15, 14, 13, 12, 11 
 * 
 * If the start and end are the same, simply print that number a single time.
 * Start? 42
 * End? 42
 * 42
 */

import java.util.Scanner;

public class RangeOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the start and end numbers
        System.out.print("Start? ");
        int start = scanner.nextInt();
        System.out.print("End? ");
        int end = scanner.nextInt();

        if (start < end) {
            // Print the increasing sequence
            for (int i = start; i <= end; i++) {
                System.out.print(i);
                if (i < end) {
                    System.out.print(", ");
                }
            }
        } else if (start > end) {
            // Print the decreasing sequence
            for (int i = start; i >= end; i--) {
                System.out.print(i);
                if (i > end) {
                    System.out.print(", ");
                }
            }
        } else {
            // Start and end are the same, so print the number once
            System.out.print(start);
        }
        scanner.close();
    }
}
