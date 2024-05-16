// Allison Obourn
// CS 142, Spring 2024
// Lecture 22

// Represents a rectangle. Rectangles have a width and
// a height from which we can compute how big it is and its
// perimeter. They can also be compared to each other. Smaller
// rectangles are considered less than larger rectangles/

public class Rectangle implements Shape, Comparable<Rectangle> {
   private int width;
   private int height;
   
   public Rectangle(int w, int h) {
      width = w;
      height = h;
   }
   
   // returns the area of a rectangle
   public double area() {
      return width * height;
   }
   
   // returns the perimeter of the rectangle
   public double perimeter() {
      return 2 * (width + height);
   }
   
   // returns 0 if the rectangles have the same area, -1 if
   // this one is smaller than the other and 1 if it is bigger
   // than the passed in other.
   public int compareTo(Rectangle other) {
      double ourArea = area();
      double otherArea = other.area();
      if(ourArea < otherArea) {
         return -1;
      } else if (ourArea > otherArea) {
         return 1;
      } else {
         return 0;
      }
   }
   
   // returns a string with the width and height in parenthesis
   // separated by a comma and space.
   public String toString() {
      return "(" + width + ", " + height + ")";
   }
}