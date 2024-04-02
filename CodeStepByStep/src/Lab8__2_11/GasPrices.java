/*
 * Write a program named GasPrices that reads a file gasprices.txt. 
 * 
 * The file is formatted as follows:
 * Belgium $/gal US $/gal date. Example file:
 * 
 * 8.20 3.81 3/21/11
 * 8.08 3.84 3/28/11
 * 8.38 3.92 4/4/11
 * 8.62 4.03 4/11/11
 * 
 * The program should print the average gas price over all data in the file for both countries. For example, with 
 * the file contents above, your program should output:
 * Belgium average = 8.3
 * USA average = 3.9
 */

package Lab8__2_11;

import java.util.Scanner;

public class GasPrices {
    public static void main(String[] args) throws java.io.FileNotFoundException {
        // Create an instance of the file
        java.io.File file = new java.io.File("C:\\GitHub\\cs141\\CodeStepByStep\\src\\Lab8__2_11\\gasprices.txt");

        // Create a Scanner for the file
        Scanner input = new Scanner(file);

        int count = 0;
        double Bel_sum = 0;
        double US_sum = 0;

        while (input.hasNext()) {
            Bel_sum += input.nextDouble(); // Read and sum the Belgium total
            US_sum += input.nextDouble(); // Read and sum the US total (next value in list)
            input.next(); // Skip the date
            count ++; // Increment the count for each line processed
            // loops for as many lines of text as there are in the file
        }
        
        double Bel_avg = Bel_sum / count;
        double US_avg = US_sum / count;

        System.out.printf("Belgium average = $%.2f\n", Bel_avg);
        System.out.printf("USA average = $%.2f\n", US_avg);
        
        input.close();
    }
}
