//package a4_Projects.project6__5_23.app.src.main.java.project6;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Class: LifeModel
 * 
 * This class represents the current state of the model. Each cell can be alive
 * or dead. The class updates the grid at each interval in the simulation. 
 * 
 * @author Nathan Willett
 * @section 15596
 * @course CS 142, Spring 2024
 */
public class LifeModel {
    private boolean[][] grid; // a 2-d array storing the values (alive or dead) of each grid cell
    private int rows; // the number of rows
    private int cols; // the number of columns

    // Constructs a LifeModel that stores a grid of the data in the passed in file
    public LifeModel(String fileName) {
        try {
            Scanner fileScanner = new Scanner(new File(fileName));

            if (!fileScanner.hasNextInt()) {
                throw new IllegalArgumentException("Invalid file format: missing number of rows.");
            }
            rows = fileScanner.nextInt();

            if (!fileScanner.hasNextInt()) {
                throw new IllegalArgumentException("Invalid file format: missing number of columns.");
            }
            cols = fileScanner.nextInt();
            fileScanner.nextLine(); // read the next line

            grid = new boolean[rows][cols];
            for (int i = 0; i < rows; i++) {
                if (!fileScanner.hasNextLine()) {
                    throw new IllegalArgumentException("Invalid file format: missing grid data.");
                }
                String line = fileScanner.nextLine();
                if (line.length() != cols) {
                    throw new IllegalArgumentException("Invalid file format: incorrect number of columns in row " + i);
                }
                for (int j = 0; j < cols; j++) {
                    char cell = line.charAt(j);
                    if (cell != 'X' && cell != '-') {
                        throw new IllegalArgumentException("Invalid file format: unexpected character '" + cell + "' at row " + i + ", col " + j);
                    }
                    grid[i][j] = cell == 'X';
                }
            }
            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            System.exit(1); // Exit the program if the file is not found
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1); // Exit the program if the file format is invalid
        }
    }

    // gets the total number of rows
    public int getRows() {
        return rows;
    }

    // gets the total number of columns
    public int getCols() {
        return cols;
    }

    // returns the value of the cell, true if alive, false if dead
    public boolean isAlive(int row, int col) {
        return grid[row][col];
    }

    // updates the model to the next version of the bacteria's state
    public void update() {
        boolean[][] newGrid = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int neighbors = countAliveNeighbors(row, col);
                if (grid[row][col]) {
                    newGrid[row][col] = neighbors == 2 || neighbors == 3;
                } else {
                    newGrid[row][col] = neighbors == 3;
                }
            }
        }
        grid = newGrid;

        // Debug print statement to show the updated grid state
        // System.out.println("Updated grid state:");
        System.out.println(this);
    }

    // counts the number of alive neighbors for a given cell
    private int countAliveNeighbors(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue; // skip the cell itself
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Returns a string representation of the grid. "–" characters represent empty
    // cells and "X" characters represent live cells.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(grid[i][j] ? 'X' : '-');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
