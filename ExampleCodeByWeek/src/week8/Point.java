// CS& 141, Winter 2024
// Blueprint for creating objects of type Point
// which represents a location on a 2D x, y plane
/// Thanks to Allison Obourn for parts of this program

package week8;

import java.awt.*;

public class Point {
   private int x;
   private int y;
   
   // Creates a Point with the provided x and y
   // coordinates
   public Point(int x, int y) {
      this.x = x;
      this.y = y;
   }
   
   // Creates a Point with x and y coordinates
   // set to the origin
   public Point() { 
      this(0, 0);
   }
   
   // Draws a point as a dot with a coordinate label
   // with the provided Graphics g
   public void drawPoint(Graphics g) {
      g.fillOval(x, y, 3, 3);
      g.drawString(toString(), x, y);
   }
   
   // Moves the Point's x and y by a provided dx and
   // dy amount
   public void translate(int dx, int dy) {
      x += dx;
      y += dy;
   }
   
   // returns true if the passed in point has the same x as this point
   public boolean isVertical (Point other) {
      return other.x == x;
   }
   
   // returns the distance between this point and the origin (0, 0)
   public double distanceFromOrigin() {
      Point origin = new Point();
      return distancePoint(origin);
   }
   
   // returns the distance between this point and the passed in point
   // using the formuls squareroot ((x1-x2)^2 + (y1-y2)^2)
   public double distancePoint(Point other) {
      int dx = other.x - x;
      int dy = other.y - y;
      double distance = Math.sqrt(dx * dx + dy * dy);
      return distance;
   }
   
   // prints a String representing the passed in Point
   // in the format of (23, 42) where the numbers are the 
   // x and y coordinates
   public String toString() {
      return "(" + x + ", " + y + ")";
   }
   
   // sets the x coordinate to the passed in value
   public void setX(int value) {
      x = value;
   }
   
   // sets the y coordinate to the passed in value
   public void setY(int value) {
      y = value;
   }
}