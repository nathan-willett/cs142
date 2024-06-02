package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TrafficGUI {
    private TrafficSimulation simulation;
    private JFrame frame;
    private JPanel trackPanel;
    private JButton startButton;
    private JButton stopButton;
    private Timer timer;

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

        JPanel controlPanel = new JPanel();
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");

        controlPanel.add(startButton);
        controlPanel.add(stopButton);

        frame.add(controlPanel, BorderLayout.SOUTH);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timer != null && timer.isRunning()) {
                    timer.stop();
                }
                timer = new Timer(100, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        simulation.update();
                        trackPanel.repaint();
                    }
                });
                timer.start();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timer != null && timer.isRunning()) {
                    timer.stop();
                }
            }
        });

        frame.setVisible(true);
    }

    private class TrackPanel extends JPanel {
        private TrafficSimulation simulation;
        private static final int LANE_COUNT = 5;
        private static final int LANE_WIDTH = 20;

        public TrackPanel(TrafficSimulation simulation) {
            this.simulation = simulation;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawTrack(g);
        }

        private void drawTrack(Graphics g) {
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            int baseRadiusX = getWidth() / 3;
            int baseRadiusY = getHeight() / 3;

            g.setColor(Color.BLACK); // Color of the track lines

            for (int lane = 0; lane < LANE_COUNT; lane++) {
                int radiusX = baseRadiusX - (lane * LANE_WIDTH);
                int radiusY = baseRadiusY - (lane * LANE_WIDTH);
                drawOval(g, centerX, centerY, radiusX, radiusY);
            }

            List<Vehicle> vehicles = simulation.getTrack().getVehicles();
            for (Vehicle vehicle : vehicles) {
                Cell currentCell = vehicle.getCurrentCell();
                int index = simulation.getTrack().getTrackCells().indexOf(currentCell);
                double angle = 2 * Math.PI * index / simulation.getTrack().getTrackCells().size();
                int laneOffsetX = (int) (baseRadiusX - ((vehicle.getLane() - .5) * LANE_WIDTH)); // Shift by 2 lanes outward
                int laneOffsetY = (int) (baseRadiusY - ((vehicle.getLane() - .5) * LANE_WIDTH)); // Shift by 2 lanes outward
                int x = centerX + (int) (laneOffsetX * Math.cos(angle));
                int y = centerY + (int) (laneOffsetY * Math.sin(angle));
                g.setColor(vehicle.getColor());
                g.fillOval(x - 5, y - 5, 10, 10); // Adjust size as needed
            }
        }

        private void drawOval(Graphics g, int centerX, int centerY, int radiusX, int radiusY) {
            g.drawOval(centerX - radiusX, centerY - radiusY, 2 * radiusX, 2 * radiusY);
        }
    }
}
