import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a grid for the traffic simulation, consisting of RoadCell and
 * IntersectionCell objects.
 */

public class Grid {
    private Cell[][] grid; // 2D array representing the grid
    private int width; // Width of the grid
    private int height; // Width of the grid
    private List<Vehicle> vehicles; // List of vehicles in the grid
    private Random random; // Random number generator for initializing the grid

    /**
     * Constructs a Grid with specified width, height, and initial traffic light
     * timing.
     *
     * @param width              The width of the grid.
     * @param height             The height of the grid.
     * @param trafficLightTiming Initial timing for traffic lights in
     *                           IntersectionCells.
     */

    public Grid(int width, int height, int trafficLightTiming) {
        this.width = width;
        this.height = height;
        this.grid = new Cell[width][height];
        this.vehicles = new ArrayList<>();
        this.random = new Random();

        // Initialize grid with random RoadCells and IntersectionCells
        initializeGrid(trafficLightTiming);
    }

    /**
     * Initializes the grid with a mixture of RoadCells and IntersectionCells.
     *
     * @param trafficLightTiming The timing for traffic lights in IntersectionCells.
     */

    private void initializeGrid(int trafficLightTiming) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                // Randomly assign either a RoadCell or an IntersectionCell to each position in
                // the grid
                if (random.nextBoolean()) {
                    grid[i][j] = new RoadCell(i, j);
                } else {
                    grid[i][j] = new IntersectionCell(i, j, trafficLightTiming);
                }
            }
        }
    }

    /**
     * Sets the timing for all traffic lights in IntersectionCells.
     *
     * @param timing The new timing for traffic lights.
     */

    public void setTrafficLightTiming(int timing) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (grid[i][j] instanceof IntersectionCell) {
                    ((IntersectionCell) grid[i][j]).setTiming(timing);
                }
            }
        }
    }

    /**
     * Adds a vehicle to the grid at specified coordinates.
     *
     * @param vehicle The vehicle to be added.
     * @param x       The x-coordinate of the vehicle's initial position.
     * @param y       The y-coordinate of the vehicle's initial position.
     */

    public void addVehicle(Vehicle vehicle, int x, int y) {
        vehicles.add(vehicle);
        vehicle.move(grid[x][y]);
    }

    /**
     * Updates the state of the grid and all cells within it.
     */

    public void updateGrid() {
        // Update each vehicle in the grid
        for (Vehicle vehicle : vehicles) {
            vehicle.update(this);
        }
        // Update each cell in the grid
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j].update();
            }
        }
    }

    /**
     * Returns the grid as a 2D array of cells.
     *
     * @return The grid.
     */

    public Cell[][] getGrid() {
        return grid;
    }

    /**
     * Returns the list of vehicles in the grid.
     *
     * @return The list of vehicles.
     */

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Returns the width of the grid.
     *
     * @return The width of the grid.
     */

    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of the grid.
     *
     * @return The height of the grid.
     */

    public int getHeight() {
        return height;
    }

    /**
     * Prints a text representation of the grid, including the positions of all
     * vehicles.
     */
    public void printGrid() {
        // Loop through each row of the grid
        for (int j = 0; j < height; j++) {
            // Loop through each column of the grid
            for (int i = 0; i < width; i++) {
                boolean hasVehicle = false;
                // Check each vehicle to see if it is in the current cell
                for (Vehicle vehicle : vehicles) {
                    // If the vehicle is in the current cell
                    if (vehicle.getCurrentCell().getX() == i && vehicle.getCurrentCell().getY() == j) {
                        System.out.print(vehicle.toString() + " ");
                        hasVehicle = true; // Set the flag to true since we found a vehicle
                        break; // Exit the loop since we found a vehicle in the current cell
                    }
                }
                // If no vehicle was found in the current cell
                if (!hasVehicle) {
                    // Print the cell's string representation followed by a space
                    System.out.print(grid[i][j].toString() + " ");
                }
            }
            // Move to the next line after printing all columns in the current row
            System.out.println();
        }
    }
}
