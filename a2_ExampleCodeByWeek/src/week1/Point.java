// package a2_ExampleCodeByWeek.src.week1;

// // Allison Obourn
// // CS 142 - Spring 2024
// // Lecture 3

// // a Point represents a coordinate in a 2d system.
// // Both x and y are zero in the upper left corner of the graph
// // and y increases as it moves down and x increases as it moves
// // to the right. Therefore Points will always have positive or zero
// // x and y locations

// public class Point {
//     // the coordinates of this point
//     private int x;
//     private int y;

//     // creates a new Point representing the origin (0, 0).
//     public Point() {
//         this(0, 0);
//     }

//     // creates a new Point representing the passed in x and y location
//     // precondition: x and y are both greater or equal to zero. If not,
//     // throws an IllegalArgumentException
//     public Point(int xStart, int yStart) {
//         if (x < 0 || y < 0) {
//             throw new IllegalArgumentException();
//         }
//         x = xStart;
//         y = yStart;
//     }

//     // sets the x coordinate of the point to the passed in value
//     // precondition: the passed in x is greater or equal to zero. If not,
//     // throws an IllegalArgumentException
//     public void setX(int x) {
//         if (x < 0) {
//             throw new IllegalArgumentException();
//         }
//         this.x = x;
//     }

//     // sets the y coordinate of the point to the passed in value
//     // precondition: the passed in y is greater or equal to zero. If not,
//     // throws an IllegalArgumentException
//     public void setY(int y) {
//         if (y < 0) {
//             throw new IllegalArgumentException();
//         }
//         this.x = x;
//     }

//     // returns the x coordinate of the point
//     public int getX() {
//         return x;
//     }

//     // returns the y coordinate of the point
//     public int getY() {
//         return y;
//     }

//     // moves the point the passed in dx amount further right and the
//     // passed in dy amount further down.
//     // precondition: x + dx and y + dy are both greater or equal to zero.
//     // If not, throws an IllegalArgumentException
//     public void translate(int dx, int dy) {
//         if (x + dx < 0 || y + dy < 0) {
//             throw new IllegalArgumentException();
//         }
//         x = x + dx;
//         y = y + dy;
//     }

//     // returns the distance from the origin (0, 0) to this particular point.
//     public double distanceFromOrigin() {
//         return Math.sqrt(x * x + y * y);
//     }
// }
