/*
 * Write a method named coinFlip that accepts as its parameter a string holding a file name, opens that file and reads its 
 * contents as a sequence of whitespace-separated tokens. Assume that the input file data represents results of sets of coin 
 * flips. A coin flip is either the letter H or T, or the word Heads or Tails, in either upper or lower case, separated by at 
 * least one space. You should read the sequence of coin flips and output to the console the number of heads and the percentage 
 * of heads in that line, rounded to the nearest whole number. If this percentage is 50% or greater, you should print a "You 
 * win!" message; otherwise, print "You lose!". For example, consider the following input file:
 * 
 * H  T H  H    T
 * Tails taIlS   tAILs TailS heads   HEAds
 *    hEadS
 * For the input above, your method should produce the following output:
 * 
 * 6 heads (50%)
 * You win!
 * 
 * The format of your output must exactly match that shown above. You may assume that the file contains at least 1 token of input, 
 * and that no tokens other than heads/tails or H/T will be in the lines. You may assume that the input file exists and is readable.
 * 
 * Constraints: Your solution should read the file only once, not make multiple passes over the file data.
 */

package SmallProblems6A__2_11;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class coinFlipClass {
    public static void main(String[] args) {
        String fileName = "CodeStepByStep\\src\\SmallProblems6A__2_11\\coinInput.txt"; // store the file name
        coinFlip(fileName);
    }

    public static void coinFlip(String fileName) {
        try {
            File coinInputFile = new File(fileName); // create a file instance to reference the file
            Scanner scanner = new Scanner(coinInputFile); // create a scanner instance to read from the file

            int totalFlips = 0;
            int totalHeads = 0;
            int totalTails = 0;
            
            while (scanner.hasNext()) {
                String result = scanner.next().toLowerCase(); // convert all to lower case to make input case insensitive
                char firstChar = result.charAt(0);

                if (firstChar == 'h') {
                    totalHeads++;
                } else if (firstChar == 't') {
                    totalTails++;
                } else {
                    throw new RuntimeException("Invalid input: Neither 'h' nor 't' found at the beginning of a token.");
                }
                totalFlips++; // increment flip count by one
            }
            // calculate percentage of flips that landed heads
            double percentageHeads = (double) totalHeads / totalFlips * 100;

            // Output results
            System.out.printf("%d heads (%d%%)\n", totalHeads, Math.round(percentageHeads));
            if (percentageHeads >= 50) {
                System.out.println("You win!");
            } else {
                System.out.println("You lose!");
            }

            scanner.close(); // Close the scanner to release system resources

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}