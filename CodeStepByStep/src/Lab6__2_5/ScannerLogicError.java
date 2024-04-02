package Lab6__2_5;

import java.util.Scanner;

public class ScannerLogicError {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Type a number: ");
        int number = console.nextInt();
        if (number % 2 == 0) {
            if (number % 3 == 0) {
                System.out.println("Divisible by 6.");
            }
        } else {
            System.out.println("Odd.");
        }
        console.close();
    }
}