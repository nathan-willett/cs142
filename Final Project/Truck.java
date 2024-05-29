import java.awt.Color;

/**
 * Represents a truck in the traffic simulation.
 * 
 */
public class Truck extends Vehicle {

    /**
     * Constructs a truck with a starting cell and a specified color.
     *
     * @param startCell The starting cell for the truck. Represents the initial
     *                  position of the truck in the grid.
     * @param color     The color of the truck. Used for graphical representation.
     */
    public Truck(Cell startCell, Color color) {
        super(startCell, color);
    }

    /**
     * Updates the truck's position on the grid.
     * The truck moves to an adjacent cell if the next cell is an
     * `IntersectionCell`.
     * This method overrides the update method in the Vehicle class to ensure that
     * the truck follows a different update logic compared to a general vehicle.
     *
     * @param grid The grid in which the truck is moving. Provides the layout and
     *             state of the simulation.
     */
    public void update(Grid grid) {
        // Truck-specific update logic, only move to IntersectionCells
        super.update(grid); // Call the update method of the Vehicle class
    }

    /**
     * Returns the color of the truck.
     * This method overrides the getColor method in the Vehicle class to ensure that
     * the truck's color can be accessed in the same way as for a general vehicle.
     *
     * @return The color of the truck.
     */
    public Color getColor() {
        return super.getColor(); // Call the getColor method of the Vehicle class
    }

}
