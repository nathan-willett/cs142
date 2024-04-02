// CS& 141, Fall 2023
// This program creates an array containing the numbers 0 to 5 inclusive.
// It then reverses the array and prints it out twice. Finally, it computes 
// the most frequent digit in a big number, prints out the count of occurrences
// of each digit and then the digit that had the most occurrences. 
// Allison Obourn

package week7;

import java.util.*;

public class Reverse {
   public static void main(String[] args) {
      int[] array = arrayCreate(6);
      int a = 4;
      System.out.println("Original: " + Arrays.toString(array));
      reverse(array, a);
      // print out the changed value of array and the value of "a" which remains the 
      // same as before the call as it was copied
      System.out.println("Main: " + Arrays.toString(array) + " " + a);
      
      int most = mostFrequentDigit(723493843);
      System.out.println(most + " occurs the most times in 723493843");
   }
   
   // takes an array and an integer value as parameters. Reverses the contents of
   // the array in place, adds one to the number and prints out both. 
   public static void reverse(int[] array, int a) {
      // starting from both ends swap pairs of elements one pair at a time moving
      // inward until reaching the middle
      for(int i = 0; i < array.length / 2; i++) {
         int start = i;
         int end   = array.length - 1 - i;
         int temp = array[start];
         array[start] = array[end];
         array[end] = temp;
      }
      a++;
      //print out the changed values of array and "a"
      System.out.println("Method: " + Arrays.toString(array) + " " + a);
   }
   
   // takes a desired length as a parameter and returns an array that is that
   // length and contains the numbers 0 to the length (exclusive).
   // Precondition: the passed in length is 0 or greater
   public static int[] arrayCreate(int length) {
      int[] array = new int[length];
      for(int i = 0; i < array.length; i++) {
         array[i] = i;
      }
      return array;
   }
   
   // returns the most frequently occurring digit in the passed in number
   // prints out the counts of each digit in the number.
   // Precondition: the number is greater than 0
   public static int mostFrequentDigit(int n) {
      int[] counts = new int[10]; 
      while(n > 0) {
         int last = n % 10;// extract the last digit
         n /= 10; // remove the last digit from the number
         counts[last]++; // add one to the count of that digit
      }
  //    System.out.println("Frequent: " + Arrays.toString(counts));
      
      // go through the counts to see which is biggest. 
      int maxCount = 0;
      int maxIndex = 0;
      for(int i = 0; i < counts.length; i++) {
         if(counts[i] > maxCount) {
            maxCount = counts[i];
            maxIndex = i;
         }
      }
      // return the index of the biggest count
      return maxIndex;
   }
}