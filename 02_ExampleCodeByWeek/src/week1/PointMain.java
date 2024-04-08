package week1;

// Allison Obourn
// CS 123 - lecture 3

// Client program to test our Point class.
// Creates two points at different x, y coordinates alters them and
// prints what they contain after alteration.

public class PointMain {
    public static void main(String[] args) {
        Point p = new Point();
        p.setX(4);
        p.setX(5);
        System.out.println("(" + p.getX() + ", " + p.getY() + ")");
        p.translate(5, 5);

        // NOTE: we originally printed like the below code. However, once
        //       we made our fields private we couldn't any more. We wrote
        //       getX and getY so we could still access this data.
        // System.out.println("(" + p.x + ", " + p.y + ")");

        Point other = new Point(3, 3);
        System.out.println("(" + other.getX() + ", " + other.getY() + ")");

        p.setX(100);
        System.out.println("(" + p.getX() + ", " + p.getY() + ")");
    }
}
