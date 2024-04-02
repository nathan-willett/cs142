package week2;

// Allison Obourn
// CS& 141
// Lecture 2

// This program opens a 200 by 300 window and draws a red rectangle covered by 
// a yellow oval. Both are located in the upper righthand corner.

import graphics.DrawingPanel; // needed so we can use DrawingPanel
import java.awt.*; // needed so we can use Color and Graphics

public class Drawing {
   public static void main(String [] args) {
      DrawingPanel panel = new DrawingPanel(200, 300);
      Graphics pen = panel.getGraphics();
      
      // dip our pen into a color so we can paint in that color
      pen.setColor(Color.RED);
      
      pen.drawRect(0, 0, 50, 70);
      pen.fillRect(0, 0, 50, 70);
      
      pen.setColor(Color.YELLOW);
      pen.fillOval(0, 0, 50, 70);
   }

}