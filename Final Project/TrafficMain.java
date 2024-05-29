/**
 * The TrafficMain class contains the main method to start the traffic simulation.
 * It creates an instance of TrafficSimulation and TrafficGUI to run and display the simulation.
 */

public class TrafficMain {

    /**
     * The main method to start the traffic simulation.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Creating a TrafficSimulation instance with width, height, and trafficLightTiming
        // Initialize simulation with grid size 20x20 and traffic light timing 10 seconds
        TrafficSimulation simulation = new TrafficSimulation(20, 20, 10); 

        // Creating the GUI for the traffic simulation
        TrafficGUI gui = new TrafficGUI(simulation);

         // Make the GUI visible
        gui.setVisible(true);
    }
}
