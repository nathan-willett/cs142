package SmallProblems4A__1_24;

/*
 * What's wrong with the following code? Modify it to produce the intended output. Make sure to properly utilize if/else/if 
 * statements to avoid redundancy and avoid unnecessary tests. Do not use && or || in your solution.
 *
 * What percentage did you earn? 87
 * You got a B!
 */

import java.util.Scanner;

public class percentageGrade {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("What percentage did you earn? ");
        int percent = console.nextInt();
        if (percent >= 90) {
            System.out.println("You got an A!"); 
        }
        else if (percent >= 80) {
            System.out.println("You got a B!");
        }
        else if (percent >= 70) {
            System.out.println("You got a C!");
        }
        else if (percent >= 60) {
            System.out.println("You got a D!");
        }
        else {
            System.out.println("You got an F!");
        }
        console.close();
    }
}
