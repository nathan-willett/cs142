/*
 * Write a method named averageValueInFile that accepts a file name as a parameter and reads that file, assumed to be full 
 * of real numbers, and returns the average (mean) of the numbers in that file. The parameter, filename, gives the name of 
 * a file that contains a list of real numbers, one per line. You may assume that the file exists and follows the proper 
 * format. 
 * 
 * For example, if a file named input.txt contains the following numbers
 * 
 * 1.5
 * 2.75
 * 9.0
 * -3.25
 * 0.0
 * 6.5
 * 
 * Then the call of averageValueInFile("input.txt"); should return 2.75.
 * You may assume that the input file exists and is in the proper format. If the file does not contain any input values, 
 * return 0.0.
 * Constraints: Your solution should read the file only once, not make multiple passes over the file data.
 */

 package Lab9__2_11;

 import java.util.Scanner;
 import java.io.File;
 import java.io.FileNotFoundException;
 
 public class averageValueInFileClass {
     public static void main(String[] args) {
         // Capture the result of the method call and print it
         double result = averageValueInFile("input.txt");
         System.out.println(result);
     }
 
     public static double averageValueInFile(String fileName) {
        File file = new File(fileName);
        Scanner scanner = null;
        double sum = 0;
        int count = 0;

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextDouble()) {
                sum += scanner.nextDouble();
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return 0.0; // Return 0.0 in case of FileNotFoundException
        } finally {
            if (scanner != null) {
                scanner.close(); // Ensure the scanner is closed to avoid resource leaks
            }
        }
        
        // Calculate and return the average
        if (count > 0) {
            return sum / count;
        } else {
            return 0.0; // Return 0.0 if no numbers were found
        }
    }
 }