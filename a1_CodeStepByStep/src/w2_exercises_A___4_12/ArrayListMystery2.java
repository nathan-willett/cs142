package a1_CodeStepByStep.src.w2_exercises_A___4_12;

import java.util.*;

public class ArrayListMystery2 {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(40);
        myList.add(20);
        myList.add(60);
        myList.add(1);
        myList.add(80);
        myList.add(30);

        mystery(myList);
    }

    public static void mystery(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int n = list.get(i);
            if (n % 10 == 0) {
                list.remove(i);
                list.add(n);
            }
        }
        System.out.println(list);
    }
}
