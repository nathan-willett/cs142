

/**
 * Class: Location
 * 
 * Stores the x, y coordinates and elevation for each pixel on the map
 * 
 * @author Nathan Willett
 * @section 15596
 * @course CS 142, Spring 2024
 */
public class Location {
    private int x, y, elevation;

    public Location(int x, int y, int elevation) {
        this.x = x;
        this.y = y;
        this.elevation = elevation;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getElevation() { return elevation; }

    // Method to return a string representation of the location for debugging
    @Override
    public String toString() {
        return String.format("Location[x=%d, y=%d, elevation=%d]", x, y, elevation);
    }
}
