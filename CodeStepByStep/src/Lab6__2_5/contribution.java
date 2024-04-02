package Lab6__2_5;

import java.util.Scanner;

public class contribution {
    static Scanner console = new Scanner(System.in);
    static int sum = 0;
    static int count1 = 0;
    static int count2 = 0;
    static int total = 0;

    public static void main(String[] args) {
        System.out.print("Is your money multiplied 1 or 2 times? ");
        int times = console.nextInt();

        System.out.print("And how much are you contributing? ");
        int donation = console.nextInt();

        if (times == 1) {
            sum = sum + donation;
            count1++;
            total = total + donation;
        } else {
            sum = sum + 2 * donation;
            count2++;
            total = total + donation;
        }
        
        System.out.println("Total contribution: " + total);
        System.out.flush();
    }
}