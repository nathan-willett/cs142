import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TrafficGUI extends JFrame {
    private TrafficSimulation simulation;
    private Timer timer;
    private JSlider vehicleSpeedSlider;
    private JSlider trafficLightSlider;
    private static final Color BACKGROUND_COLOR = Color.DARK_GRAY; // Background color
    private static final Color TEXT_COLOR = Color.WHITE; // Text color for visibility
    private static final Color GRID_LINE_COLOR = Color.WHITE; // Grid line color

    public TrafficGUI(TrafficSimulation simulation) {
        this.simulation = simulation;
        initialize();
        timer = new Timer(1000 / simulation.getVehicleSpeed(), new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                simulation.update();
                repaint();
            }
        });
    }

    private void initialize() {
        setTitle("Traffic Simulation");
        setSize(1000, 800); // Increase the size of the window to avoid cutting off the grid
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Set the background color of the main content pane
        getContentPane().setBackground(BACKGROUND_COLOR);

        // Control Panel
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridBagLayout());
        controlPanel.setBackground(BACKGROUND_COLOR);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel vehicleSpeedLabel = new JLabel("Vehicle Speed (steps per second):");
        vehicleSpeedLabel.setForeground(TEXT_COLOR);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        controlPanel.add(vehicleSpeedLabel, gbc);

        vehicleSpeedSlider = new JSlider(1, 10, 5);
        vehicleSpeedSlider.setMajorTickSpacing(1);
        vehicleSpeedSlider.setPaintTicks(true);
        vehicleSpeedSlider.setPaintLabels(true);
        vehicleSpeedSlider.addChangeListener(new ChangeListener() {
            
            public void stateChanged(ChangeEvent e) {
                int speed = vehicleSpeedSlider.getValue();
                simulation.setVehicleSpeed(speed);
                timer.setDelay(1000 / speed);
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        controlPanel.add(vehicleSpeedSlider, gbc);

        JLabel trafficLightLabel = new JLabel("Traffic Light Timing (seconds):");
        trafficLightLabel.setForeground(TEXT_COLOR);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        controlPanel.add(trafficLightLabel, gbc);

        trafficLightSlider = new JSlider(1, 60, 10);
        trafficLightSlider.setMajorTickSpacing(10);
        trafficLightSlider.setPaintTicks(true);
        trafficLightSlider.setPaintLabels(true);
        trafficLightSlider.addChangeListener(new ChangeListener() {
            
            public void stateChanged(ChangeEvent e) {
                int timing = trafficLightSlider.getValue();
                simulation.setTrafficLightTiming(timing);
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        controlPanel.add(trafficLightSlider, gbc);

        JButton startButton = new JButton("Start");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        controlPanel.add(startButton, gbc);

        JButton pauseButton = new JButton("Pause");
        gbc.gridx = 1;
        gbc.gridy = 2;
        controlPanel.add(pauseButton, gbc);

        JButton resetButton = new JButton("Reset");
        gbc.gridx = 2;
        gbc.gridy = 2;
        controlPanel.add(resetButton, gbc);

        add(controlPanel, BorderLayout.SOUTH);

        startButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                simulation.start();
                timer.start();
            }
        });

        pauseButton.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                simulation.pause();
                timer.stop();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulation.reset();
                repaint();
            }
        });

        // Panel for displaying the grid
        JPanel gridPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                Cell[][] grid = simulation.getGrid().getGrid();
                int cellWidth = getWidth() / grid.length;
                int cellHeight = getHeight() / grid[0].length;

                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[i].length; j++) {
                        if (grid[i][j] != null) {
                            g2.setColor(grid[i][j].getColor());
                            g2.fillRect(
                                i * cellWidth,
                                j * cellHeight,
                                cellWidth,
                                cellHeight
                            );
                            // Draw grid lines
                            g2.setColor(GRID_LINE_COLOR);
                            g2.drawRect(
                                i * cellWidth,
                                j * cellHeight,
                                cellWidth,
                                cellHeight
                            );
                        }
                    }
                }

                for (Vehicle vehicle : simulation.getGrid().getVehicles()) {
                    Cell cell = vehicle.getCurrentCell();
                    g2.setColor(vehicle.getColor());
                    g2.fillOval(
                        cell.getX() * cellWidth,
                        cell.getY() * cellHeight,
                        cellWidth,
                        cellHeight
                    );
                }
            }
        };

        gridPanel.setPreferredSize(new Dimension(
            simulation.getGrid().getWidth() * 20, // Assuming 20 pixels per cell for width
            simulation.getGrid().getHeight() * 20 // Assuming 20 pixels per cell for height
        ));
        gridPanel.setBackground(BACKGROUND_COLOR);

        // Centering the grid panel using GridBagLayout
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints centerGbc = new GridBagConstraints();
        centerGbc.gridx = 0;
        centerGbc.gridy = 0;
        centerGbc.weightx = 1.0;
        centerGbc.weighty = 1.0;
        centerGbc.anchor = GridBagConstraints.CENTER;
        centerPanel.add(gridPanel, centerGbc);
        centerPanel.setBackground(BACKGROUND_COLOR);

        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
