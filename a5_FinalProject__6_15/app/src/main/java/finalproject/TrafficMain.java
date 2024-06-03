package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import java.awt.Color;

public class TrafficMain {
    public static void main(String[] args) {
        TrafficSimulation simulation = new TrafficSimulation(40); // Example track length
        TrafficGUI gui = new TrafficGUI(simulation);

        int numberOfCars = 10; // Reduced number of cars
        int trackLength = simulation.getTrack().getTrackCells().size();
        int spacing = trackLength / numberOfCars;

        // Standard acceleration and deceleration values
        double standardMaxSpeed = 1.5;
        double standardAcceleration = 0.1;
        double standardDeceleration = 0.1;

        // Slower car's acceleration and deceleration values
        double slowerMaxSpeed = 1.0;
        double slowerAcceleration = 0.05;
        double slowerDeceleration = 0.05;

        // Add vehicles to the simulation at evenly spaced intervals
        for (int i = 0; i < numberOfCars; i++) {
            int position = i * spacing;
            Cell startCell = simulation.getTrack().getTrackCells().get(position);

            // Ensure the cell is a RoadCell before adding a vehicle
            if (!(startCell instanceof RoadCell)) {
                // Find the next available RoadCell
                for (int j = position; j < trackLength; j++) {
                    if (simulation.getTrack().getTrackCells().get(j) instanceof RoadCell) {
                        position = j;
                        startCell = simulation.getTrack().getTrackCells().get(position);
                        break;
                    }
                }
            }

            Car car;

            if (i == 0) { // The first car will be the slower car
                car = new Car(startCell, Color.GREEN, position, slowerMaxSpeed, slowerAcceleration, slowerDeceleration);
                System.out.println("Initialized green car at position: " + position); // Debug output
            } else {
                car = new Car(startCell, Color.BLUE, position, standardMaxSpeed, standardAcceleration, standardDeceleration);
                System.out.println("Initialized blue car at position: " + position); // Debug output
            }

            simulation.getTrack().addVehicle(car, position);
        }

        gui.initialize();
        simulation.start();
    }
}
