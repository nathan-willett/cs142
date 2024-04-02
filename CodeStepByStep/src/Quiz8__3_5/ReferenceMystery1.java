package Quiz8__3_5;

import java.util.Arrays;

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
