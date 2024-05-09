// Allison Obourn
// CS 142, Spring 2024
// Lecture 21

// Reads in words from a file, counts them, prints all words and their
// counts that have a count of more than one. Finally prints all words and
// counts.

import java.io.*;
import java.util.*;

public class Words {
    // the name of the file the program reads
    public static final String FILE_NAME = "words.txt";

    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Integer> words = readData();

        // go through all the words read in and output all that occur more than
        // once along with the exact number of times they occur
        for (String word : words.keySet()) {
            // get the key associated with this value
            int count = words.get(word);
            if (count > 1) {
                System.out.println(word + " - " + count);
            }
        }

        // print all of the words and counts read
        System.out.println(words);
    }

    // reads words from a text file one at a time counting up their
    // occurrence in the file. Returns a map containing each unique
    // word mapped to the number of times it occurred.
    // precondition: the file exists
    public static HashMap<String, Integer> readData()
        throws FileNotFoundException {
        HashMap<String, Integer> words = new HashMap<>();
        Scanner input = new Scanner(new File(FILE_NAME));

        // add all words from file into the map
        while (input.hasNext()) {
            String current = input.next();
            if (words.containsKey(current)) {
                // add to the count if we have seen the word before
                words.put(current, words.get(current) + 1);
            } else {
                // add the word for the first time with a count of 1
                words.put(current, 1);
            }
        }
        return words;
    }
}