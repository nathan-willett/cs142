/**
 * Class: MountainPass
 * 
 * 
 * 
 * @author Nathan Willett
 * @section 15596
 * @course CS 142, Spring 2024
 */
public class MountainPass {
    public static void main(String[] args) {
        Location[][] map = readFile("path/to/csv");
        Location highest = findHighest(map);
        Location lowest = findLowest(map);
        List<Location> path = findPath(map);
        outputResults(highest, lowest, path);
        drawMap(map, path);

    }
    
    private static Location[][] readFile(String filePath) {
        // Read CSV and initialize Location objects
        return new Location[0][0]; // placeholder
    }

    private static List<Location> findPath(Location[][] map) {
        // Implement greedy algorithm to find path
        return new ArrayList<>(); // placeholder
    }
}
