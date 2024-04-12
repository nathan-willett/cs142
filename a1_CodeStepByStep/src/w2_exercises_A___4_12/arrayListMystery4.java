package a1_CodeStepByStep.src.w2_exercises_A___4_12;

import java.util.*;

public class arrayListMystery4 {
    public static void main(String[] args) {

    }

    public static void mystery(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i) < list.get(i - 1)) {
                int n = list.get(i);
                list.remove(i);
                list.add(0, n);
            }
        }
        System.out.println(list);
    }

}
