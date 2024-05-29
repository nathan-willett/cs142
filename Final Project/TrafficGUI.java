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
    }

    private void initialize() {
       
    }
}
