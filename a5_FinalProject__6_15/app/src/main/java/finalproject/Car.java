package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import java.awt.Color;

/**
 * The Car class represents a car in the traffic simulation.
 * It extends the Vehicle class and defines the specific behavior for a car.
 */
public class Car extends Vehicle {
    private int direction; // 1 for down, -1 for up

    /**
     * Constructors of Car with the initial cell and color.
     *
     * @param initialCell the initial cell of the car
     * @param color the color of the car
     */
    public Car(Cell initialCell, Color color) {
        super(initialCell, color);
        this.direction = 1; // Start by moving down
    }

    /**
     * Calculates the next move direction and distance for the car.
     *
     * @return an array with two elements: the direction (0 for no move, 1 for down, -1 for up)
     *         and the distance to move.
     */
    public int[] getNextMove() {
        Cell currentCell = getCurrentCell();
        int nextY = currentCell.getY() + direction;
        if (nextY >= getGridHeight() || nextY < 0) {
            direction *= -1; // Reverse direction when reaching top or bottom edge
        }
        return new int[]{0, direction};  // Move vertically
    }

    /**
     * Updates the state of the car.
     */
    public void update() {
        // Additional update logic if necessary
    }
}