package a1_CodeStepByStep.src.w5_exercises_B___5_6;

public class Array2dMystery {
    public static void main(String[] args) {
        int[][] numbers = {
                { 3, 4, 5, 6 },
                { 4, 5, 6, 7 },
                { 5, 6, 7, 8 }
        };
        arrayMystery2D(numbers);
    }

    public static void arrayMystery2D(int[][] numbers) {
        for (int r = 0; r < numbers.length; r++) {
            for (int c = 0; c < numbers[0].length - 1; c++) {
                if (numbers[r][c + 1] > numbers[r][c]) {
                    numbers[r][c] = numbers[r][c + 1];
                }
            }
        }
    }
}
