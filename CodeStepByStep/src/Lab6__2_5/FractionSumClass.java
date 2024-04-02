/*
 * Write a method called fractionSum that accepts an integer parameter n and returns as a double the sum of the first n terms of 
 * the sequence:
 * 
 * In other words, the method should generate the following sequence:
 *
 * 1 + (1/2) + (1/3) + (1/4) + (1/5) + ...
 *
 * You may assume that the parameter n is non-negative.
 */

 package Lab6__2_5;

 public class FractionSumClass {
     public static double fractionSum(int n) {
         int denominator = 1;
         double sum = 0.0;
         for (int i = 1; i <= n; i++) { // Start from i = 1
             sum += 1.0 / denominator;
             denominator++; // Increment the denominator for the next term
         }
         return sum;
     }
 
     public static void main(String[] args) {
         int n = 5; // Example: Calculate the sum of the first 5 terms
         double result = fractionSum(n);
         System.out.println("Sum of the first " + n + " terms: " + result);
     }
 }