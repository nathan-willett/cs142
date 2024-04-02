/*
 * Write a complete console program in a class named SentinelSum that prompts the user for numbers until the user types -1, then 
 * outputs the sum of the numbers. Here is an example output:
 *
 * Type a number: 10
 * Type a number: 20
 * Type a number: 30
 * Type a number: -1
 * Sum is 60
 */

package Lab7__2_4;

import java.util.Scanner;

public class SentinelSum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int sum = 0; // This variable will store the sum of the numbers entered by the user.

        while (true) { // Infinite loop to keep asking the user for numbers.
            System.out.print("Type a number: ");
            int number = console.nextInt(); // Read the next integer entered by the user.

            if (number == -1) {
                break; // If the user enters -1, exit the loop.
            }

            sum += number; // Add the number entered by the user to the sum.
        }

        System.out.println("Sum is " + sum); // Output the sum of the numbers.
    }
}