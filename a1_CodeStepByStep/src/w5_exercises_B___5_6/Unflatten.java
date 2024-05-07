package a1_CodeStepByStep.src.w5_exercises_B___5_6;

public class Unflatten {
    public static void main(String[] args) {
        //          0  1   2  3  4   5   6   7   8    9  10  11 
        int[] a = { 3, 8, 12, 2, 9, 17, 43, -8, 46, 203, 14, 97 }; // 12 values total
        
        // test 1, output to 12 cells, 4 x 3
        // expected result: successful
        try {                                                       
            int[][] result = unflatten(a, 4, 3);
            print2DArray(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // test 2, output to 12 cells, 6 x 2
        // expected result: successful
        try {
            int[][] result2 = unflatten(a, 6, 2);
            print2DArray(result2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // test 3, output to 15 cells, 3 x 5
        // expected result: throws exception.
        try {
            int[][] result3 = unflatten(a, 3, 5); // 15 values needed. Only 12 in the array.
            print2DArray(result3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Process the 1-D array into a 2-D array
    public static int[][] unflatten(int[] a, int rows, int cols) {
        // check if the 1-D array contains enough values for what is required by the 2-D array
        if (a.length != rows * cols) {
            throw new IllegalArgumentException("Array size does not match the specified dimensions.");
        }

        int[][] result = new int[rows][cols];
        int k = 0; // To track the index in the 1-D array 'a'

        for (int i = 0; i < rows; i++) { // for each row
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[k++];
            }
        }
        return result;
    }

    public static void print2DArray(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println();
        }
        System.out.println();
    }
}
