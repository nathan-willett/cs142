package a1_CodeStepByStep.src.w5_exercises_B___5_6;

public class Array2dMystery {
    public static void main(String[] args) {
        int[][] numbers = {
                { 3, 4, 5, 6 },
                { 4, 5, 6, 7 },
                { 5, 6, 7, 8 }
        };
        
        System.out.println("Initial array:");
        printArray(numbers, -1, -1); // Initial print with no highlight
        arrayMystery2D(numbers);
        System.out.println("Final array:");
        printArray(numbers, -1, -1); // Final print with no highlight
    }

    // iterate through each row, column, and modify the array
    public static void arrayMystery2D(int[][] numbers) {
        for (int r = 0; r < numbers.length; r++) {                  // iterate through each row (outer loop)
            for (int c = 0; c < numbers[0].length - 1; c++) {       // iterate through each column (inner loop)
                if (numbers[r][c + 1] > numbers[r][c]) {            // if the number in the column to the right is bigger
                    numbers[r][c] = numbers[r][c + 1];              // set the value to the value on the right
                    
                    // Print the array after each update with more descriptive highlighting
                    System.out.printf("After modifying row: [%d] col: [%d]:\n", r, c);
                    printArray(numbers, r, c);
                }
            }
        }
    }

    // Enhanced printArray method to highlight the modified value(just for displaying output)
    public static void printArray(int[][] array, int rowHighlight, int colHighlight) {
        for (int r = 0; r < array.length; r++) {                    // for each row (the outer loop)
            for (int c = 0; c < array[r].length; c++) {             // and for each column (the inner loop)
                if (r == rowHighlight && c == colHighlight) {
                    System.out.print("[" + array[r][c] + "] ");     // Highlight the changed element
                } else {
                    System.out.print(array[r][c] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();                                       // Add an extra blank line for better readability
    }
}
