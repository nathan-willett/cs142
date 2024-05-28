package a1_CodeStepByStep.src.w8_exercises_B___5_27;

import javax.swing.*;
import java.awt.*;

public class ExampleGUI2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(400, 400));
        frame.setLayout(new BorderLayout());

        // North Panel with FlowLayout
        JPanel northPanel = new JPanel(new FlowLayout());
        northPanel.add(new JButton("number 1"));
        northPanel.add(new JButton("number 2"));
        frame.add(northPanel, BorderLayout.NORTH);

        // East Panel with FlowLayout
        JPanel eastPanel = new JPanel(new FlowLayout());
        eastPanel.add(new JButton("number 3"));
        eastPanel.add(new JButton("number 4"));
        frame.add(eastPanel, BorderLayout.EAST);

        // South Panel with FlowLayout
        JPanel southPanel = new JPanel(new FlowLayout());
        southPanel.add(new JButton("number 5"));
        southPanel.add(new JButton("number 6"));
        frame.add(southPanel, BorderLayout.SOUTH);

        // West Panel with FlowLayout
        JPanel westPanel = new JPanel(new FlowLayout());
        westPanel.add(new JButton("number 7"));
        westPanel.add(new JButton("number 8"));
        frame.add(westPanel, BorderLayout.WEST);

        // Center Panel with FlowLayout
        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.add(new JButton("number 9"));
        centerPanel.add(new JButton("number 10"));
        frame.add(centerPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}

