public class TrafficMain {
    public static void main(String[] args) {
        // Create a new TrafficSimulation with the desired grid size
        TrafficSimulation simulation = new TrafficSimulation(20, 20);

        // Create and display the GUI
        TrafficGUI gui = new TrafficGUI(simulation);
        gui.setVisible(true);
    }
}
