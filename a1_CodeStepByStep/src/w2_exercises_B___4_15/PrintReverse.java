package a1_CodeStepByStep.src.w2_exercises_B___4_15;

import java.util.*;

public class PrintReverse {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(List.of("the", "cat", "in", "the", "hat"));
        printReverse(list);
    }

    public static void printReverse(ArrayList<String> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }
}
