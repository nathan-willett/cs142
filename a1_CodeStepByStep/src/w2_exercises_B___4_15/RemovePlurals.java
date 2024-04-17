package a1_CodeStepByStep.src.w2_exercises_B___4_15;

import java.util.*;

/* Write a method named removePlurals that takes an ArrayList of strings as
a parameter and removes all strings ending in the letter s. For example if passed
{"she", "sells", "seas", "shells", "at", "the", "seas", "shore"}.
After the call it should hold {"she", "at", "the", "shore"}. */
public class RemovePlurals {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(List.of("she", "sells", "seas", "shells", "at", "the", "sea"));
        removePlurals(list);
        
        System.out.println("Modified list: " + list);
    }

    public static void removePlurals(ArrayList<String> list) {
        Iterator<String> it = list.iterator(); // Using an iterator to safely remove elements while iterating
        while (it.hasNext()) {
            String word = it.next();
            if (word.endsWith("s")) { // Checking if the string ends with 's'
                it.remove(); // Removing the element from the list if it ends with 's'
            }
        }
    }
}
