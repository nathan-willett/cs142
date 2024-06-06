package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import java.awt.Color;

/**
 * The Cell class represents a cell in the traffic simulation.
 * It is an abstract class to be extended by specific cell types.
 */
public abstract class Cell {
    private int x;
    private int y;

    /**
     * Constructs a Cell with the specified coordinates.
     *
     * @param x the x-coordinate of the cell
     * @param y the y-coordinate of the cell
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-coordinate of the cell.
     *
     * @return the x-coordinate of the cell
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of the cell.
     *
     * @return the y-coordinate of the cell
     */
    public int getY() {
        return y;
    }

    /**
     * Updates the state of the cell.
     */
    public abstract void update();

    /**
     * Returns the color of the cell.
     *
     * @return the color of the cell
     */
    public abstract Color getColor();

    /**
     * Sets the timing for the cell. 
     *
     * @param timing the new timing value
     */
    public void setTiming(int timing) {
        
    }

    /**
     * Determines if a vehicle can enter this cell. 
     *
     * @param vehicle the vehicle trying to enter
     * @return true if the vehicle can enter, false otherwise
     */
    public boolean canEnter(Vehicle vehicle) {
        return true; // Default implementation, can be overridden by subclasses
    }
}