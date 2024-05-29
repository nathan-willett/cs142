public class TrafficMain {
    public static void main(String[] args) {
        // Creating a TrafficSimulation instance with width, height, and trafficLightTiming
        TrafficSimulation simulation = new TrafficSimulation(20, 20, 10); // Add the third parameter for traffic light timing
        TrafficGUI gui = new TrafficGUI(simulation);
        gui.setVisible(true);
    }
}
