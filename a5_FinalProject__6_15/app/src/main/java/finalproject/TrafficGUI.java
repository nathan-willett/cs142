package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TrafficGUI {
    private TrafficSimulation simulation;
    private JFrame frame;
    private JPanel panel;

    public TrafficGUI(TrafficSimulation simulation) {
        this.simulation = simulation;
        frame = new JFrame("Traffic Simulation");
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawSimulation(g);
            }
        };
        panel.setPreferredSize(new Dimension(800, 600));
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void initialize() {
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }

    public void repaint() {
        panel.repaint();
    }

    private void drawSimulation(Graphics g) {
        List<Vehicle> vehicles = simulation.getVehicles();
        for (Vehicle vehicle : vehicles) {
            int position = vehicle.getCurrentPosition();
            Cell cell = simulation.getTrack().getTrackCells().get(position);
            g.setColor(vehicle.getColor());
            g.fillRect(cell.getX() * 10, cell.getY() * 10, 10, 10);
        }
    }
}
