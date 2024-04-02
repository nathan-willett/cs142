package week2;

 // This is an example of the call of a method that accepts parameters 

import java.util.Scanner;

public class GPSLocations {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      // Prompt the user to enter four points
      System.out.print("Enter four points: ");

      double Atlanta = input.nextDouble();
      double Charlotte = input.nextDouble();
      double Savannah = input.nextDouble();
      double Orlando = input.nextDouble();

      GPS(Atlanta, Charlotte, Savannah, Orlando);
    }

    public static void GPS(double Atlanta, double Charlotte, double Savannah, double Orlando) {
        System.out.println(Atlanta + " and " + Charlotte + " and " + Savannah + " and " + Orlando);
    }
}