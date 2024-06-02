package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import java.awt.Color;

public class TrafficMain {
    public static void main(String[] args) {
        TrafficSimulation simulation = new TrafficSimulation(40); // Example track length
        TrafficGUI gui = new TrafficGUI(simulation);

        // Add vehicles to the simulation
        for (int i = 0; i < 5; i++) { // Adding 5 vehicles, one for each lane
            Cell startCell = simulation.getTrack().getTrackCells().get(i);
            Car car = new Car(startCell, Color.BLUE, i);
            simulation.getTrack().addVehicle(car, i);
        }

        gui.initialize();
        simulation.start();
    }
}

