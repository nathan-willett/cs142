package a1_CodeStepByStep.src.w2_exercises_A___4_12;

import java.util.*;

public class ArrayListMystery3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // list.addAll(List.of(2, 4, 6, 8));
        // list.addAll(List.of(10, 20, 30, 40, 50, 60));
        list.addAll(List.of(-4, 16, 9, 1, 64, 25, 36, 4, 49));

        mystery(list);
    }

    public static void mystery(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i += 2) {
            int element = list.get(i);
            list.remove(i);
            list.add(element);
        }
        System.out.println(list);
    }
}
