package Lab18__3_16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello world");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(300, 100));
        frame.setLayout(new FlowLayout());

        ActionListener listen = new MyActionListener();
        JButton button = new JButton("hello");
        button.setBackground(Color.BLUE);
        frame.add(button);
        button.addActionListener(listen);

        JButton button2 = new JButton("world");
        button2.setBackground(Color.RED);
        frame.add(button2);
    }
}
