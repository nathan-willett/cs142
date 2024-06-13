package week6.Shape;

// Allison Obourn
// CS 142, Spring 2024
// Lecture 22

// Represents a rectangle. Rectangles have a width and
// a height from which we can compute how big it is

public class Rectangle implements Shape {
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
}