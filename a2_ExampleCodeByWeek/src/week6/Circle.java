// Allison Obourn
// CS 142, Spring 2024
// Lecture 22

// Represents a circle. Circles have a radius from which
// we can compute how big it is

import java.util.*;

public class Circle implements Shape {
   private int radius;
   
   public Circle(int r) {
      radius = r;
   }
   
   // returns the area of a circle
   public double area() {
      return Math.PI * radius * radius;
   }
   
   // returns the perimeter of the circle
   public double perimeter() {
      return 2 * Math.PI * radius;
   }
}