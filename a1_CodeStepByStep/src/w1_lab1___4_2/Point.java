package a1_CodeStepByStep.src.w1_lab1___4_2;

/* 
Write a class called Point that stores an x and y coordinate. Your Point class should have the following methods:

Name	                    Description
getX()	                    returns the x coordinate
getY()	                    returns the y coordinate
setX(int newX)	            sets the x coordinate to the parameter value
setY(int newY)	            sets the y coordinate to the parameter value
translate(int dx, int dy)	changes a Point's location by a given dx, dy amount.
distanceFromOrigin()	    returns the distance between a Point and the origin, (0, 0).

Use the following formula to compute the distance between two points.
*/

public class Point {
    private int x; // Declare x coordinate
    private int y; // Declare y coordinate

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int newX) {
        this.x = newX; // Set x to the new value
    }

    public void setY(int newY) {
        this.y = newY; // Set y to the new value
    }

    public void translate(int dx, int dy) {
        this.x += dx; // Move x by dx
        this.y += dy; // Move y by dy
    }

    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y); // Calculate distance from the origin
    }
}
