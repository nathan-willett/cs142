package a1_CodeStepByStep.src.w6_exercises_B___5_13;

public class Sequence {
    public static void main(String[] args) {
        sequence(1);  // Output: 1
        sequence(2);  // Output: (2 + 1)
        sequence(3);  // Output: ((2 + 1) + 3)
        sequence(4);  // Output: (4 + ((2 + 1) + 3))
        sequence(5);  // Output: ((4 + ((2 + 1) + 3)) + 5)
        sequence(6);  // Output: (6 + ((4 + ((2 + 1) + 3)) + 5))
        sequence(7);  // Output: ((6 + ((4 + ((2 + 1) + 3)) + 5)) + 7)
        sequence(8);  // Output: (8 + ((6 + ((4 + ((2 + 1) + 3)) + 5)) + 7))
        sequence(9);  // Output: ((8 + ((6 + ((4 + ((2 + 1) + 3)) + 5)) + 7)) + 9)
        sequence(10); // Output: (10 + ((8 + ((6 + ((4 + ((2 + 1) + 3)) + 5)) + 7)) + 9))
    }

    public static void sequence(int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("Input must be a positive integer.");
        }
        System.out.println(generateSequence(k));
    }

    private static String generateSequence(int k) {
        if (k == 1) {
            return "1";
        } else if (k % 2 == 0) {
            return "(" + k + " + " + generateSequence(k - 1) + ")";
        } else {
            return "(" + generateSequence(k - 1) + " + " + k + ")";
        }
    }
}
