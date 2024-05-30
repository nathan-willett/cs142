import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The TrafficGUI class creates the graphical user interface for the traffic simulation.
 * It includes controls for adjusting vehicle speed and traffic light timing,
 * and displays the grid with vehicles and intersections.
 */
public class TrafficGUI extends JFrame {
    private TrafficSimulation simulation;  // The traffic simulation instance
    private Timer timer;                   // Timer to update the simulation periodically
    private JSlider vehicleSpeedSlider;    // Slider to control the vehicle speed
    private JSlider trafficLightTimingSlider;  // Slider to control the traffic light timing
    private static final Color BACKGROUND_COLOR = Color.DARK_GRAY;  // Background color for the GUI

    /**
     * Constructs a TrafficGUI with the specified TrafficSimulation instance.
     *
     * @param simulation the TrafficSimulation instance
     */
    public TrafficGUI(TrafficSimulation simulation) {
        this.simulation = simulation;
        initialize(); // Initialize the GUI components
        initializeTimer(); // Initialize the timer for periodic updates
    }

    /**
     * Initializes the GUI components and layout.
     */
    private void initialize() {
        setTitle("Traffic Simulation"); // Set the title of the window
        setSize(800, 800);  // Adjust size as needed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close the application when the window is closed
        setLayout(new BorderLayout());  // Use BorderLayout for the main layout

        // Panel for the control components with GridBagLayout  
        JPanel controlPanel = new JPanel(new GridBagLayout());
        controlPanel.setBackground(BACKGROUND_COLOR);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Components should fill horizontally
        gbc.insets = new Insets(5, 5, 5, 5); // Margin around components

        // Label for vehicle speed slider
        JLabel vehicleSpeedLabel = new JLabel("Vehicle Speed (steps per second):");
        vehicleSpeedLabel.setForeground(Color.WHITE); // Set text color to white
        gbc.gridx = 0; // Column 0
        gbc.gridy = 0; // Row 0
        gbc.gridwidth = 1; // Span 1 column
        controlPanel.add(vehicleSpeedLabel, gbc);

        // Vehicle speed slider
        vehicleSpeedSlider = new JSlider(1, 10, simulation.getVehicleSpeed());
        vehicleSpeedSlider.setMajorTickSpacing(1); // Set tick spacing for major ticks
        vehicleSpeedSlider.setPaintTicks(true); // Show ticks on the slider
        vehicleSpeedSlider.setPaintLabels(true); // Show labels on the slider
        vehicleSpeedSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                // Update vehicle speed in simulation
                simulation.setVehicleSpeed(vehicleSpeedSlider.getValue());
                // Reinitialize the timer with the new speed
                initializeTimer();
            }
        });
        gbc.gridx = 1; // Column 1
        gbc.gridy = 0; // Row 0
        gbc.gridwidth = 2; // Span 2 colums
        controlPanel.add(vehicleSpeedSlider, gbc);

        // Label for traffic light timing slider
        JLabel trafficLightTimingLabel = new JLabel("Traffic Light Timing (seconds):");
        trafficLightTimingLabel.setForeground(Color.WHITE); // Set text color to white
        gbc.gridx = 0;  // Column 0
        gbc.gridx = 0; // Row 0
        gbc.gridy = 1; // Span  1 column
        gbc.gridwidth = 1;
        controlPanel.add(trafficLightTimingLabel, gbc);

         // Traffic light timing slider
        trafficLightTimingSlider = new JSlider(1, 51, simulation.getTrafficLightTiming());
        trafficLightTimingSlider.setMajorTickSpacing(10); // Set tick spacing for major ticks
        trafficLightTimingSlider.setPaintTicks(true); // Show ticks on the slider
        trafficLightTimingSlider.setPaintLabels(true); // Show labels on the slider
        trafficLightTimingSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                // Update traffic light timing in simulation
                simulation.setTrafficLightTiming(trafficLightTimingSlider.getValue());
            }
        });
        gbc.gridx = 1; // Column 1
        gbc.gridy = 1; // Row 1
        gbc.gridwidth = 2; // Span 2 columns
        controlPanel.add(trafficLightTimingSlider, gbc);

        // Start button
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simulation.start(); // Start the simulation
                timer.start(); // Start the timer
            }
        });
        gbc.gridx = 0; // Column 0
        gbc.gridy = 2; // Row 2
        gbc.gridwidth = 1; // Span 1 column
        controlPanel.add(startButton, gbc);

        // Pause button
        JButton pauseButton = new JButton("Pause");
        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simulation.pause(); // Pause the simulation
                timer.stop(); // Stop the timer
            }
        });
        gbc.gridx = 1;  // Column 1
        gbc.gridy = 2;  // Row 2
        gbc.gridwidth = 1;  // Span 1 column
        controlPanel.add(pauseButton, gbc);

        // Reset button
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simulation.reset(); // Reset the simulation
                repaint(); // Repaint the GUI to reflect changes
            }
        });
        gbc.gridx = 2;  // Column 2
        gbc.gridy = 2;  // Row 2
        gbc.gridwidth = 1;  // Span 1 column
        controlPanel.add(resetButton, gbc);

        // Panel for displaying the grid
        JPanel gridPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                Cell[][] grid = simulation.getGrid().getGrid();
                int cellWidth = getWidth() / grid.length; // Calculate the width of each cell
                int cellHeight = getHeight() / grid[0].length; // Calculate the height of each cell

                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[i].length; j++) {
                        if (grid[i][j] != null) {
                            // Set the color of the cell
                            g2.setColor(grid[i][j].getColor()); 
                            // Fill the cell with color
                            g2.fillRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight); 
                            // Draw grid lines
                            g2.setColor(Color.GRAY);
                            // Draw the border of the cell
                            g2.drawRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight);
                        }
                    }
                }

                // Draw each vehicle as an oval on the grid
                for (Vehicle vehicle : simulation.getGrid().getVehicles()) {
                    Cell cell = vehicle.getCurrentCell(); // Get the current cell of the vehicle
                    g2.setColor(vehicle.getColor()); // Set the color of the vehicle
                    // Draw the vehicle as an oval
                    g2.fillOval(cell.getX() * cellWidth, cell.getY() * cellHeight, cellWidth, cellHeight);
                }
            }
        };

        gridPanel.setPreferredSize(new Dimension(
            simulation.getGrid().getWidth() * 20, // Set preferred width based on grid size
            simulation.getGrid().getHeight() * 20 // Set preferred height based on grid size
        ));
        gridPanel.setBackground(BACKGROUND_COLOR);

        // Centering the grid panel
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(gridPanel);
        centerPanel.setBackground(BACKGROUND_COLOR);

         // Adding panels to the frame
        add(centerPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    /**
     * Initializes the timer for periodic simulation updates.
     */
    private void initializeTimer() {
        if (timer != null) {
            timer.stop(); // Stop the existing timer if it exists
        }
        timer = new Timer(1000 / simulation.getVehicleSpeed(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simulation.update(); // Update the simulation state
                repaint(); // Repaint the GUI to reflect changes
            }
        });
    }
}

