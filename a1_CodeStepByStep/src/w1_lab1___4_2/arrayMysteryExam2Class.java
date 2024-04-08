package a1_CodeStepByStep.src.w1_lab1___4_2;

import java.util.Arrays;

public class arrayMysteryExam2Class {
    public static void main(String[] args) {
        int[] a = { 5, 2, 5, 2 };
        // int[] a = {30, 10, 20, 50, 40};
        // int[] a = {99, 88, 77, 66, 55, 44};
        arrayMysteryExam2(a);
    }

    public static void arrayMysteryExam2(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                a[0]++;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
