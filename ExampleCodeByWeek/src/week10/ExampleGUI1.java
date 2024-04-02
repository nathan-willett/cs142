package hellofx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExampleGUI1 {
   public static void main(String[] args) {
      JFrame frame = new JFrame("Example");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(new Dimension(400, 400));
      frame.setLayout(new FlowLayout());

      for(int i = 0; i < 10; i++) {
         JButton button = new JButton("number " + i);
         frame.add(button);
      }      
      frame.setVisible(true);
   }
}
