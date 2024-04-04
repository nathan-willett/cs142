package CodeStepByStep.src.w1_exercises_A___4_6;

import java.util.Arrays;

public class arrayMysteryExam4Class {
    public static void arrayMysteryExam4(int[] a) {
        for (int i = 1; i < a.length; i++) {
            a[i] = a[a.length - 1 - i] - a[i - 1];
        }
        System.out.println(Arrays.toString(a));
    }
}
