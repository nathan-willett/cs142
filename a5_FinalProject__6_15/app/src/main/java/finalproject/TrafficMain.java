package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

/**
 * The TrafficMain class contains the main method to start the traffic
 * simulation. It creates an instance of TrafficSimulation and TrafficGUI
 * to run and display the simulation.
 * 
 * // [MermaidChart: efe2a417-e05c-4fe9-98f2-73ed76d1aa69]
 */
public class TrafficMain {
    public static void main(String[] args) {
        // Create the simulation with grid size 20x20 and traffic light timing 10 seconds
        TrafficSimulation simulation = new TrafficSimulation(20, 20, 10); 

        // Create the GUI for the traffic simulation
        TrafficGUI gui = new TrafficGUI(simulation);

         // Make the GUI visible
        gui.setVisible(true);
    }
}