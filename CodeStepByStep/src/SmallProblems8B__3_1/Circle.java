// SMALL PROBLEMS 8B PART TWO [Circle]

package SmallProblems8B__3_1;

public class Circle {
    private double radius;

    public Circle(double r) {
        radius = r;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double circumference() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Circle{radius=" + radius + "}";
    }
}
