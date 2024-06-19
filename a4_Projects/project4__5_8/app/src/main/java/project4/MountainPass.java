package project4;

import java.awt.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * This class handles the processing of topographic data from a CSV file,
 * finding points of interest (highest, lowest) and determining a path 
 * with the least amount of elevation change. It also visualizes the data 
 * graphically and outputs results to the console.
 * 
 * @author Nathan Willett
 * @section 15596
 * @course CS 142, Spring 2024
 */
public class MountainPass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("File name? ");
        String filePath = scanner.nextLine(); // User inputs the file path
        scanner.close();
    
        Location[][] map = readFile(filePath); // Read map data from CSV
        if (map == null) {
            System.out.println("Failed to read file, exiting program.");
            return;
        }
    
        Location highest = findHighest(map); // Find the highest elevation point
        Location lowest = findLowest(map); // Find the lowest elevation point
        List<Location> path = findPath(map); // Determine the path with minimal elevation change
        
        // Calculate total and steepest elevation changes
        int totalElevationChange = 0;
        int steepestElevationChange = 0;
        if (!path.isEmpty()) {
            int previousElevation = path.get(0).getElevation();
            for (int i = 1; i < path.size(); i++) {
                int currentElevation = path.get(i).getElevation();
                int elevationChange = Math.abs(currentElevation - previousElevation);
                totalElevationChange += elevationChange;
                if (elevationChange > steepestElevationChange) {
                    steepestElevationChange = elevationChange;
                }
                previousElevation = currentElevation;
            }
        }
    
        outputResults(highest, lowest, path, totalElevationChange, steepestElevationChange); // Output results to the console
        drawMap(map, highest, lowest, path); // Draw the map with the path and points highlighted
    }
    
    /**
     * Reads elevation data from a CSV file into a 2D Location array.
     * 
     * @param filePath The path to the CSV file
     * @return A 2D array of Location objects representing the elevation map
     */
    private static Location[][] readFile(String filePath) {
        List<Location[]> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Read the first line to skip or to extract dimensions
            if (line == null) return null; // Check if the file is empty
    
            String[] firstLine = line.split(",");
            if (firstLine.length == 2) {  // Check if it's likely the dimensions line
                // If dimensions are needed, use them to initialize your array or skip
                line = br.readLine();  // Read next line assuming first line was dimensions
            }
            
            int y = 0;
            while (line != null) {
                String[] values = line.split(",");
                Location[] row = new Location[values.length];
                for (int x = 0; x < values.length; x++) {
                    int elevation = Integer.parseInt(values[x].trim());
                    row[x] = new Location(x, y, elevation);
                }
                rows.add(row);
                y++;
                line = br.readLine(); // Move to the next line in the file
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return null;
        }
        return rows.toArray(new Location[0][]);
    }

    /**
     * Finds the highest elevation level
     * 
     * @param map A 2D array of Location objects.
     * @return The Location of the highest elevation.
     */
    private static Location findHighest(Location[][] map) {
        Location highest = map[0][0];
        for (Location[] row : map) {
            for (Location loc : row) {
                if (loc.getElevation() > highest.getElevation()) {
                    highest = loc;
                }
            }
        }
        return highest;
    }

    /**
     * Finds the lowest elevation level
     * 
     * @param map A 2D array of Location objects.
     * @return The Location of the lowest elevation.
     */
    private static Location findLowest(Location[][] map) {
        Location lowest = map[0][0];
        for (Location[] row : map) {
            for (Location loc : row) {
                if (loc.getElevation() < lowest.getElevation()) {
                    lowest = loc;
                }
            }
        }
        return lowest;
    }

    /**
     * Calculates the path across the map with the least elevation change from west
     * to east.
     * 
     * @param map A 2D array of Location objects.
     * @return A list of Location objects representing the path.
     */
    private static List<Location> findPath(Location[][] map) {
        List<Location> path = new ArrayList<>();
        int currentRow = (int) (Math.random() * map.length);
        Location currentLocation = map[currentRow][0];
        path.add(currentLocation);

        for (int x = 1; x < map[0].length; x++) {
            Location next = map[currentRow][x];
            int currentElevation = currentLocation.getElevation();

            if (currentRow > 0 && Math.abs(map[currentRow - 1][x].getElevation() - currentElevation) < Math
                    .abs(next.getElevation() - currentElevation)) {
                next = map[currentRow - 1][x];
            }
            if (currentRow < map.length - 1 && Math.abs(map[currentRow + 1][x].getElevation() - currentElevation) < Math
                    .abs(next.getElevation() - currentElevation)) {
                next = map[currentRow + 1][x];
            }

            currentLocation = next;
            currentRow = currentLocation.getY();
            path.add(currentLocation);
        }
        return path;
    }

    /**
     * Draws the map with points and path highlighted.
     * 
     * @param map     The 2D array of Location objects representing the elevation map.
     * @param highest The highest point on the map.
     * @param path    The calculated path with the lowest elevation change.
     */
    public static void drawMap(Location[][] map, Location highest, Location lowest, List<Location> path) {
        int mapWidth = map[0].length;
        int mapHeight = map.length;
        int maxDimension = Math.max(mapWidth, mapHeight);

        int cellSize = Math.max(1, 500 / maxDimension);
        int panelWidth = mapWidth * cellSize;
        int panelHeight = mapHeight * cellSize;

        BufferedImage image = new BufferedImage(panelWidth, panelHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        int minElevation = lowest.getElevation();
        int maxElevation = highest.getElevation();
        double scale = (maxElevation != minElevation) ? 255.0 / (maxElevation - minElevation) : 0;

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                int elevation = map[y][x].getElevation();
                int grayValue = (int) ((elevation - minElevation) * scale);
                Color color = new Color(grayValue, grayValue, grayValue);
                g.setColor(color);
                g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
            }
        }

        g.setColor(Color.RED);
        g.fillRect(highest.getX() * cellSize, highest.getY() * cellSize, cellSize, cellSize);

        g.setColor(Color.GREEN);
        for (Location step : path) {
            g.fillRect(step.getX() * cellSize, step.getY() * cellSize, cellSize, cellSize);
        }

        g.dispose();
        JFrame frame = new JFrame("Mountain Pass Map");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(panelWidth + 20, panelHeight + 40);
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.setVisible(true);
    }

    /**
     * Outputs the results of the highest point, lowest point, and path calculation
     * to the console.
     * 
     * @param highest The highest elevation point found.
     * @param lowest  The lowest elevation point found.
     * @param path    The list of Locations representing the path with the least
     *                elevation change.
     */
    public static void outputResults(Location highest, Location lowest, List<Location> path, int totalElevationChange, int steepestElevationChange) {
        System.out.println("Mountain Peak: " + formatLocation(highest));
        System.out.println("Lowest Point: " + formatLocation(lowest));
        System.out.print("Lowest Elevation Change Route: ");
    
        // Check if path is not empty to avoid errors
        if (!path.isEmpty()) {
            for (int i = 0; i < path.size(); i++) {
                if (i > 0) System.out.print(", ");  // Add comma before all but the first entry
                System.out.print(formatLocation(path.get(i)));
            }
            System.out.println(); // Ensure the output ends with a newline
        }
    
        System.out.println("Total Elevation Change: " + totalElevationChange);
        System.out.println("Steepest Elevation Change: " + steepestElevationChange);
    }

    /**
     * Formats a Location object into a string for output.
     * 
     * @param loc The Location to format.
     * @return A formatted string representing the location.
     */
    private static String formatLocation(Location loc) {
        return String.format("(%d, %d) with elevation %d", loc.getX(), loc.getY(), loc.getElevation());
    }
}
