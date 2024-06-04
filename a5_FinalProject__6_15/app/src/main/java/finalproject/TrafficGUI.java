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
        List<Cell> trackCells = simulation.getTrack().getTrackCells();
        List<Vehicle> vehicles = simulation.getVehicles();

        // Draw grid for visualization
        for (Cell cell : trackCells) {
            g.setColor(Color.LIGHT_GRAY);
            g.drawRect(cell.getX() * 20, cell.getY() * 20, 20, 20);
        }

        // Draw vehicles
        for (Vehicle vehicle : vehicles) {
            int position = vehicle.getCurrentPosition();
            Cell cell = trackCells.get(position);
            g.setColor(vehicle.getColor());
            g.fillRect(cell.getX() * 20, cell.getY() * 20, 20, 20);
        }
    }
}
