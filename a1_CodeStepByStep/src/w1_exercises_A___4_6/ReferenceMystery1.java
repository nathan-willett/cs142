package w1_exercises_A___4_6;

import java.util.Arrays;

// The following program produces 4 lines of output. Write each line of output below as it would appear on the console.
public class ReferenceMystery1 {
    public static void main(String[] args) {
        int y = 1;
        int x = 3;
        int[] a = new int[4];
        mystery(a, y, x);
        System.out.println(x + " " + y + " " + Arrays.toString(a));
        x = y - 1;
        mystery(a, y, x);
        System.out.println(x + " " + y + " " + Arrays.toString(a));
    }

    public static void mystery(int[] a, int x, int y) {
        if (x < y) {
            x++;
            a[x] = 17;
        } else {
            a[y] = 17;
        }
        System.out.println(x + " " + y + " " + Arrays.toString(a));
    }
}
