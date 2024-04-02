package Lab4__1_29;

/*
 * Modify your code from the previous exercise so that it could easily be modified to display a different range 
 * of numbers (instead of 1234567890) and a different number of repetitions of those numbers (instead of 60 total 
 * characters), with the vertical bars still matching up correctly. Write a complete class named NumbersOutput. 
 * Use two class constants instead of "magic numbers,", with one constant set to 6 for the number of repetitions, 
 * and the other set to 10 for the range of numbers. Put the for loop code in your class's main method.
 *
 * For example, if your number-of-repetitions constant is set to 7 and your range constant is set to 5, the output should be the following:
 */

 public class NumbersOutput {
    public static final int NUMBER_OF_REPETITIONS = 6; // Adjust this for the number of repetitions
    public static final int RANGE = 10; // Adjust this for the range of numbers

    public static void main(String[] args) {
        // First line with vertical bars '|'
        for (int i = 0; i < NUMBER_OF_REPETITIONS; i++) {
            for (int j = 1; j < RANGE; j++) { // RANGE - 1 spaces, since we print '|' after
                System.out.print(" ");
            }
            System.out.print("|");
        }
        System.out.println(); // End of the first line

        // Second line with numbers
        for (int i = 0; i < NUMBER_OF_REPETITIONS * RANGE; i++) {
            // When i % RANGE is 9, we should print '0' instead of '10'
            System.out.print(i % RANGE == 9 ? 0 : (i % RANGE) + 1); // Print numbers 1-9 followed by 0
        }
        System.out.println(); // End of the second line
    }
}
