package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import java.awt.Color;

/**
 * The Vehicle class represents a vehicle in the traffic simulation.
 * This is an abstract class that defines the behavior for all vehicles.
 */
public abstract class Vehicle {
    private Cell currentCell;
    private Color color;
    private int gridHeight; // The height of the grid for boundary checks

    /**
     * Constructs a Vehicle with the specified initial cell and color.
     *
     * @param initialCell the initial cell of the vehicle
     * @param color the color of the vehicle
     */
    public Vehicle(Cell initialCell, Color color) {
        this.currentCell = initialCell;
        this.color = color;
    }

    /**
     * Moves the vehicle to a new cell.
     *
     * @param newCell the new cell to move to
     */
    public void move(Cell newCell) {
        this.currentCell = newCell;
    }

    /**
     * Returns the current cell of the vehicle.
     *
     * @return the current cell of the vehicle
     */
    public Cell getCurrentCell() {
        return currentCell;
    }

    /**
     * Returns the color of the vehicle.
     *
     * @return the color of the vehicle
     */
    public Color getColor() {
        return color;
    }

    /**
     * Calculates the next move direction and distance.
     *
     * @return an array with two elements: the direction (0 for no move, 1 for right, -1 for left)
     *         and the distance to move.
     */
    public abstract int[] getNextMove();

    /**
     * Updates the state of the vehicle.
     */
    public abstract void update();

    /**
     * Sets the grid height for boundary checks.
     */
    public void setGridHeight(int gridHeight) {
        this.gridHeight = gridHeight;
    }

    /**
     * Gets the grid height.
     *
     * @return the grid height
     */
    public int getGridHeight() {
        return gridHeight;
    }
}