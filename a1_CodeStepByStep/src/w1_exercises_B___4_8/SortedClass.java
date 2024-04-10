package a1_CodeStepByStep.src.w1_exercises_B___4_8;

// Sorted
/* Write a method named sorted that accepts an array of doubles as a parameter and returns true if the list is in sorted order and
false if not. For example, if an array named list stores {1.5, 4.3, 7.0, 19.5, 25.1, 46.2} respectively, the call of sorted(list) 
should return true. You may assume the array has at least one element. A one-element array is considered to be sorted. Do not modify 
the array passed in. */

public class SortedClass {
   public static void main(String[] args) {
      double[] list = {1.5, 4.3, 7.0, 19.5, 25.1, 46.2};
      System.out.println(sorted(list));
   }
   
   public static boolean sorted(double[] list) {
      for (int i = 0; i < list.length - 1; i++) {
         if (list[i] > list[i + 1]) {
            return false;
         }
      }
      return true;
   }
}