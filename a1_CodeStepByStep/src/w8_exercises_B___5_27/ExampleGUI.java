package a1_CodeStepByStep.src.w8_exercises_B___5_27;

import javax.swing.*;
import java.awt.*;

public class ExampleGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(400, 400));
        frame.setLayout(new BorderLayout());
        
        JButton button1 = new JButton("number 1");
        frame.add(button1, BorderLayout.NORTH);

        JButton button2 = new JButton("number 2");
        frame.add(button2, BorderLayout.EAST);

        JButton button3 = new JButton("number 3");
        frame.add(button3, BorderLayout.SOUTH);

        JButton button4 = new JButton("number 4");
        frame.add(button4, BorderLayout.WEST);

        JButton button5 = new JButton("number 5");
        frame.add(button5, BorderLayout.CENTER);

        JButton button6 = new JButton("number 6");
        frame.add(button6);

        JButton button7 = new JButton("number 7");
        frame.add(button7, BorderLayout.NORTH);

        frame.setVisible(true);
    }
}
