import java.util.*;

public class SortedIntList {
   private int[] elementData;
   private int size;
   private boolean unique;

   // a constant storing our initial size
   public static final int DEFAULT_CAPACITY = 10;

   // Initializes a new empty list with the default capacity.
   public SortedIntList() {
      this(false, DEFAULT_CAPACITY);
   }

   /* 
    * Initializes a new empty list with a specified initial capacity of at least 1,
    * and a unique setting.
    *
    * Pre: capacity >= 0, throws IllegalArgumentException otherwise
    */
   public SortedIntList(boolean unique, int capacity) {
      if (capacity <= 0) {
         throw new IllegalArgumentException("capacity must be positive and at least 1: " + capacity);
      }
      this.elementData = new int[capacity];
      this.size = 0;
      this.unique = unique;
   }

   // Utilizes binary search to find the specified value
   public int indexOf(int value) {
      return Arrays.binarySearch(elementData, 0, size, value);
   }

   /**
    * Adds a new element to the list.
    *
    * Pre: If 'unique' is true, the value being added must not already be present in the list.
    * Post: Unless the value is rejected due to uniqueness constraints, the new value is added 
    * in sorted numeric order.
    * @param value The value to be added to the list.
    */
   void add(int value) {
      ensureCapacity(size + 1); // Make sure the list has room for a new element.
      int index = indexOf(value); // determine where to add the new value

      // if unique is true and the value already exists, do not add the new value.
      if (index >= 0 && unique) {
         return;
      }

      // If the value is not in the list, find the insertion point from the binary search
      if (index < 0) {
         index = -index - 1; // Convert the binary search result into an insertion point
      }

      // Working backwards through the list, shift all elements to the right by one,
      // until the insertion point 'posn' is reached.
      for (int i = size; i > index; i--) {
         elementData[i] = elementData[i - 1];
      }

      // Insert the new element at 'posn'. Increment 'size' by one.
      elementData[index] = value;
      size++;
   }

   // Removes the element at the given index.
   // Pre: 0 <= index < size, throws IndexOutOfBoundsException otherwise
   public void remove(int index) {
      checkIndex(index, 0, size - 1); // ensures index is valid
      for (int i = index; i < size - 1; i++) {
         // shift all elements to the right of 'index' to the left by one
         elementData[i] = elementData[i + 1];
      }
      // set the last element in the array to zero before decrementing 'size'
      elementData[size - 1] = 0;
      size--;
   }

   // Returns the value at the given index.
   // Pre: 0 <= index < size, throws IndexOutOfBoundsException otherwise
   public int get(int index) {
      return elementData[index];
   }

   // returns the number of elements in the list
   public int size() {
      return size;
   }

   // returns true if the list is empty and false otherwise
   public boolean isEmpty() {
      return size == 0;
   }

   public int min() {
      if (size == 0)
         throw new NoSuchElementException("List is empty");
      return elementData[0];
   }

   public int max() {
      if (size == 0)
         throw new NoSuchElementException("List is empty");
      return elementData[size - 1];
   }

   // Increases the capacity if needed to ensure that it can hold at least the
   // number of elements specified.
   // Post: elementData.length >= capacity
   private void ensureCapacity(int capacity) {
      if (elementData.length < capacity) {
         int newCapacity = elementData.length * 2;
         // Double the capacity until it meets the required capacity
         while (newCapacity < capacity) {
            newCapacity *= 2;
         }
         // Copy the existing elements into a new, larger array
         elementData = Arrays.copyOf(elementData, newCapacity);
      }
   }

   // If the given index is outside of the given bounds, throws an
   // IndexOutOfBoundsException.
   private void checkIndex(int index, int min, int max) {
      if (index < min || index > max) {
         throw new IndexOutOfBoundsException("index: " + index);
      }
   }

   // removes duplicates and ensures that no duplicates can be added so long as
   // this value remains true
   public void setUnique(boolean unique) {
      this.unique = unique;
      if (unique) {
         // Remove duplicates
         int writeIndex = 1; // Start from second element
         for (int readIndex = 1; readIndex < size; readIndex++) {
            if (elementData[readIndex] != elementData[writeIndex - 1]) {
               elementData[writeIndex++] = elementData[readIndex];
            }
         }
         size = writeIndex; // Update size after removing duplicates
      }
   }

   // Returns a String representation of the list consisting of the elements in
   // order, separated by commas and enclosed in square brackets.
   public String toString() {
      if (size == 0) {
         return "[]";
      } else {
         String output = "[" + elementData[0];
         for (int i = 1; i < size; i++) {
            output += ", " + elementData[i];
         }
         return output + "]";
      }
   }
}
