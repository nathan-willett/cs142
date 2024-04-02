package Lab4__1_29;

public class loopTableSlashesConstant {
    // Class constant for the SIZE
    public static final int SIZE = 6; // you can change this to any size you want

    public static void main(String[] args) {
        // Call the printPattern method to print the pattern
        printPattern(SIZE);
    }

    // Method to print the pattern
    public static void printPattern(int size) {
        for (int line = 1; line <= size; line++) {
            int exclamationMarks = calculateExclamationMarks(line, size);
            printLine(exclamationMarks, line);
        }
    }

    // Method to calculate the number of exclamation marks for a given line
    public static int calculateExclamationMarks(int line, int size) {
        return -4 * line + (4 * size + 2);
    }

    // Method to print a single line of the pattern
    public static void printLine(int exclamationMarks, int line) {
        // Print leading backslashes
        for (int i = 1; i < line; i++) {
            System.out.print("\\\\");
        }
        
        // Print exclamation marks
        for (int i = 0; i < exclamationMarks; i++) {
            System.out.print("!");
        }
        
        // Print trailing forward slashes
        for (int i = 1; i < line; i++) {
            System.out.print("//");
        }
        
        System.out.println(); // Move to the next line
    }
}
