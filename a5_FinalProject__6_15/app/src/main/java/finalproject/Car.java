import java.awt.Color;


/**
 * Represents a car in the traffic simulation.
 * 
 */


public class Car extends Vehicle {

    /**
     * Constructs a car with a starting cell and a specified color.
     *
     * @param startCell The starting cell for the car. Represents the initial position of the car in the grid.
     * @param color The color of the car. Used for graphical representation.
     */
    public Car(Cell startCell, Color color) {
        super(startCell, color); // Call the constructor of the Vehicle class
    }


    /**
     * Updates the car's position on the grid.
     * The car moves to an adjacent cell if the next cell is a `RoadCell`.
     * This method overrides the update method in the Vehicle class to ensure that
     * the car follows the same update logic as a general vehicle.
     *
     * @param grid The grid in which the car is moving. Provides the layout and state of the simulation.
     */
    public void update(Grid grid) {  
        super.update(grid); // Call the update method of the Vehicle class
    }


    /**
     * Returns the color of the car.
     * This method overrides the getColor method in the Vehicle class to ensure that
     * the car's color can be accessed in the same way as for a general vehicle.
     *
     * @return The color of the car.
     */
   
    public Color getColor() {
        return super.getColor();
    }
}
