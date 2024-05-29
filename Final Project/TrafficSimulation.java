import java.awt.Color;

public class TrafficSimulation {
    private Grid grid;
    private boolean isRunning;
    private int vehicleSpeed; // Speed of vehicles (steps per second)
    private int trafficLightTiming; // Traffic light timing (seconds)

    public TrafficSimulation(int width, int height) {
        this.grid = new Grid(width, height, 10); // Default traffic light timing in seconds
        this.isRunning = false;
        this.vehicleSpeed = 5; // Default vehicle speed (steps per second)
        this.trafficLightTiming = 10; // Default traffic light timing (seconds)
        // Initialize vehicles
        initializeVehicles();
    }

    private void initializeVehicles() {
        int gridHeight = grid.getHeight();

        // Add initial vehicles to the grid
       
    }

    public void start() {
        isRunning = true;
        // Start the simulation loop
    }

    public void pause() {
        isRunning = false;
    }

    public void reset() {
        // Reset the simulation
    }


    public void update() {
    
    }

    public Grid getGrid() {
        return grid;
    }

    }
}
