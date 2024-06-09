package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import java.awt.Color;

/**
 * The Car class represents a car in the traffic simulation.
 * It extends the Vehicle class and defines the specific behavior for a car.
 */
public class Car extends Vehicle {
    private int directionY;
    private int directionX; // 1 for down, -1 for up
    private Cell[][] grid;

    // add a property that holds onto the grid

    /**
     * Constructors of Car with the initial cell and color.
     *
     * @param initialCell the initial cell of the car
     * @param color       the color of the car
     */

    // add a constructor parameter that takes a reference to a grid, and assign it
    // to your new property
    public Car(Cell initialCell, Color color) {
        super(initialCell, color);
        this.directionY = 1;
        this.directionX = 0; // Start by moving down
    }

    /**
     * Calculates the next move direction and distance for the car.
     *
     * @return an array with two elements: the direction (0 for no move, 1 for down,
     *         -1 for up)
     *         and the distance to move.
     */
    public int[] getNextMove() {
        int[] returnValue;
        Cell currentCell = getCurrentCell();
        int nextY = currentCell.getY() + directionY;
        int nextX = currentCell.getX() + directionX;
        if (nextY >= getGridHeight() || nextY < 0) {
            directionY *= -1; // Reverse direction when reaching top or bottom edge
            nextY = currentCell.getY() + directionY;
        } else if (nextX >= getGridWidth() || nextX < 0) {
            directionX *= -1;
            nextX = currentCell.getX() + directionX;
        }
        System.out.println("X: " + nextX + "Y: " + nextY);
            if (grid[nextX][nextY].isOccupied()) {
                var temp = directionY;
                directionY = directionX;
                directionX = temp;
            }
        returnValue = new int[] { nextX, nextY };
        return returnValue; // Move vertically  
    }

    public void getGridCell(Cell[][] gridCells) {
        grid = gridCells;
    }

    /**
     * Updates the state of the car.
     */
    public void update() {
        // Additional update logic if necessary
    }
}