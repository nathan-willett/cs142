package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import java.awt.Color;

/**
 * Represents a cell in the traffic simulation grid.
 * This is an abstract class that provides the basic
 * properties and methods for different types of cells.
 */
public abstract class Cell {
    private int x; // The x-coordinate of the cell in the grid.
    private int y; // The y-coordinate of the cell in the grid.

    /**
     * Constructs a cell with specified coordinates.
     *
     * @param x The x-coordinate of the cell in the grid.
     * @param y The y-coordinate of the cell in the grid.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-coordinate of the cell.
     *
     * @return The x-coordinate of the cell.
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of the cell.
     *
     * @return The y-coordinate of the cell.
     */
    public int getY() {
        return y;
    }

    /**
     * Updates the state of the cell.
     * This method should be implemented by subclasses
     * to provide specific update logic.
     */
    public abstract void update();

    /**
     * Returns the color of the cell.
     * This method should be implemented by subclasses
     * to return the specific color of the cell.
     *
     * @return The color of the cell.
     */
    public abstract Color getColor();

    /**
     * Returns a string representation of the cell.
     * This method should be implemented by subclasses to return a specific string
     * representation of the cell.
     *
     * @return A string representing the cell.
     */
    public abstract String toString();
}
