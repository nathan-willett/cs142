package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting


import java.awt.Color;

/**
 * The Car class represents a car in the traffic simulation.
 * It extends the Vehicle class and defines the specific behavior for a car,
 * including determining where cars should move next in the grid.
 */
public class Car extends Vehicle {
    private int directionY;  // 1 for right, -1 for left
    private int directionX; // 1 for down, -1 for up
    private Cell[][] grid; // Reference to the grid of cells

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
        this.directionY = 1; // Start by moving down along the Y-axis
        this.directionX = 0; // Start with no movement along X-axis
    }

    /**
     * Calculates the next move direction and distance for the car.
     *
     * @return an array with two elements: 
     *         nextX (1 for right, -1 for left, O for no move)
     *         nextY (1 for down, -1 for up, O for no move)
     *         and the distance to move.
     */
    public int[] getNextMove() {
        int[] returnValue;

        // Retrive current cell position
        Cell currentCell = getCurrentCell();
        // Calculate the next Y-coordinate  and X-coordinate
        int nextY = currentCell.getY() + directionY;
        int nextX = currentCell.getX() + directionX;

        // Check for boundary of the top and bottom grid
        if (nextY >= getGridHeight() || nextY < 0) {
            directionY *= -1; // Reverse direction when reaching top or bottom edge
            nextY = currentCell.getY() + directionY;
            
          // Check for boundary of the left and right grid
        } else if (nextX >= getGridWidth() || nextX < 0) {
            directionX *= -1; // Reverse direction when reaching left or right edge
            nextX = currentCell.getX() + directionX;
        }

         // Check if the next cell is occupied and adjust direction if needed
        if (grid[nextX][nextY].isOccupied()) {
            var temp = directionY;
            directionY = directionX;
            directionX = temp;
        }
        returnValue = new int[] { nextX, nextY };
        return returnValue; // Return the next move coordinates
    
    }

    /**
     * Sets the reference to the grid cells.
     * Implementd from the abstract Vehicle class
     * @param gridCells the 2D array of grid cells
     */
    public void getGridCell(Cell[][] gridCells) {
        grid = gridCells;
    }

    /**
     * Updates the state of the car.
     * Impelemnted from the abtract Vehicle class
     */
    public void update() {
        // Additional update logic if necessary
    }
}
