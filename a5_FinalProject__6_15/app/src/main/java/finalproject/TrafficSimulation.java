package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import java.util.List;

public class TrafficSimulation {
    private Track track;

    public TrafficSimulation(int numCells) {
        int greenDuration = 30; // Duration of green light
        int yellowDuration = 5; // Duration of yellow light
        int redDuration = 30; // Duration of red light

        track = new Track(numCells, greenDuration, yellowDuration, redDuration);
    }

    public void addVehicle(Vehicle vehicle) {
        track.addVehicle(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return track.getVehicles();
    }

    public void update() {
        track.update();
    }

    public Track getTrack() {
        return track;
    }

    public void start(TrafficGUI gui) {
        for (int i = 0; i < 100; i++) {
            update();
            gui.repaint();
            try {
                Thread.sleep(100); // Add delay for better visualization
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
