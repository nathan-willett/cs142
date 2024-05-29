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
        for (int i = 0; i < gridHeight; i += 2) {
            grid.addVehicle(new Car(grid.getGrid()[0][i], Color.BLUE), 0, i);
            grid.addVehicle(new Truck(grid.getGrid()[0][(i + 1) % gridHeight], Color.BLACK), 0, (i + 1) % gridHeight);
        }
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
        grid = new Grid(grid.getWidth(), grid.getHeight(), trafficLightTiming);
        initializeVehicles();
    }

    public void update() {
        if (isRunning) {
            grid.updateGrid();
            adaptTrafficLights();
        }
    }

    public Grid getGrid() {
        return grid;
    }

    public void setVehicleSpeed(int speed) {
        this.vehicleSpeed = speed;
    }

    public void setTrafficLightTiming(int timing) {
        this.trafficLightTiming = timing;
        grid.setTrafficLightTiming(timing);
    }

    public int getVehicleSpeed() {
        return vehicleSpeed;
    }

    public int getTrafficLightTiming() {
        return trafficLightTiming;
    }

    public void printGrid() {
        grid.printGrid();
    }

    private void adaptTrafficLights() {
        for (int i = 0; i < grid.getWidth(); i++) {
            for (int j = 0; j < grid.getHeight(); j++) {
                Cell cell = grid.getGrid()[i][j];
                if (cell instanceof IntersectionCell) {
                    int vehicleCount = getVehicleCount(cell);
                    // Adjust the traffic light timing based on the vehicle count
                    if (vehicleCount > 10) {
                        ((IntersectionCell) cell).setTiming(5); // Shorter green light timing for high traffic
                    } else {
                        ((IntersectionCell) cell).setTiming(10); // Default timing
                    }
                }
            }
        }
    }

    private int getVehicleCount(Cell cell) {
        int count = 0;
        for (Vehicle vehicle : grid.getVehicles()) {
            if (vehicle.getCurrentCell().equals(cell)) {
                count++;
            }
        }
        return count;
    }
}
