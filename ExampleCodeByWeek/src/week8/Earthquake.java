// CS& 141, Winter 2024
// Reads data from a file, assumes that file has a number of cities first
// and then pairs of numbers for that many cities where the first one is
// the x coordinate of the city and the second the y coordinate of the city.
// displays these cities on a DrawingPanel and then asks the user for the x, y
// of the epicenter and the blast radius of an earthquake. Draws a circle around 
// the affected area on the DrawingPanel and colors all the cities in that circle 
// red
// Thanks to Allison Obourn for parts of this program

package week8;

import java.util.*;
import java.io.*;
import java.awt.*;
import graphics.DrawingPanel; // needed so we can use DrawingPanel

public class Earthquake {
   public static void main(String[] args) throws FileNotFoundException {
      
      DrawingPanel panel = new DrawingPanel(200, 200);
      Graphics g = panel.getGraphics();
      
      Point[] coords = readCities(g);
      
      // read in earthquake information from user
      Scanner console = new Scanner(System.in);
      System.out.print("Earthquake x? ");
      int earthquakeX = console.nextInt();
      System.out.print("Earthquake y? ");
      int earthquakeY = console.nextInt();
      System.out.print("Affected radius: ");
      int earthquakeRadius = console.nextInt();
      
      // draw the circle around the affected arrea
      g.drawOval(earthquakeX - earthquakeRadius, earthquakeY - earthquakeRadius, 
                 earthquakeRadius * 2, earthquakeRadius * 2);
      
      Point epicenter = new Point(earthquakeX, earthquakeY);
      
      markAffectedCities(coords, g, epicenter, earthquakeRadius);
      
      console.close();
    }
    
    // reads a file of city data assumed to be have the number of cities on the frist
    // line and then pairs of numbers for each cities x, y data following. Draws each
    // city on the DrawingPanel connected to the passed in graphics and builds up and
    // returns an array of city Points.
    public static Point[] readCities(Graphics g) throws FileNotFoundException {
      Scanner input = new Scanner(new File("c://CS141//cities.txt"));
      int cityCount = input.nextInt();
      Point[] coords = new Point[cityCount];
      
      for (int i = 0; i < cityCount; i++) {
          int x = input.nextInt();   // read each city
          int y = input.nextInt();
          coords[i] = new Point(x, y);
          coords[i].drawPoint(g);
      }
      return coords;
      input.close();
    }
    
    // sets the passed in graphics color to red. Redraws all of the cities that
    // are within the radius distance of the passed in epicenter in red.
    public static void markAffectedCities(Point[] coords, Graphics g, Point epicenter, int radius) {
      g.setColor(Color.RED);
      for(int i = 0; i < coords.length; i++) {
      //   double dist = coords[i].distance(epicenter);
         double dist = coords[i].distanceFromOrigin();
         if(dist < radius) {
            coords[i].drawPoint(g);
         }
      }
    }
}