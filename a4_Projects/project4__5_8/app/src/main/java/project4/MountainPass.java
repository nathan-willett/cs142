import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * Class: MountainPass
 * 
 * class description goes here
 * 
 * @author Nathan Willett
 * @section 15596
 * @course CS 142, Spring 2024
 */
public class MountainPass {
    public static void main(String[] args) {
        String filePath = "C:\\GitHub\\cs142\\a4_Projects\\project4__5_8\\app\\src\\main\\resources\\large.csv";
        Location[][] map = readFile(filePath);
        Location highest = findHighest(map);
        Location lowest = findLowest(map);
        List<Location> path = findPath(map);
        outputResults(highest, lowest, path);
        drawMap(map, highest, path);
    }

    private static Location[][] readFile(String filePath) {
        List<Location[]> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int y = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Location[] row = new Location[values.length];
                for (int x = 0; x < values.length; x++) {
                    int elevation = Integer.parseInt(values[x].trim()); // trim spaces
                    row[x] = new Location(x, y, elevation);
                }
                rows.add(row);
                y++;
            }
        } catch (IOException e) {
            System.err.println("Failed to read the file: " + e.getMessage());
            return null; // or handle differently
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format in file: " + e.getMessage());
            return null; // or handle differently
        }
        return rows.toArray(new Location[0][]);
    }

    private static Location findHighest(Location[][] map) {
        Location highest = map[0][0]; // Initialize with the first element
        for (Location[] row : map) {
            for (Location loc : row) {
                if (loc.getElevation() > highest.getElevation()) {
                    highest = loc;
                }
            }
        }
        return highest;
    }

    private static Location findLowest(Location[][] map) {
        Location lowest = map[0][0]; // Initialize with the first element
        for (Location[] row : map) {
            for (Location loc : row) {
                if (loc.getElevation() < lowest.getElevation()) {
                    lowest = loc;
                }
            }
        }
        return lowest;
    }

    private static int findMinElevation(Location[][] map) {
        int minElevation = Integer.MAX_VALUE;
        for (Location[] row : map) {
            for (Location loc : row) {
                if (loc.getElevation() < minElevation) {
                    minElevation = loc.getElevation();
                }
            }
        }
        return minElevation;
    }
    
    private static int findMaxElevation(Location[][] map) {
        int maxElevation = Integer.MIN_VALUE;
        for (Location[] row : map) {
            for (Location loc : row) {
                if (loc.getElevation() > maxElevation) {
                    maxElevation = loc.getElevation();
                }
            }
        }
        return maxElevation;
    }

    private static List<Location> findPath(Location[][] map) {
        List<Location> path = new ArrayList<>();
        // Start from a random row in the first column
        int currentRow = (int) (Math.random() * map.length);
        Location currentLocation = map[currentRow][0];
        path.add(currentLocation);

        // Traverse from left to right
        for (int x = 1; x < map[0].length; x++) {
            Location next = map[currentRow][x]; // Start by assuming the straight path forward
            int currentElevation = currentLocation.getElevation();

            // Check adjacent cells in the next column, if within bounds
            if (currentRow > 0 && Math.abs(map[currentRow - 1][x].getElevation() - currentElevation) < Math
                    .abs(next.getElevation() - currentElevation)) {
                next = map[currentRow - 1][x];
            }
            if (currentRow < map.length - 1 && Math.abs(map[currentRow + 1][x].getElevation() - currentElevation) < Math
                    .abs(next.getElevation() - currentElevation)) {
                next = map[currentRow + 1][x];
            }

            // Update current location and add to path
            currentLocation = next;
            currentRow = currentLocation.getY();
            path.add(currentLocation);
        }
        return path;
    }

    public static void drawMap(Location[][] map, Location highest, List<Location> path) {
        int mapWidth = map[0].length;
        // ...

        BufferedImage image = new BufferedImage(panelWidth, panelHeight, BufferedImage.TYPE_INT_RGB);
        double scale = 255.0 / (maxElevation - minElevation);

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

    public static void outputResults(Location highest, Location lowest, List<Location> path) {
        System.out.println("Results:");
        System.out.println("Highest Point: " + formatLocation(highest));
        System.out.println("Lowest Point: " + formatLocation(lowest));
        System.out.println("Path with the lowest elevation change:");
        path.forEach(loc -> System.out.print(formatLocation(loc) + " -> "));
        System.out.println(); // Add a newline for better format at the end
    }
    
    private static String formatLocation(Location loc) {
        return String.format("(%d, %d) with elevation %d", loc.getX(), loc.getY(), loc.getElevation());
    }
}
