package week4;

// This program computes two people's body mass index (BMI) and
// compares them.  The code uses methods with parameters.

import java.util.Scanner;
import java.util.Random;

public class BMI {
    public static void main(String[] args) {
     
        intro();
        person(1);
        person(2);
        System.out.println("Have a nice day!");
    }
    
    // Displays a welcome message to the user.
    public static void intro() {
        System.out.println("This program reads data for two people");
        System.out.println("and computes their body mass index (BMI).");
        System.out.println();
 //       java.util.Date date = new java.util.Date();;
 //       System.out.println(date.toString());

    }
    
    // Reads investment info for one person.
    public static void person(int number) {
      Scanner input = new Scanner(System.in);
        System.out.println("Person " + number + "'s information:");
        System.out.println("height (in inches)? ");
        double height = input.nextDouble();
        System.out.println("weight (in pounds)? ");
        double weight = input.nextDouble();
        double bmi = weight * 703 / height / height;
        report(bmi);
    }
    
    // Outputs information about a person's BMI and weight status
    public static void report(double bmi) {
        System.out.printf("BMI = %.1f\n", bmi);
        if (bmi < 18.5) {
            System.out.println("class 1");
        } else if (bmi < 25) {
            System.out.println("class 2");
        } else if (bmi < 30) {
            System.out.println("class 3");
        } else {
            System.out.println("class 4");
        }
        System.out.println();
  //      Random random = new Random(3);
  //      System.out.print("\nFrom bmi: ");
  //      System.out.print(random.nextInt(10) + " ");


    }
}