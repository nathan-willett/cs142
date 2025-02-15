package week2;

import java.io.*;
import java.util.*;

// Allison Obourn
// CS 142 - Spring, 2024
// Lecture 6

// This program prints out a list of all words read from a file in the same
// order as they appear in the file. It then prints out the list again with 
// all plural words (words ending in s) removed. The rest remain in their 
// original order.
public class Plurals {
    // the name of the file the program reads
    public static final String FILE_NAME = "words.txt";

    public static void main(String[] args) throws FileNotFoundException {
        // reads data into the list
        ArrayIntList<String> words = readData();
        System.out.println(words);

        // removes all words ending in 's' from the list
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (word.charAt(word.length() - 1) == 's') {
                words.remove(i);
                i--;    
            }
        }
        System.out.println(words);
    }

    // reads words from a text file one at a time adding each to the end of a 
    // list that it returns. 
    // precondition: the file exists
    public static ArrayIntList<String> readData() throws FileNotFoundException {
        ArrayIntList<String> words = new ArrayIntList<>();
        Scanner input = new Scanner(new File(FILE_NAME));
        
        // add all words from file into list one at a time maintaining order
        while (input.hasNext()) {
            String current = input.next();
            words.add(current);
        }
        return words;
    }
}
