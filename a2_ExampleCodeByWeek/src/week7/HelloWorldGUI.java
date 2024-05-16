// Allison Obourn
// CS 142, Spring 2024
// Lecture 25

// Opens up a new GUI window that contains a button with the text
// "button 1" on it and then another button with the test "Other"
// on it and a red background. The second button appears right after
// the first. It will be on the same line if the window is wide enough
// on the next if not. The program will end when the window's upper
// right x is pressed. 

import javax.swing.*;
import java.awt.*;

public class HelloWorldGUI {
   public static void main(String[] args) {
     JFrame window = new JFrame("this is my title");
     window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     window.setSize(100, 200);
     // make items appear left to right one after another
     window.setLayout(new FlowLayout());
     
     // adding the first button
     JButton button = new JButton("Button 1");
     window.add(button);
     
     // adding the red button
     JButton other = new JButton("Other");
     other.setBackground(Color.RED);
     window.add(other);
     
     // make everything visible
     window.setVisible(true);
   }
}