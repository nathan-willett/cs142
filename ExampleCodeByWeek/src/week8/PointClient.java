// CS& 141, Winter 2024
// Client that uses our custom Point class.
// Point.java must be in the same folder for this code to work.
// Creates two points, prints one, assigns them locations, prints 
// them to the console and then draws both on a DrawingPanel.
// Thanks to Allison Obourn for parts of this program

package week8;

import java.awt.*;

public class PointClient {
   public static void main(String[] args) {
      Point p1 = new Point(40, 30);
      Point p2 = new Point();
      p2.setX(50);
      p2.setY(60);
      
      DrawingPanel panel = new DrawingPanel(200, 200);
      Graphics g = panel.getGraphics();
      
      p1.drawPoint(g);
      p2.drawPoint(g);
      
      p1.translate(100, 50);
      System.out.println(p1.distanceFromOrigin());
      System.out.println(p2);
   }
}