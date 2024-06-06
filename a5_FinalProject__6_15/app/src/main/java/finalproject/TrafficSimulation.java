package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import java.awt.Color;

/**
 * The TrafficSimulation class manages the traffic simulation.
 * It set up the grid, handles the state of the simulation,
 * and manages the vehicles and traffic lights.
 */
public class TrafficSimulation {
    private Grid grid; // The grid representing the simulation area
    private boolean isRunning; // Indicates the simulation is running
    private int vehicleSpeed; // Speed of the vehicles 
    private int trafficLightTiming; // Timing for the traffic lights 

    /**
     * Constructors of TrafficSimulation with width, height, 
     * and traffic light timing.
     *
     * @param width the width of the grid
     * @param height the height of the grid
     * @param trafficLightTiming the timing for traffic lights
     * 
     */
    public TrafficSimulation(int width, int height, int trafficLightTiming) {
        this.grid = new Grid(width, height, trafficLightTiming);
        this.isRunning = false;
        this.vehicleSpeed = 5; // Default vehicle speed
        this.trafficLightTiming = trafficLightTiming;
        setVehicles();
    }

    /**
     * Starts the traffic simulation.
     */
    public void start() {
        isRunning = true;
    }

    /**
     * Pauses the traffic simulation.
     */
    public void pause() {
        isRunning = false;
    }

    /**
     * Resets the traffic simulation by restart the grid and vehicles.
     */
    public void reset() {
        grid = new Grid(grid.getWidth(), grid.getHeight(), trafficLightTiming);
        setVehicles();
    }

    /**
     * Updates the state of the simulation.
     * This method is called periodically to update the grid and vehicles.
     */
    public void update() {
        if (isRunning) {
            grid.updateGrid();
        }
    }

    /**
     * Sets the vehicle speed.
     *
     * @param speed the new speed of the vehicles
     */
    public void setVehicleSpeed(int speed) {
        this.vehicleSpeed = speed;
    }

    /**
     * Sets the timing for traffic lights.
     *
     * @param timing the new timing for traffic lights
     */
    public void setTrafficLightTiming(int timing) {
        this.trafficLightTiming = timing;
        grid.setTrafficLightTiming(timing);
    }

    /**
     * Gets the grid of the simulation.
     *
     * @return the grid of the simulation
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * Gets the vehicle speed.
     *
     * @return the current vehicle speed
     */
    public int getVehicleSpeed() {
        return vehicleSpeed;
    }

    /**
     * Gets the traffic light timing.
     *
     * @return the current traffic light timing
     */
    public int getTrafficLightTiming() {
        return trafficLightTiming;
    }

    /**
     * sets the vehicles on the grid.
     * Adds vehicles at random positions on the grid.
     */
    private void setVehicles() {
        for (int i = 0; i < 20; i++) { // Adding 20 cars
            int x = (int) (Math.random() * grid.getWidth());
            int y = (int) (Math.random() * grid.getHeight());
            Vehicle vehicle = new Car(grid.getGrid()[x][y], Color.BLUE);
            vehicle.setGridHeight(grid.getHeight()); // Set the grid height for the vehicle
            grid.addVehicle(vehicle, x, y);
        }
    }
}