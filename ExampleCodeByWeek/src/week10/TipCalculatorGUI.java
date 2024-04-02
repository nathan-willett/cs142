package hellofx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TipCalculatorGUI {
   private JTextField textInput;
   private JLabel result;
   
   public TipCalculatorGUI() {
      JFrame frame = new JFrame("Tip Calculator");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(new Dimension(400, 150));
      frame.setLayout(new GridLayout(3, 1));

      JPanel topPanel = constructTopPanel();
      frame.add(topPanel);
      
      JPanel middlePanel = constructMiddlePanel();      
      frame.add(middlePanel);
      
      result = new JLabel("", SwingConstants.CENTER);
      frame.add(result);
      
      frame.setVisible(true);
   }
   
   private JPanel constructTopPanel() {
      JPanel topPanel = new JPanel(new FlowLayout());
      JLabel textLabel = new JLabel("Bill Subtotal: ");
      topPanel.add(textLabel);
      
      textInput = new JTextField(10);
      topPanel.add(textInput);
      return topPanel;
   }
   
   private JPanel constructMiddlePanel() {
      ActionListener listener = new MyTipActionListener();
      JPanel middlePanel = new JPanel(new FlowLayout());
      JButton button = new JButton("15%");
      button.addActionListener(listener);
      middlePanel.add(button);
      
      JButton button2 = new JButton("20%");
      button2.addActionListener(listener);
      middlePanel.add(button2);
      
      JButton button3 = new JButton("25%");
      button3.addActionListener(listener);
      middlePanel.add(button3);
      return middlePanel;
   }
   
   private class MyTipActionListener implements ActionListener {
      public void actionPerformed(ActionEvent event) {
         String buttonText = event.getActionCommand();
         String text = textInput.getText();
         double subtotal = Integer.parseInt(text);
         
         if(buttonText.equals("15%")) {
            subtotal = subtotal * 1.15;
         } else if(buttonText.equals("20%")) {
            subtotal = subtotal * 1.2;
         } else {
            subtotal = subtotal * 1.25;
         }
         subtotal = Math.round(subtotal * 100) / 100.0;
         result.setText("= " + subtotal);
      }
   }
}
