package week4;

// Allison Obourn
// CS 142, Spring 2024
// Lecture 16

// Prints out a line of two stars, a line of dashes and then a
// line of four stars and a line of 10 stars. It then prints the 
// contents of a text file line by line in reverse order.

import java.util.*;
import java.io.*;

public class PrintStars {
   public static void main(String[] args) throws FileNotFoundException {
      printStars(2);
      System.out.println("----");
      printStars(4);
      printStars(10);
      
      System.out.println();
      Scanner input = new Scanner(new File("poem.txt"));
      reverseLines(input);
   }
   
   // Prints out a line of stars the length of the passed in 
   // integer and then moves to a new line. 
   // WARNING: This is not good style code! We will fix it next class
   public static void printStars(int n) {
      if(n == 0) {
         System.out.println();
      } else {
         System.out.print("*"); // solve one small part of the problem
         printStars(n - 1); // ask someone else to solve the rest
      }
   }
   
   // takes a Scanner over an input to be printed line by line in reverse
   // and prints it with the last line output, then the second to last, etc
   // until the entire contents has been printed.
   // precondition: input is not null
   public static void reverseLines(Scanner input) {
      // base case - the file is empty so we don't need to do anything
      if(input.hasNextLine()) {
         // read the next line
         String line = input.nextLine();
         // print the rest in reverse order
         reverseLines(input);
         // print the line
         System.out.println(line);
      }
   }
}