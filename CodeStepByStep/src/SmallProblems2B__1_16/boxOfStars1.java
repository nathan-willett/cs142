package SmallProblems2B__1_16;

/*
 *
 * Write a method named boxOfStars that accepts two integer parameters representing a width and height in characters, 
 * and prints to the console a 'box' figure whose border is * stars and whose center is made of spaces. For example, 
 * the call of boxOfStars(8, 5); should print the following output:
 *
 *   ********
 *   *      *
 *   *      *
 *   *      *
 *   ********
 * 
 * You may assume that the values passed for the width and height are at least 2.
 * 
 */

public class boxOfStars1 {
    public static void main(String[] args) {
        boxOfStars(16, 10);
    }

    public static void boxOfStars(int width, int height) {
        // Print the top border
        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();

        // Print the middle part with spaces
        for (int i = 1; i < height - 1; i++) {
            System.out.print("*");
            for (int j = 1; j < width - 1; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }

        // Print the bottom border
        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}