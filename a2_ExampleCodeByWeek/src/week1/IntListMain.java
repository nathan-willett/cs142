package a2_ExampleCodeByWeek.src.week1;

// Allison Obourn
// CS 123 - lecture 4

// Client program to test the ArrayIntList functionality
// Creates an empty ArrayIntList, adds numbers 0 - 4 inclusive
// in order smallest to greatest and then adds a number in the middle

public class IntListMain {
    public static void main(String[] args) {
        ArrayIntList list = new ArrayIntList();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        list.add(2, 7);
    }
}
