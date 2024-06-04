package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Track {
    private List<Cell> trackCells;
    private List<Vehicle> vehicles;

    public Track(int numCells, int greenDuration, int yellowDuration, int redDuration) {
        trackCells = new ArrayList<>();
        vehicles = new ArrayList<>();

        for (int i = 0; i < numCells; i++) {
            // Assuming road cells and intersection cells are placed alternately
            if (i % 10 == 0) {
                trackCells.add(new IntersectionCell(i, i, greenDuration, yellowDuration, redDuration));
            } else {
                trackCells.add(new RoadCell(i, i, Color.GRAY)); // Pass x and y coordinates
            }
        }
    }

    public List<Cell> getTrackCells() {
        return trackCells;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addVehicle(Vehicle vehicle, int position) {
        vehicle.setCurrentPosition(position); // Ensure the vehicle starts at the specified position
        vehicles.add(vehicle);
    }

    public void update() {
        for (Cell cell : trackCells) {
            cell.update();
        }
        for (Vehicle vehicle : vehicles) {
            vehicle.update(this);
        }
    }
}
