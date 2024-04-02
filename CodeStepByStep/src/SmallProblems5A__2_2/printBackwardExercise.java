package SmallProblems5A__2_2;

/*
 * Write a method named printBackward that accepts a String as its parameter and prints the characters in the opposite order. For
 * example, a call of printBackward("hello there!"); should print the following output:
 * !ereht olleh
 * If the empty string is passed, no output should be produced.
 */
import java.util.Scanner;

public class printBackwardExercise {
    public static void main(String[] args) {
        System.out.print("Enter a word or phrase: ");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine(); // Read the input string
        printBackward(userInput); // Pass the input string to the printBackward method
        input.close(); // Close the Scanner object
    }

    public static void printBackward(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
    }
}