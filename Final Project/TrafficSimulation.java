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

   
}
