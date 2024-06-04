package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TrafficGUI {
    private TrafficSimulation simulation;
    private JFrame frame;
    private JPanel panel;
    private JButton startButton;
    private JButton pauseButton;
    private Timer timer;
    private boolean isRunning;

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
        frame.add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start");
        pauseButton = new JButton("Pause");

        buttonPanel.add(startButton);
        buttonPanel.add(pauseButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        isRunning = false;

        // Timer to update and repaint the simulation
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulation.update();
                repaint();
            }
        });

        // Start button action
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isRunning) {
                    timer.start();
                    isRunning = true;
                }
            }
        });

        // Pause button action
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isRunning) {
                    timer.stop();
                    isRunning = false;
                }
            }
        });
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

        // Draw circular track line
        double radius = 200;
        double centerX = 400;
        double centerY = 300;
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < trackCells.size(); i++) {
            double angle1 = 2 * Math.PI * i / trackCells.size();
            double angle2 = 2 * Math.PI * (i + 1) / trackCells.size();
            int x1 = (int) (centerX + radius * Math.cos(angle1));
            int y1 = (int) (centerY + radius * Math.sin(angle1));
            int x2 = (int) (centerX + radius * Math.cos(angle2));
            int y2 = (int) (centerY + radius * Math.sin(angle2));
            g.drawLine(x1, y1, x2, y2);
        }

        // Draw vehicles
        int vehicleSize = 20; // Size of the vehicle icons
        for (Vehicle vehicle : vehicles) {
            int position = vehicle.getCurrentPosition();
            Cell cell = trackCells.get(position);
            g.setColor(vehicle.getColor());
            if (vehicle.getColor().equals(Color.GREEN)) {
                g.fillRect(cell.getX() - vehicleSize / 2, cell.getY() - vehicleSize / 2, vehicleSize, vehicleSize); // Draw the green car as a square
            } else {
                g.fillOval(cell.getX() - vehicleSize / 2, cell.getY() - vehicleSize / 2, vehicleSize, vehicleSize); // Draw other cars as circles
            }
        }
    }
}
