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
                timer = new Timer(100, new ActionListener() { // Update interval set to 100 milliseconds
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
            int radius = Math.min(getWidth(), getHeight()) / 3; // Ensure it's a circle

            g.setColor(Color.BLACK); // Color of the track lines

            drawCircle(g, centerX, centerY, radius);

            List<Vehicle> vehicles = simulation.getTrack().getVehicles();
            for (Vehicle vehicle : vehicles) {
                Cell currentCell = vehicle.getCurrentCell();
                int index = simulation.getTrack().getTrackCells().indexOf(currentCell);
                double angle = 2 * Math.PI * index / simulation.getTrack().getTrackCells().size();
                int x = centerX + (int) (radius * Math.cos(angle));
                int y = centerY + (int) (radius * Math.sin(angle));
                g.setColor(vehicle.getColor());
                g.fillOval(x - 5, y - 5, 10, 10); // Adjust size as needed
            }
        }

        private void drawCircle(Graphics g, int centerX, int centerY, int radius) {
            g.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
        }
    }
}
