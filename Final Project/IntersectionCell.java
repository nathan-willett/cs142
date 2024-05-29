import java.awt.Color;

/**
 * Represents an intersection cell in the traffic simulation grid.
 * Intersection cells have traffic lights and can change state.
 */
public class IntersectionCell extends Cell {
    private boolean lightGreen;  // Indicates whether the traffic light is green
    private int timer; // Timer to track the duration of the current light state
    private int timing; // The timing duration for the traffic light


    /**
     * Constructs an intersection cell with specified coordinates and traffic light timing.
     *
     * @param x The x-coordinate of the intersection cell in the grid.
     * @param y The y-coordinate of the intersection cell in the grid.
     * @param timing The timing duration for the traffic light.
     */
    public IntersectionCell(int x, int y, int timing) {
        super(x, y); // Call the constructor of the Cell class
        this.lightGreen = true;
        this.timer = 0;
        this.timing = timing;
    }


    /**
     * Sets the traffic light timing for the intersection cell.
     *
     * @param timing The new timing duration for the traffic light.
     */
    public void setTiming(int timing) {
        this.timing = timing; // Update the traffic light timing

    }


    /**
     * Changes the traffic light state between green and red.
     */
    public void changeLight() {
        lightGreen = !lightGreen; // Toggle the traffic light state
    }

    /**
     * Updates the state of the intersection cell.
     * Changes the traffic light state based on the timer.
     */
    public void update() {
        timer++;
        // Check if the timer has reached the timing duration
        if (timer >= timing) {
            changeLight(); // Change the traffic light state
            timer = 0; // Reset the timer
        }
    }
    


    /**
     * Returns the color of the intersection cell.
     * Green if the light is green, red if the light is red.
     *
     * @return The color of the intersection cell.
     */  
    public Color getColor() {
        return lightGreen ? Color.GREEN : Color.RED; // Return the color based on the traffic light state
    }


     /**
     * Returns a string representation of the intersection cell.
     * 'G' for green light and 'R' for red light.
     *
     * @return A string representing the state of the intersection cell.
     */
    public String toString() {
        return lightGreen ? "G" : "R"; // Return "G" if the light is green, else "R"
    }


    /**
     * Returns whether the traffic light is green.
     *
     * @return True if the traffic light is green, false otherwise.
     */
    public boolean isLightGreen() {
        return lightGreen;
    }
}
