package a1_CodeStepByStep.src.w6_exercises_B___5_13;

import java.util.*;

public class Clump {
    public static void main(String[] args) {
        // Example usage
        ArrayList<String> words = new ArrayList<>();
        words.add("four");
        words.add("score");
        words.add("and");
        words.add("seven");
        words.add("years");
        words.add("ago");
        words.add("our");

        System.out.println("Before clumping: " + words);
        clump(words);
        System.out.println("After clumping: " + words);
    }

    public static void clump(ArrayList<String> list) {
        // Create a new list to store the clumped strings
        ArrayList<String> clumpedList = new ArrayList<>();

        // Iterate through the list in steps of 2
        for (int i = 0; i < list.size(); i += 2) {
            // If there's a next element, combine the current and next element
            if (i + 1 < list.size()) {
                String clumped = "(" + list.get(i) + " " + list.get(i + 1) + ")";
                clumpedList.add(clumped);
            } else {
                // If there's no next element, add the current element as is
                clumpedList.add(list.get(i));
            }
        }

        // Replace the original list with the clumped list
        list.clear();
        list.addAll(clumpedList);
    }
}
