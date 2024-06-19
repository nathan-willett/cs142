package project4;

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

    /**
     * Constructs a Location object with specified x, y coordinates and elevation.
     * This class can handle elevations below sea level.
     * 
     * @param x         the x-coordinate of the location, must be non-negative.
     * @param y         the y-coordinate of the location, must be non-negative.
     * @param elevation the elevation of the location, can be negative for locations
     *                  below sea level.
     * @throws IllegalArgumentException if x or y are negative.
     */
    public Location(int x, int y, int elevation) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Coordinates must be non-negative");
        }
        this.x = x;
        this.y = y;
        this.elevation = elevation;
    }

    /**
     * Returns the x-coordinate of this location.
     * The x-coordinate indicates the horizontal position of the location on the map.
     * 
     * @return the x-coordinate, which is a non-negative integer.
     */
    public int getX() { return x; }

    /**
     * Returns the y-coordinate of this location.
     * The y-coordinate indicates the vertical position of the location on the map.
     * 
     * @return the y-coordinate, which is a non-negative integer.
     */
    public int getY() { return y; }

    /**
     * Returns the elevation of this location.
     * The elevation is the height above or below sea level. Negative values indicate locations below sea level.
     * 
     * @return the elevation, which can be a negative or positive integer.
     */
    public int getElevation() { return elevation; }

    // Method to return a string representation of the location for debugging
    @Override
    public String toString() {
        return String.format("Location[x=%d, y=%d, elevation=%d]", x, y, elevation);
    }
}
