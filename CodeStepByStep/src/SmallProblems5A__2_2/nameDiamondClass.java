/*
 * Write a method named nameDiamond that accepts a string as a parameter and prints it in a "diamond" format 
 * as shown below. For example, the call of nameDiamond("MARTY"); should print:
 * 
 *   M
 *   MA
 *   MAR
 *   MART
 *   MARTY
 *    ARTY
 *     RTY
 *      TY
 *       Y
 */

package SmallProblems5A__2_2;

public class nameDiamondClass {
    public static void main(String[] args) {
        nameDiamond("MARTY");
    }

    public static void nameDiamond(String name) {
      // First part: print the name in an increasing manner
      for (int i = 0; i < name.length(); i++) {
          for (int j = 0; j <= i; j++) {
              System.out.print(name.charAt(j));
          }
          System.out.println();
      }

      // Second part: print the name in a decreasing manner, without the     first character each time
      for (int i = 1; i < name.length(); i++) {
          for (int j = 0; j < i; j++) {
              System.out.print(" "); // Print leading spaces
          }
          for (int j = i; j < name.length(); j++) {
              System.out.print(name.charAt(j));
          }
          System.out.println();
        }
    }
}