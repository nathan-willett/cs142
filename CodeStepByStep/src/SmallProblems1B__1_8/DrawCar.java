package SmallProblems1B__1_8;

// Write a method called drawCar that draws a car on a 200 wide and 100 tall DrawingPanel with a 
// light gray background. The car body should be a black rectangle 100 wide and 50 tall. 
// Its upper left corner should be 10 from the left side of the panel and 30 down from the top.
// 
// The car should have two circular red wheels that are 20 wide and 20 tall. They should both be 
// placed 70 from the top. One should be placed 20 from the left side, the other 80 from the left side.
// 
// The car should have a cyan colored windshield. It should be 30 wide, 20 tall and 
// placed 40 down and 80 from the left side.

import graphics.DrawingPanel;
import java.awt.*;

public class DrawCar {
   public static void main(String [] args) {
      DrawingPanel panel = new DrawingPanel(200, 100);
      Graphics g = panel.getGraphics();
      panel.setBackground(Color.LIGHT_GRAY);
      g.setColor(Color.BLACK);
      g.fillRect(10, 30, 100, 50);
      g.setColor(Color.RED);
      g.fillOval(20, 70, 20, 20);
      g.fillOval(80, 70, 20, 20);
      g.setColor(Color.CYAN);
      g.fillRect(80, 40, 30, 20);
   }
}