package Quiz4__1_31;

import java.util.Scanner;
import java.util.Random;

public class q4Problem6 {

    public static void ProblemSolver(Scanner console, int count) {
        Random rand = new Random();
        int correctAnswers = 0;

        for (int i = 0; i < count; i++) {
            int num1 = rand.nextInt(5) + 1; // Generates a number between 1 and 5
            int num2 = rand.nextInt(5) + 1; // Generates another number between 1 and 5
            int answer = num1 * num2;

            // Prompt the user
            System.out.print(num1 + " * " + num2 + " =? ");
            int userAnswer = console.nextInt();

            // Check the answer
            if (userAnswer == answer) {
                System.out.println("correct");
                correctAnswers++;
            } else {
                System.out.println("incorrect...the answer was " + answer);
            }
        }

        // Report the overall results
        System.out.println(correctAnswers + " of " + count + " correct");
    }

    public static void main(String[] args) {
        // Example usage
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the number of problems: ");
        int count = console.nextInt();
        ProblemSolver(console, count);
    }
}
