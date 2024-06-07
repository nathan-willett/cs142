package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import java.awt.Color;

/**
 * The IntersectionCell class represents an intersection cell 
 * in the traffic simulation.
 * It extends the Cell class and manages the traffic light state.
 */
public class IntersectionCell extends Cell {
    private int timing;
    private int timer;
    private boolean isGreen;

    /**
     * Constructs an IntersectionCell with the specified coordinates and traffic
     * light timing.
     *
     * @param x      the x-coordinate of the cell
     * @param y      the y-coordinate of the cell
     * @param timing the timing for the traffic light
     */
    public IntersectionCell(int x, int y, int timing) {
        super(x, y);
        this.timing = timing;
        this.timer = 0;
        this.isGreen = true; // Initial state is green
    }

    /**
     * Updates the state of the traffic light.
     */
    public void update() {
        timer++;
        if (timer >= timing) {
            isGreen = !isGreen;
            timer = 0;
        }
    }

    /**
     * Checks if a vehicle can enter this cell.
     *
     * @param vehicle the vehicle trying to enter
     * @return true if the traffic light is green, false otherwise
     */
    public boolean canEnter(Vehicle vehicle) {
        return isGreen;
    }

    /**
     * Sets the timing for the traffic light.
     *
     * @param timing the new timing for the traffic light
     */
    public void setTiming(int timing) {
        this.timing = timing;
    }

    /**
     * Returns the color of the cell.
     *
     * @return the color of the cell (green or red based on the traffic light state)
     */
    public Color getColor() {
        return isGreen ? Color.GREEN : Color.RED;
    }

}