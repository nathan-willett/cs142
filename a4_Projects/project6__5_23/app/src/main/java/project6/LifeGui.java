//package a4_Projects.project6__5_23.app.src.main.java.project6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class: LifeGui
 * 
 * LifeGui provides the graphical user interface for the program. It uses
 * Swing to create a window displaying the grid, and it updates the grid at
 * regular intervals to animate the simulation.
 * 
 * @author Nathan Willett
 * @section 15596
 * @course CS 142, Spring 2024
 */
public class LifeGui {
    private LifeModel model;
    private JFrame frame;
    private LifePanel panel;
    private Timer timer;

    // constructor for the GUI
    public LifeGui(LifeModel model) {
        this.model = model;
        frame = new JFrame("Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new LifePanel();
        frame.add(panel);

        // Set the initial size and position of the window
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null); // Center the window on the screen

        frame.setVisible(true);

        // updates the grid every 500 ms
        timer = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // System.out.println("Advancing generation and repainting");
                model.update();
                panel.repaint();
            }
        });
    }

    // advances the simulation by one generation
    public void update() {
        // System.out.println("Advancing one generation");
        model.update();
        panel.repaint();
    }

    // starts the animation
    public void startAnimation() {
        // System.out.println("Starting animation");
        timer.start();
    }

    // stops the animation
    public void stopAnimation() {
        // System.out.println("Stopping animation");
        timer.stop();
    }

    // Inner class for the panel that draws the grid
    private class LifePanel extends JPanel {
        private static final int CELL_SIZE = 20;

        // Constructor to set the preferred size of the panel
        public LifePanel() {
            setPreferredSize(new Dimension(model.getCols() * CELL_SIZE, model.getRows() * CELL_SIZE));
        }

        // Override paintComponent to draw the grid
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // Call the superclass's paintComponent method
            for (int row = 0; row < model.getRows(); row++) { // Loop through each row
                for (int col = 0; col < model.getCols(); col++) { // Loop through each column
                    if (model.isAlive(row, col)) { // Check if the cell is alive
                        g.setColor(Color.BLACK); // Set color to black for alive cells
                    } else {
                        g.setColor(Color.WHITE); // Set color to white for dead cells
                    }
                    g.fillRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE); // Fill the cell with the
                                                                                        // appropriate color
                    g.setColor(Color.GRAY); // Set color to gray for cell borders
                    g.drawRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE); // Draw the cell border
                }
            }
        }
    }
}