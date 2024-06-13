// package a2_ExampleCodeByWeek.src.week1;

// // Allison Obourn
// // CS 142 - lecture 4

// // An ArrayIntList stores an ordered list of integers.
// // It starts with a length of 0 and increases in size whenever an element is
// // added. When an element is added in a spot where another element already
// // is, the element currently there and all after it move over to make room.
// // Likewise, when an element is removed the list adjusts itself so that
// // there are no empty indexes.

// // NOTE: This version of ArrayIntList can only store up to DEFAULT_CAPACITY
// //       elements. We will fix this on Monday.

// import java.util.*;

// public class ArrayIntList {
//     private int[] elementData;
//     private int size;

//     // a constant storing our initial size
//     public static final int DEFAULT_CAPACITY = 10;

//     // Initializes a new empty list with the default capacity.
//     public ArrayIntList() {
//         this(DEFAULT_CAPACITY);
//     }

//     // Initializes a new empty list with the specified initial capacity.
//     // Pre: capacity > 0, throws IllegalArgumentException otherwise
//     public ArrayIntList(int capacity) {
//         if (capacity <= 0) {
//             throw new IllegalArgumentException(
//                 "capacity must be positive: " + capacity);
//         }
//         elementData = new int[capacity];
//         size = 0;
//     }

//     // Adds the given value to the end of the list.
//     public void add(int value) {
//         add(size, value);
//     }

//     // Inserts the given value into the list at the given index.
//     // Pre: 0 <= index <= size, throws IndexOutOfBoundsException otherwise
//     public void add(int index, int value) {
//         checkIndex(index, 0, size); // ok to add at size (end of list)
//         for (int i = size; i > index; i--) {
//             elementData[i] = elementData[i - 1];
//         }
//         elementData[index] = value;
//         size++;
//     }

//     // Removes the value at the given index.
//     // Pre: 0 <= index < size, throws IndexOutOfBoundsException otherwise
//     public void remove(int index) {
//         checkIndex(index, 0, size);
//         for (int i = index; i < size; i++) {
//             elementData[i] = elementData[i + 1];
//         }
//         size--;
//     }

//     // Returns the value at the given index.
//     // Pre: 0 <= index < size, throws IndexOutOfBoundsException otherwise
//     public int get(int index) {
//         return elementData[index];
//     }

//     // Sets the given index to store the given value.
//     // Pre: 0 <= index < size, throws IndexOutOfBoundsException otherwise
//     public void set(int index, int value) {
//         elementData[index] = value;
//     }

//     // returns the number of elements in the list
//     public int size() {
//         return size;
//     }

//     // returns true if the list is empty and false otherwise
//     public boolean isEmpty() {
//         return size == 0;
//     }

//     // Returns a String representation of the list consisting of the elements
//     // in order, separated by commas and enclosed in square brackets.
//     public String toString() {
//         // NOTE: we will implement this Monday and you can copy-paste our code
//         // here
//         return "";
//     }

//     // If the given index is outside of the given bounds, throws an
//     // IndexOutOfBoundsException.
//     private void checkIndex(int index, int min, int max) {
//         if (index < min || index > max) {
//             throw new IndexOutOfBoundsException("index: " + index);
//         }
//     }
// }
