package week4;

import java.util.Random;

public class mathexpressions {
  public static void main(String[] args) {

   double x = Math.random();
   System.out.println("x is " + x);
   
   double y = 12 / 5 + 8 / 4;
   System.out.println("\ny: " + y);
   double z = 3 * 4 + 15 / 2;
   System.out.println("\ny: " + z);
   
   Random random1 = new Random(3);
   System.out.print("From random1: ");
   for (int i = 0; i < 10; i++)
     System.out.print(random1.nextInt(1000) + " ");
      
   Random random2 = new Random(3);
   System.out.print("\nFrom random2: ");
   for (int i = 0; i < 10; i++)
     System.out.print(random2.nextInt(1000) + " ");

  }
}