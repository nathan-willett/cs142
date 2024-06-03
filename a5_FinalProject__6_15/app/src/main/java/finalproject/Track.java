package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Track {
    private List<Cell> trackCells;
    private List<Vehicle> vehicles;
    private int trackLength;

    public Track(int trackLength) {
        this.trackLength = trackLength;
        this.trackCells = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        initializeTrack();
    }

    private void initializeTrack() {
        for (int i = 0; i < trackLength; i++) {
            trackCells.add(new RoadCell(i, 0, Color.GRAY));
        }

        // Debug output to verify number of track cells
        System.out.println("Number of track cells: " + trackCells.size());

        // Place traffic lights at equal intervals
        int interval = trackLength / 4;
        for (int i = 0; i < trackLength; i += interval) {
            trackCells.set(i, new IntersectionCell(i, 0, Color.RED, 50)); // Adjust timing as needed
        }
    }

    public void updateTrack() {
        for (Cell cell : trackCells) {
            cell.update();
        }

        for (Vehicle vehicle : vehicles) {
            vehicle.update(this);
        }
    }

    public List<Cell> getTrackCells() {
        return trackCells;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle, int position) {
        if (position < trackLength && trackCells.get(position) instanceof RoadCell) {
            vehicles.add(vehicle);
            vehicle.move(trackCells.get(position));
        } else {
            System.out.println("Failed to add vehicle at position: " + position); // Debug output
        }
    }
}
