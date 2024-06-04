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

        // Array of colors for the cars
        Color[] colors = { Color.RED, Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.ORANGE, Color.CYAN, Color.PINK, Color.GRAY, Color.DARK_GRAY, Color.GREEN };

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
            if (i == 9) { // The last car will be the slower green car
                car = new Car(startCell, Color.GREEN, position, slowerMaxSpeed, slowerAcceleration, slowerDeceleration);
                System.out.println("Initialized green car at position: " + position); // Debug output
            } else {
                car = new Car(startCell, colors[i], position, standardMaxSpeed, standardAcceleration, standardDeceleration);
                System.out.println("Initialized car at position: " + position); // Debug output
            }

            simulation.getTrack().addVehicle(car, position);
        }

        gui.initialize();
        simulation.start(gui);
    }
}
