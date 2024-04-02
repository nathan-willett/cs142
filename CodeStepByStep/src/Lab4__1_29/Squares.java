/*
 * Write a program in a class named Squares that uses the DrawingPanel to draw the following figure:
 * (image)
 * 
 * The drawing panel is 300 pixels wide by 200 pixels high. Its background is cyan. The horizontal and 
 * vertical lines are drawn in red and the diagonal line is drawn in black. The upper-left corner of the 
 * diagonal line is at (50,50). Successive horizontal and vertical lines are spaced 20 pixels apart. The 
 * diagonal line is drawn on top of the horizontal and vertical lines.
 *
 * (You don't need to include any import statements at the top of your program.) (The next two exercises are 
 * modified versions of this program, so you can use the code you write here as a starting point for those 
 * exercises.)
 */

 package Lab4__1_29;
 
 import java.awt.Color;
 import java.awt.Graphics;
 import graphics.DrawingPanel;
 
 public class Squares {
     public static void main(String[] args) {
         // Create a 300x200 DrawingPanel with a cyan background.
         DrawingPanel panel = new DrawingPanel(300, 200);
         panel.setBackground(Color.CYAN);
         Graphics g = panel.getGraphics();
 
         // Draw red squares and black diagonal lines.
         drawSquaresAndDiagonals(g);
     }
 
     private static void drawSquaresAndDiagonals(Graphics g) {
         final int startX = 50; // Starting X coordinate
         final int startY = 50; // Starting Y coordinate
         final int size = 20;   // Size increment for each square
 
         for (int i = 0; i < 5; i++) {
             int currentSize = size * i;
 
             // Set color to red for the squares.
             g.setColor(Color.RED);
             g.drawRect(startX, startY, currentSize, currentSize);
 
             // Set color to black for the diagonals.
             g.setColor(Color.BLACK);
             g.drawLine(startX, startY, startX + currentSize, startY + currentSize);
         }
     }
 }
 