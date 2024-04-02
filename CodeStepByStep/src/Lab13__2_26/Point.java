package Lab13__2_26;

public class Point {
    private int x;
    private int y;

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
}
