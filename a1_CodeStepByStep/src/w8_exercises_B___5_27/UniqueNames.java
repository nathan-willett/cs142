package a1_CodeStepByStep.src.w8_exercises_B___5_27;

import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;

public class UniqueNames {
    public static void main(String[] args) {
        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        Set<String> names = new LinkedHashSet<>();

        while (run) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                run = false; // Exit the loop if the user enters a blank line
            }

            // Add the name to the map
            names.add(name);
        }

        // Print out the unique names
        System.out.print("Unique name list contains: ");
        for (String name : names) {
            System.out.print(name + " ");
        }

        scanner.close();
    }
}