package Lab14__3_4;

public class Point {
    private int x;
    private int y;

    // LAB 14 PART TWO [constructorPointErrors]
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public static void main(String[] args) {
        // Example usage
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        
        // Testing methods
        System.out.println("Distance between p1 and p2: " + p1.distance(p2));
        System.out.println("Slope between p1 and p2: " + p1.slope(p2));
        System.out.println("Is p1 vertical to p2? " + p1.isVertical(p2));
        System.out.println("Manhattan distance between p1 and p2: " + p1.manhattanDistance(p2));
        
        // Flipping point
        p1.flip();
        System.out.println("Flipped p1: (" + p1.x + ", " + p1.y + ")");
    }
    
    // LAB 12 PART TWO [slopePoint]
    public double slope(Point other) {
        if (this.x == other.x) {
            throw new IllegalArgumentException("The x-coordinates are identical. Slope is undefined.");
        }
    
        return (double) (other.y - this.y) / (other.x - this.x);
    }

    // LAB 13 PART ONE [isVerticalPoint]
    public boolean isVertical(Point other) {
        if (this.x == other.x) {
            return true;
        }
        return false;
    }

    // LAB 13 PART TWO [flipPoint]
    public void flip() {
        int temp = x;
        x = -y;
        y = -temp;
    }

    // LAB 13 PART THREE [manhattanDistancePoint]
    public int manhattanDistance(Point other) {
        double dx = Math.pow((x - other.x), 2);
        double dy = Math.pow((y - other.y), 2);
        return (int) Math.abs(dx + dy);
    }

    // LAB 14 PART ONE [distancePoint]
    public double distance(Point other) {
        // subtract 
        double dx = x - other.x;
        double dy = y - other.y;

        double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        return distance;
    }
}
