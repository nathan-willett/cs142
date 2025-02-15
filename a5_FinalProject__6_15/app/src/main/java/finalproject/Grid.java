package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import java.util.ArrayList;
import java.util.List;

/**
 * The Grid class represents the grid of cells in the traffic simulation.
 * It maintains the state of the grid, including the cells and the vehicles,
 * and provides methods to update the grid and manage vehicle movements.
 * The grid consists of IntersectionCell and RoadCell objects based on a defined pattern.
 * 
 *  The main responsibilities of this class include:
 * - Setting up the grid with specified dimensions and traffic light intervals.
 * - Filling the grid with IntersectionCell and RoadCell objects.
 * - Updating the state of the grid and its cells.
 * - Managing the movement of vehicles and validating their moves.
 * - Placing vehicles at designated locations on the grid.
 * - Setting the timing for traffic lights in the grid.
 */
public class Grid {
    private Cell[][] grid; // 2D array of Cell objects
    private List<Vehicle> vehicles;
    private int width;
    private int height;
    private int trafficLightTiming;


    /**
     * Constructors of a Grid with width, height, and traffic light timing.
     *
     * @param width              the width of the grid
     * @param height             the height of the grid
     * @param trafficLightTiming the timing for traffic lights
     */
    public Grid(int width, int height, int trafficLightTiming) {
        this.width = width;
        this.height = height;
        this.trafficLightTiming = trafficLightTiming;
        this.grid = new Cell[width][height];
        this.vehicles = new ArrayList<>();
        setGrid();
    }

    /**
     * Fills the grid with IntersectionCell and RoadCell objects 
     * based on a defined pattern
     */
    private void setGrid() {
        // Loop through each column and row in the grid
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                // Place IntersectionCell in the middle columns and rows of the grid
                if (j - (width / 2 - 2) == 0 || i - (height / 2) == 0) { 
                    // Create an IntersectionCell at the current position
                    grid[i][j] = new IntersectionCell(i, j, trafficLightTiming);
                } else {
                     // Create a RoadCell at the current position
                    grid[i][j] = new RoadCell(i, j);
                }
            }
        }
    }

    /**
     * Updates the state of the grid.
     * This method updates each cell in the grid and moves the vehicles
     */
    public void updateGrid() {
        // Loop through each column and row in the grid
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j].update();  // Update the cell's state
            }
        }
         // Move the vehicles to their next positions 
        moveVehicles();
    }

    /**
     * Moves the vehicles on the grid based on their next move.
     */
    private void moveVehicles() {
        // Loop through each vehicle in the vehicles list
        for (Vehicle vehicle : vehicles) {
            int[] nextPosition = vehicle.getNextMove();

            // Check if the new position is a valid move
            if (isValidMove(nextPosition[0], nextPosition[1], vehicle)) {
                // Get the target cell at the new coordinates
                Cell newCell = grid[nextPosition[0]][nextPosition[1]];
                // Move the vehicle to the new cell
                vehicle.move(newCell);
            }
        }
    }

    /**
     * Checks if the move to the specified coordinates is valid.
     *
     * @param x       the x-coordinate of the move
     * @param y       the y-coordinate of the move
     * @param vehicle the vehicle trying to move
     * @return true if the move is valid, false otherwise
     */
    private boolean isValidMove(int x, int y, Vehicle vehicle) {
        // Check if the coordinates are within the grid boundaries
        Cell targetCell = grid[x][y];

        // Check if the coordinates are within the grid boundaries
        if (x < 0 || x >= width || y < 0 || y >= height || targetCell.isOccupied()) {
            return false;
        } 
        // Get the target cell at the specified coordinates
        // Check if the vehicle can enter the target cell
        return targetCell.canEnter(vehicle);
    }

    /**
     * Sets the timing for traffic lights.
     *
     * @param timing the new timing for traffic lights
     */
    public void setTrafficLightTiming(int timing) {
        this.trafficLightTiming = timing;
        // Loop through each cell in the grid
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                // Call the setTiming method on each cell
                grid[i][j].setTiming(timing);
            }
        }
    }

    /**
     * Returns the grid as a 2D array.
     *
     * @return the grid as a 2D array
     */
    public Cell[][] getGrid() {
        return grid;
    }

    /**
     * Returns the list of vehicles in the grid.
     *
     * @return the list of vehicles in the grid
     */
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Returns the width of the grid.
     *
     * @return the width of the grid
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of the grid.
     *
     * @return the height of the grid
     */
    public int getHeight() {
        return height;
    }

    /**
     * Adds a vehicle to the grid at the specified coordinates.
     *
     * @param vehicle the vehicle to add
     * @param x       the x-coordinate to place the vehicle
     * @param y       the y-coordinate to place the vehicle
     */
    public void addVehicle(Vehicle vehicle, int x, int y) {
        vehicles.add(vehicle);  // Add the vehicle to the list of vehicles
        vehicle.move(grid[x][y]);  // Move the vehicle to the specified cell on the grid
    }
}
