package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * TrafficGUI is graphical interface for the traffic simulation.
 * It sets up the window, control panel, and grid display, and handles user inputs.
 */

public class TrafficGUI extends JFrame {
    private TrafficSimulation simulation;
    private Timer timer; // Timer for updating simulation
    private JTextField speedField; // Text field for speed input
    private JTextField timingField; // Text field for timing input

    // Default, minimum, and maximum values for speed and timing
    private int defaultSpeed = 5;  
    private int defaultTiming = 10;  
    private int minSpeed = 1;       
    private int maxSpeed = 100;     
    private int minTiming = 1;      
    private int maxTiming = 60;    


    /**
     * Constructors for TrafficGUI with TrafficSimulation.
     *
     * @param simulation the TrafficSimulation object to be used
     */
    public TrafficGUI(TrafficSimulation simulation) {
        this.simulation = simulation;
        window(); // Set up GUI window
        setTimer(); // Set up timer
    }

    /**
     * Sets up the GUI window, including the control panel and grid panel.
     */
    private void window() {
        setTitle("Traffic Simulation");
        setSize(800, 800); // Set window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Set controlPanel layout to FlowLayout
        JPanel controlPanel = new JPanel(new FlowLayout());

        // Add Start button to start the simulation
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                simulation.start();
                timer.start();
            }
        });
        controlPanel.add(startButton);


        // Add Pause button to pause the simulation
        JButton pauseButton = new JButton("Pause");
        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                simulation.pause();
                timer.stop();
            }
        });
        controlPanel.add(pauseButton);

        // Add Reset button to reset the simulation
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                resetSimulation();
            }
        });
        controlPanel.add(resetButton);

        // Add speed input and button
        controlPanel.add(new JLabel("Speed:"));
        
        // Create a text field for entering the vehicle speed
        speedField = new JTextField(String.valueOf(simulation.getVehicleSpeed()), 3);
        controlPanel.add(speedField);

        // Create a button to set the vehicle speed
        JButton setSpeedButton = new JButton("Set Speed");
        setSpeedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    int speed = Integer.parseInt(speedField.getText());
                    // Check if the entered speed is within the allowed range
                    if (speed < minSpeed || speed > maxSpeed) {
                        // Show a message dialog if the speed is out of range
                        JOptionPane.showMessageDialog(null, "Speed must be between " + minSpeed + " and " + maxSpeed);
                    } else {
                        // Set the vehicle speed in the simulation
                        simulation.setVehicleSpeed(speed);
                        setTimer(); // Reset the timer to use the new speed
                    }
                } catch (NumberFormatException ex) {
                    // Show a message dialog if the entered value is not a valid integer
                    JOptionPane.showMessageDialog(null, "Invalid speed value");
                }
            }
        });
        // Add the set speed button to the control panel
        controlPanel.add(setSpeedButton);


        // Add Timing input and button
        controlPanel.add(new JLabel("Timing:"));
        // Create a text field for entering the traffic light timing
        timingField = new JTextField(String.valueOf(simulation.getTrafficLightTiming()), 3);
        controlPanel.add(timingField); // Add the timing text field on controlPanel


        // Create a button to set the traffic light timing
        JButton setTimingButton = new JButton("Set Timing");
        setTimingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    int timing = Integer.parseInt(timingField.getText());
                    // Check if the entered timing is within the allowed range
                    if (timing < minTiming || timing > maxTiming) {
                        // Show a message dialog if the timing is out of range
                        JOptionPane.showMessageDialog(null, "Timing must be between " + minTiming + " and " + maxTiming);
                    } else {
                        // Set the traffic light timing in the simulation
                        simulation.setTrafficLightTiming(timing);
                    }
                } catch (NumberFormatException ex) {
                    // Show a message dialog if the entered value is not a valid integer
                    JOptionPane.showMessageDialog(null, "Invalid timing value");
                }
            }
        });
        // Add the set timing button to the control panel
        controlPanel.add(setTimingButton);

        // Add control panel to the top
        add(controlPanel, BorderLayout.NORTH);

        // Cread Grid panel for drawing the grid and vehicles
        JPanel gridPanel = new JPanel() {
            protected void paintComponent(Graphics graphic) {
                super.paintComponent(graphic);
                drawGrid(graphic); // Method to draw the grid and vehicles
            }
        };
        // Add grid panel to the center
        add(gridPanel, BorderLayout.CENTER);

        setVisible(true); // Make the frame visible
    }


    /**
     * Draws the grid and vehicles on the grid panel.
     *
     * @param graphic the Graphics object for drawing
     */
    private void drawGrid(Graphics graphic) {
        Graphics2D graph2D = (Graphics2D) graphic;
        Cell[][] grid = simulation.getGrid().getGrid();
        // Calculate width and height of each cell based on panel's H and W
        int cellWidth = getWidth() / grid.length;
        int cellHeight = getHeight() / grid[0].length;

        // Loop through each cell in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != null) {
                    // Set color and draw rectangular shape to traffic lights
                    graph2D.setColor(grid[i][j].getColor());
                    graph2D.fillRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight);
                    // Set color and draw rectangular shape to Road cells
                    graph2D.setColor(Color.GRAY);
                    graph2D.drawRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight);
                }
            }
        }

        // Draw vehicles
        for (Vehicle vehicle : simulation.getGrid().getVehicles()) {
             // Get the current cell of the vehicle
            Cell cell = vehicle.getCurrentCell();
            // Get corlor and create oval shape object represents vehicles
            graph2D.setColor(vehicle.getColor());
            graph2D.fillOval(cell.getX() * cellWidth, cell.getY() * cellHeight, cellWidth, cellHeight);
        }
    }


    /**
     * Sets up and starts the timer for updating the simulation.
     */
    private void setTimer() {
        if (timer != null) {
            timer.stop();
        }
        // Create a Timer with an interval calculated as 1000 millisec devided by the vehicle speed
        timer = new Timer(1000 / simulation.getVehicleSpeed(), new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                simulation.update();
                repaint();
            }
        });
        // Start the new timer
        timer.start();
    }


    /**
     * Resets the simulation to the default values and updates the display.
     */
    private void resetSimulation() {
        speedField.setText(String.valueOf(defaultSpeed));
        timingField.setText(String.valueOf(defaultTiming));
        // Update simulatoin to default speed, timing
        simulation.setVehicleSpeed(defaultSpeed);
        simulation.setTrafficLightTiming(defaultTiming);
        simulation.reset(); // Reset the simulatoin to original state
        setTimer(); 
        repaint(); // update display
    }
}