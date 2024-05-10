package a2_ExampleCodeByWeek.src.week6.Shape;
// Allison Obourn
// CS 142, Spring 2024
// Lecture 22

// Represents any sort of shape. Shapes all have a 
// perimeter and an area.

public interface Shape {

   // returns the area of the shape
   public double area();
   
   // returns the permeter of the shape
   public double perimeter();
}