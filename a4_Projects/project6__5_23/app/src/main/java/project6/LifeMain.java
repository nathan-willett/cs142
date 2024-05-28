package a4_Projects.project6__5_23.app.src.main.java.project6;

import java.util.Scanner;

/**
 * Class: LifeMain
 * 
 * The entry point for the program. This class handles user input and 
 * instantiates LifeModel and LifeGui.
 * 
 * @author Nathan Willett
 * @section 15596
 * @course CS 142, Spring 2024
 */
public class LifeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // welcome message and rules
        System.out.println("Welcome to the CS 142 Game of Life,");
        System.out.println("a simulation of the lifecycle of a bacteria colony.");
        System.out.println("Cells (X) live and die by the following rules:");
        System.out.println("- A cell with 1 or fewer neighbors dies.");
        System.out.println("- Locations with 2 neighbors remain stable.");
        System.out.println("- Locations with 3 neighbors will create life.");
        System.out.println("- A cell with 4 or more neighbors dies.\n");

        // prompt for the file name
        System.out.print("Grid input file name? ");
        String fileName = scanner.nextLine();

        // create a new LifeModel
        LifeModel model;
        try {
            model = new LifeModel(fileName);
        } catch (Exception e) {
            System.out.println("Failed to load the grid from the file: " + e.getMessage());
            scanner.close();
            return;
        }

        System.out.println(model);
        
        // instantiate the gui
        LifeGui gui = new LifeGui(model);

        // handle user commands
        while (running) {
            System.out.print("a)nimate, t)ick, q)uit? ");
            String command = scanner.nextLine().toLowerCase();

            if (command.equals("a")) {
                System.out.println("Starting animation...");
                gui.startAnimation();
            } else if (command.equals("t")) {
                System.out.println("Advancing one generation...");
                gui.update();
            } else if (command.equals("q")) {
                System.out.println("Quitting...");
                gui.stopAnimation();
                running = false;
            } else {
                System.out.println("Invalid command. Please enter 'a', 't', or 'q'.");
            }
        }

        scanner.close();
    }
}