package a2_ExampleCodeByWeek.src.week6.Shape;
// Allison Obourn
// CS 142, Spring 2024
// Lecture 22

// Client program to test the shape interface and shape classes
// Creates a circle and a rectangle and prints out the area of each. 
// Then creates a list, adds the shapes and prints it out.

import java.util.*;

public class ShapeMain {
   public static void main(String[] args) {
      Circle c = new Circle(4);
      Rectangle r = new Rectangle(4, 4);
      
      compute(r);
      compute(c);
      
      Shape s;
      s = new Circle(3);
      
      List<Shape> a = new ArrayList<>();
      a.add(c);
      a.add(r);
      a.add(s);
      System.out.println(a);
   }
   
   // prints out the area of the passed in shape and then two other
   // lines of text
   public static void compute(Shape r) {
      System.out.println("area = " + r.area());
      System.out.println("It is a shape!"); 
      System.out.println("more text can go here...");
      // ...
   }
}