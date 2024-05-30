package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TrafficGUI {
    private TrafficSimulation simulation;
    private JFrame frame;
    private JPanel trackPanel;

    public TrafficGUI(TrafficSimulation simulation) {
        this.simulation = simulation;
    }

    public void initialize() {
        frame = new JFrame("Traffic Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        trackPanel = new TrackPanel(simulation);
        frame.add(trackPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private class TrackPanel extends JPanel {
        private TrafficSimulation simulation;

        public TrackPanel(TrafficSimulation simulation) {
            this.simulation = simulation;
            Timer timer = new Timer(100, e -> {
                simulation.update();
                repaint();
            });
            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawTrack(g);
        }

        private void drawTrack(Graphics g) {
            List<Cell> trackCells = simulation.getTrack().getTrackCells();
            for (Cell cell : trackCells) {
                int x = cell.getX() * 20;
                int y = cell.getY() * 20;
                g.setColor(cell.getColor());
                g.fillRect(x, y, 20, 20);
            }

            List<Vehicle> vehicles = simulation.getTrack().getVehicles();
            for (Vehicle vehicle : vehicles) {
                Cell currentCell = vehicle.getCurrentCell();
                int x = currentCell.getX() * 20;
                int y = currentCell.getY() * 20;
                g.setColor(vehicle.getColor());
                g.fillRect(x, y, 20, 20);
            }
        }
    }
}
