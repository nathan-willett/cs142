package a1_CodeStepByStep.src.w8_lab15___5_21;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerGUI extends JFrame {

    private Timer timer;
    private int progress = 0;

    public TimerGUI() {
        // Set up the frame
        setTitle("Timer GUI");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Create the buttons
        JButton btnOne = new JButton("1");
        JButton btnTwo = new JButton("2");
        JButton btnFour = new JButton("4");

        // Add buttons to the button panel
        buttonPanel.add(btnOne);
        buttonPanel.add(btnTwo);
        buttonPanel.add(btnFour);

        // Add the button panel to the top of the frame
        add(buttonPanel, BorderLayout.NORTH);

        // // Create a panel for the progress bar
        // JPanel progressPanel = new JPanel() {
        //     @Override
        //     protected void paintComponent(Graphics g) {
        //         super.paintComponent(g);
        //         int width = getWidth();
        //         int height = getHeight();
        //         g.setColor(Color.GREEN);
        //         g.fillRect(0, 0, width * progress / 100, height);
        //     }
        // };

        // // Add the progress panel to the center of the frame
        // add(progressPanel, BorderLayout.CENTER);

        // // Create a timer to update the progress bar
        // timer = new Timer(100, new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         progress++;
        //         if (progress > 100) {
        //             progress = 100;
        //             timer.stop();
        //         }
        //         progressPanel.repaint();
        //     }
        // });

        // Add action listeners to the buttons
        btnOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // timer.start();
                System.out.println(btnOne.getActionCommand());
            }
        });

        btnTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(btnTwo.getActionCommand());
            }
        });

        btnFour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(btnFour.getActionCommand());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TimerGUI().setVisible(true);
            }
        });
    }
}
