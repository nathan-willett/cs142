package a1_CodeStepByStep.src.w8_exercises_B___5_27;

import javax.swing.*;
import java.awt.*;

public class TipCalculatorGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TipCalculatorGUI();
            }
        });
    }

    public TipCalculatorGUI() {
        JFrame frame = new JFrame("Tip Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(400, 150));
        frame.setLayout(new GridLayout(3, 1));

        JPanel topPanel = constructTopPanel();
        frame.add(topPanel);

        JPanel middlePanel = constructMiddlePanel();
        frame.add(middlePanel);

        JLabel result = new JLabel("", SwingConstants.CENTER);
        frame.add(result);

        frame.setVisible(true);
    }

    private JPanel constructTopPanel() {
        JPanel topPanel = new JPanel(new FlowLayout());
        JLabel textLabel = new JLabel("Bill Subtotal: ");
        topPanel.add(textLabel);

        JTextField textInput = new JTextField(10);
        topPanel.add(textInput);
        return topPanel;
    }

    private JPanel constructMiddlePanel() {
        JPanel middlePanel = new JPanel(new FlowLayout());
        JButton button = new JButton("15%");
        middlePanel.add(button);

        JButton button2 = new JButton("20%");
        middlePanel.add(button2);

        JButton button3 = new JButton("25%");
        middlePanel.add(button3);
        return middlePanel;
    }
}
