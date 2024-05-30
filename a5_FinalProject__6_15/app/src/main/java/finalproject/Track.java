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
            trackCells.add(new RoadCell(i, 0, Color.GRAY)); // Assuming a simple linear layout for now
        }

        // Place traffic lights at equal intervals
        int interval = trackLength / 4; // Adjust as needed for the number of traffic lights
        for (int i = 0; i < trackLength; i += interval) {
            trackCells.set(i, new IntersectionCell(i, 0, Color.RED, 5)); // Timing example
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
        }
    }
}
