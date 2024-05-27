package a1_CodeStepByStep.src.w8_exercises_A___5_24;

import java.util.ArrayList;
import java.util.List;

public class Intersect {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(List.of(1, 4, 8, 9, 11, 15, 17, 28, 41, 59));
        ArrayList<Integer> list2 = new ArrayList<>(List.of(4, 7, 11, 17, 19, 20, 23, 28, 37, 59, 81));

        ArrayList<Integer> result = intersect(list1, list2);
        System.out.println(result); // Output: [4, 11, 17, 28, 59]
    }

    public static ArrayList<Integer> intersect(List<Integer> list1, List<Integer> list2) {
        ArrayList<Integer> intersection = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).equals(list2.get(j))) {
                intersection.add(list1.get(i));
                i++;
                j++;
            } else if (list1.get(i) < list2.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return intersection;
    }
}
