package week5;

// Allison Obourn
// CS 142, Spring 2024
// Lecture 17

// Prints out arrays of integers read from the file small.csv. Then prints
// out the integers read from small.csv one number per line. Finally outputs
// the result of raising three to the fourth power.

import java.io.*;
import java.util.*;

public class Recursion {
   public static void main(String[] args) throws FileNotFoundException {
      readCsvWithSplit();
      readCsvWithScanner();
      
      int answer = pow(3, 4);
      System.out.println("3 ^ 4 = " + answer);
  }
  
  // takes a base and an exponent and returns the base
  // raised to that exponent. 
  public static int pow(int base, int exponent) {
      if(exponent == 0) {
         return 1;
      } else if(exponent % 2 == 0) {
         return pow(base * base, exponent / 2); 
      } else {
         return base * pow(base, exponent - 1);
      }
  }
  
  // reads the lines of a file containing numbers separated by commas, 
  // splitting each line into an array of its individual numbers and 
  // printing it out.  
   public static void readCsvWithSplit() throws FileNotFoundException {
      Scanner input = new Scanner(new File("small.csv"));
      // read the file line by line
      while(input.hasNextLine()) {
         String line = input.nextLine(); 
         // split the array on commas so we have an array of strings with
         // each number in its own spot as a string
         String[] stringArray = line.split(",");
         int[] row = new int[stringArray.length];
         // convert each string to an int and store it in an int array
         for(int i = 0; i < row.length; i++) {
            row[i] = Integer.parseInt(stringArray[i]);
         }
         // print out the row
         System.out.println(Arrays.toString(row));
       }
   }
   
  // reads the lines of a file containing numbers separated by commas, 
  // splitting each line into its individual numbers and printing it out. 
   public static void readCsvWithScanner() throws FileNotFoundException {
      Scanner input = new Scanner(new File("small.csv"));
      // read the file line by line
      while(input.hasNextLine()) {
         String line = input.nextLine();
         // read the line token by token as integers
         Scanner lineScan = new Scanner(line);
         lineScan.useDelimiter(","); // the scanner will now split on ,
         while(lineScan.hasNextInt()) {
            // print out the current number
            int data = lineScan.nextInt();
            System.out.println(data);
         }
       }
   }
}