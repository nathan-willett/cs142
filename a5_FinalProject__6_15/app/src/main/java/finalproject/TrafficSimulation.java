import java.awt.Color;


/**
 * The TrafficSimulation class manages the traffic simulation.
 * It initializes the grid, handles the state of the simulation,
 * and manages the vehicles and traffic lights.
 */


public class TrafficSimulation {
    private Grid grid; // The grid representing the simulation area
    private boolean isRunning; // Indicates whether the simulation is currently running
    private int vehicleSpeed; // The speed of the vehicles in the simulation
    private int trafficLightTiming; // The timing for the traffic lights in the simulation


    /**
     * Constructs a TrafficSimulation with specified width, height, and traffic light timing.
     *
     * @param width the width of the grid
     * @param height the height of the grid
     * @param trafficLightTiming the timing for traffic lights
     */
    public TrafficSimulation(int width, int height, int trafficLightTiming) {
        this.grid = new Grid(width, height, trafficLightTiming);
        this.isRunning = false;
        this.vehicleSpeed = 5; // Default vehicle speed
        this.trafficLightTiming = trafficLightTiming;
        initializeVehicles();
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
     * Resets the traffic simulation by reinitializing the grid and vehicles.
     */
    public void reset() {
        grid = new Grid(grid.getWidth(), grid.getHeight(), trafficLightTiming);
        initializeVehicles();
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
     * Initializes the vehicles on the grid.
     * Adds a specified number of vehicles at random positions on the grid.
     */
    private void initializeVehicles() {
        for (int i = 0; i < 20; i++) {  // Adding 20 cars
            int x = (int) (Math.random() * grid.getWidth());
            int y = (int) (Math.random() * grid.getHeight());
            Vehicle vehicle = new Car(grid.getGrid()[x][y], Color.BLUE);
            grid.addVehicle(vehicle, x, y);
        }
    }
}
