package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import java.awt.Color;

/**
 * The RoadCell class represents a road cell in the traffic simulation.
 * It extends the Cell class.
 */
public class RoadCell extends Cell {

    /**
     * Constructs a RoadCell with the specified coordinates.
     *
     * @param x the x-coordinate of the cell
     * @param y the y-coordinate of the cell
     */
    public RoadCell(int x, int y) {
        super(x, y);
    }

    /**
     * Updates the state of the road cell.
     * Override from Cell
     */
    public void update() {
        // RoadCell specific update logic, if any
    }

    /**
     * Returns the color of the cell.
     * Override from Cell
     *
     * @return the color of the cell (default road color)
     */
    public Color getColor() {
        return Color.GRAY;
    }
}
