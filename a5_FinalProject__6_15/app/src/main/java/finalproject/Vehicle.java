package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import java.awt.Color;
import java.util.Random;

/**
 * Represents a vehicle in the traffic simulation.
 * The vehicle moves randomly within a grid, which
 * contains different types of cells (road and intersection).
 * Vehicles can only move to adjacent cells that are instances of `RoadCell`.
 */

public class Vehicle {
    private Cell currentCell; // The current cell where the vehicle is located.
    private Color color; // The color of the vehicle.
    private Random random; // Random number generator for determining the vehicle's movement direction.

    /**
     * Constructs a vehicle with a starting cell and a specified color.
     *
     * @param startCell The starting cell for the vehicle.
     * @param color     The color of the vehicle.
     */
    public Vehicle(Cell startCell, Color color) {
        this.currentCell = startCell;
        this.color = color;
        this.random = new Random();
    }

    /**
     * Moves the vehicle to a new cell.
     *
     * @param newCell The cell to move the vehicle to.
     */
    public void move(Cell newCell) {
        this.currentCell = newCell;
    }

    /**
     * Returns the current cell of the vehicle.
     *
     * @return The current cell of the vehicle.
     */
    public Cell getCurrentCell() {
        return currentCell;
    }

    /**
     * Returns the color of the vehicle.
     *
     * @return The color of the vehicle.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Updates the vehicle's position on the grid.
     * The vehicle moves to an adjacent cell in a random direction (up, down, left,
     * or right).
     * The vehicle only moves if the next cell is a RoadCell.
     *
     * @param grid The grid in which the vehicle is moving.
     */
    public void update(Grid grid) {
        int x = currentCell.getX();
        int y = currentCell.getY();
        int direction = random.nextInt(4); // 0: up, 1: down, 2: left, 3: right

        int newX = x;
        int newY = y;

        // Determine the new coordinates based on the random direction
        switch (direction) {
            case 0:
                newY = (y - 1 + grid.getHeight()) % grid.getHeight(); // Move up
                break;
            case 1:
                newY = (y + 1) % grid.getHeight(); // Move down
                break;
            case 2:
                newX = (x - 1 + grid.getWidth()) % grid.getWidth(); // Move left
                break;
            case 3:
                newX = (x + 1) % grid.getWidth(); // Move right
                break;
        }

        Cell nextCell = grid.getGrid()[newX][newY];
        // Only move if the next cell is a RoadCell
        if (nextCell instanceof RoadCell) {
            move(nextCell);
        }
    }

}
