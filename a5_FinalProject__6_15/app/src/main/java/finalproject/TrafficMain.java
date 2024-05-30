package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

public class TrafficMain {
    public static void main(String[] args) {
        TrafficSimulation simulation = new TrafficSimulation(40); // Example track length
        TrafficGUI gui = new TrafficGUI(simulation);
        gui.initialize();
        simulation.start();
    }
}
