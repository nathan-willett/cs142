import java.awt.Color;

/**
 * Represents a road cell in the traffic simulation.
 * Road cells are traversable cells on which vehicles can move.
 */
public class RoadCell extends Cell {

    /**
     * Constructs a road cell with specified coordinates.
     *
     * @param x The x-coordinate of the road cell in the grid.
     * @param y The y-coordinate of the road cell in the grid.
     */
    public RoadCell(int x, int y) {
        super(x, y); // Call the constructor of the Cell class
    }

    /**
     * Updates the state of the road cell.
     * This method is currently empty but can be overridden to add specific logic
     * for updating the road cell's state if needed.
     */
    public void update() {
        // Logic for road cell, if needed
    }

    /**
     * Returns the color of the road cell.
     * Road cells are represented by the color gray.
     *
     * @return The color of the road cell (gray).
     */
    public Color getColor() {
        return Color.GRAY;
    }

    /**
     * Returns a string representation of the road cell.
     *
     * @return A string representing the road cell, currently a space.
     */

    public String toString() {
        return " ";
    }
}
