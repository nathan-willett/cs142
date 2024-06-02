import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class TipGUI {
   private JTextField subtotal;
   private JLabel result;

   public TipGUI() {
     JFrame window = new JFrame("Tip Calculator");
     window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     window.setSize(400, 150);
     window.setLayout(new GridLayout(3, 1));
     
     JPanel topPanel = new JPanel();
     // add label + textbox
     JLabel prompt = new JLabel("Bill Subtotal: ");
     topPanel.add(prompt);
     subtotal = new JTextField(8);
     topPanel.add(subtotal);
     window.add(topPanel);
     
     JPanel buttonPanel = new JPanel();
     ActionListener listener = new TipActionListener();    
     JButton smallest = createButton("15%", buttonPanel, listener);
     JButton middle = createButton("20%", buttonPanel, listener);
     JButton largest = createButton("25%", buttonPanel, listener);
     window.add(buttonPanel);

     result = new JLabel("=");
     JPanel panelResult = new JPanel();
     panelResult.add(result);
     window.add(panelResult);

     window.setVisible(true);
   }
   
   public JButton createButton(String text, JPanel buttonPanel, ActionListener listener) {
     JButton other = new JButton(text);
     other.addActionListener(listener);
     buttonPanel.add(other);
     return other;
   }
   
   private class TipActionListener implements ActionListener {
      public void actionPerformed (ActionEvent event) {
         System.out.println("clicked " + event.getActionCommand());
         int percentage = 15;
         if(event.getActionCommand().equals("25%")) {
            percentage = 25;
         } else if(event.getActionCommand().equals("20%") ) {
            percentage = 20;
         }
         int amount = Integer.parseInt(subtotal.getText());
         System.out.println("amount = " + amount);
         
         result.setText("" + (amount * percentage / 100.0 + amount));
      }
   }
}