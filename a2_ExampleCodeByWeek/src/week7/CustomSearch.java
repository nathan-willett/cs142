// Allison Obourn
// CS 142, Spring 2024
// Lecture 23

// Creates an array of 10 rectangle objects with sides random lengths
// between 0 and 10 and then searches it for a rectangle that is 9 by 7
// and prints out the list and the result

import java.util.*;

public class CustomSearch {
   public static void main(String[] args) {
      // creating the array of 10 random rectangles
      Rectangle[] list = new Rectangle[10];
      Random rand = new Random();
      for(int i = 0; i < 10; i++) {
         // side lengths 0 - 10
         list[i] = new Rectangle(rand.nextInt(10), rand.nextInt(10));
      }
      
      // another rectangle to search for
      Rectangle r = new Rectangle(9, 7);
      
      // search the list
      int result = Arrays.binarySearch(list, r);
      
      System.out.println("Searching for " + r + " returned " + result);
      System.out.println("The list stores: " + Arrays.toString(list));
   }
}