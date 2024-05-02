package a1_CodeStepByStep.src.w4_lab7___4_23;

public class MatrixAdd {
    public static void main(String[] args) {
        // Example matrices A and B
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] B = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        // Create an instance of MatrixAdd to use the matrixAdd method
        MatrixAdd matrixAdder = new MatrixAdd();
        int[][] result = matrixAdder.matrixAdd(A, B);

        // Print the resulting matrix
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] matrixAdd(int[][] A, int[][] B) {
        int rows = A.length;
        int columns = A[0].length;
        int[][] C = new int[rows][columns];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        
        return C;
    }
}

