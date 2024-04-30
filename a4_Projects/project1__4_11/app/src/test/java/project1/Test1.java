// package a4_Projects.project1.app.src.test.java.project1;

// // CS 142, Project 1 (SortedIntList)
// //
// // This program tests stage 1 of the SortedIntList project.
// // You can change the constant values to conduct larger
// // tests to better verify your SortedIntList class.
// //
// // adapted from 9/29/06 version by Stuart Reges

// import java.util.*;

// public class Test1 {
// // number of elements to use in the checkAdd and checkIndexOf tests
//    public static final int BASIC_TEST_SIZE = 10;

// // number of elements to use in the checkSpeed test (should be very large)
//    public static final int SPEED_TEST_SIZE = 100000;

//    public static void main(String[] args) {
//       checkAdd(BASIC_TEST_SIZE);
//       checkIndexOf(BASIC_TEST_SIZE);
//       checkSpeed(SPEED_TEST_SIZE);
//       checkToString();
//       checkMinMax();
//    }

// // This method adds a series of numbers to the list and makes sure that
// // the size increases and that it produces a sorted list.
//    public static void checkAdd(int testSize) {
//       System.out.println("Beginning checkAdd basic add test of size " + testSize);
//       SortedIntList list = new SortedIntList(false, testSize);
//       Random r = new Random();
//       for (int i = 0; i < testSize; i++) {
//       // remember old list contents in case of a problem
//          String old = list.toString();
//       // pick a number between -testSize and +testSize, add to list
//          int next = r.nextInt(2 * testSize + 1) - testSize;
      
//          int expectedSize = i + 1;
      
//       // add to end of list
//          list.add(next);
      
//       // check list size and make sure list is sorted
//          if (list.size() != expectedSize) {
//             throw new RuntimeException("\n\nafter adding " + expectedSize
//                + " items, size = " + list.size() + " (should be " + expectedSize + ")\n");
//          } 
//          else if (!isSorted(list)) {
//             throw new RuntimeException(
//                "\n\nadding " + next + " failed; list is not sorted.\n" +
//                "List before add = " + old + ";\nlist after  add = " + list + "\n");
//          }
//       }
//       System.out.println("    Passed!\n");
//    }

// // This method adds values to the list and uses a boolean array to keep
// // track of what values have been added.  It then checks often to make
// // sure that indexOf returns values that make sense given the set of
// // values that have been added to the list.
//    public static void checkIndexOf(int testSize) {
//       System.out.println("Beginning checkIndexOf basic indexOf test of size " + testSize);
//       SortedIntList list = new SortedIntList(false, testSize);
//       Random r = new Random();
//    // numbers will be between -testSize and +testSize
//       boolean[] chosen = new boolean[2 * testSize + 1];
//       checkIndexes(testSize, chosen, list);
//       for (int i = 0; i < testSize; i++) {
//       // pick a number between -testSize and +testSize, add to list
//          int next = r.nextInt(2 * testSize + 1) - testSize;
//          list.add(next);
//          chosen[next + testSize] = true;
//          checkIndexes(testSize, chosen, list);
//       }
//       System.out.println("    Passed!\n");
//    }

// // This method constructs a very large list of even numbers and calls
// // indexOf many times to make sure that the code is fast.
//    public static void checkSpeed(int testSize) {
//       System.out.println("Beginning checkSpeed indexOf test of size " + testSize);
   
//    // keep track of starting time before constructing
//       long start = System.currentTimeMillis();
   
//    // fill up the list with even numbers
//       int dot = testSize / 10;
//       SortedIntList list = new SortedIntList(false, testSize);
//       System.out.print("    Building list of the first " + testSize + " multiples of 2: ");
//       boolean addTooSlow = false;
//       for (int i = 0; i < testSize; i++) {
//          list.add(2 * i);
//          if (i % dot == 0) {
//             System.out.print(".");
//          }
//          if (!addTooSlow && System.currentTimeMillis() >= start + testSize / 20) {
//             System.out.print(" (add is too slow) ");
//             addTooSlow = true;
//          }
//       }
//       System.out.println();
//       double elapsed = (System.currentTimeMillis() - start)/1000.0;
//    // System.out.println("    construction took " + elapsed + " seconds");
   
//    // keep track of starting time before indexOf tests
//       System.out.print("    Checking indexOf each element: ");
//       start = System.currentTimeMillis();
//       dot = testSize / 10;
//       for (int i = 0; i < testSize; i++) {
//          for (int j = 0; j < 100; j++) {
//             int actualIndex = list.indexOf(2 * i);
//             if (actualIndex != i) {
//                System.out.println();
//                throw new RuntimeException(
//                   "\n\nindexOf " + 2 * i + " should have returned: " +
//                   i + ",\n  but your method actually returned: " +
//                   actualIndex + "\n");
//             }
//          }
//          if (System.currentTimeMillis() >= start + testSize / 5) {
//             System.out.println();
//             throw new RuntimeException(
//                "\n\nindexOf appears to be running too slowly.\n");
//          }
//          if (i % dot == 0) {
//             System.out.print(".");
//          }
//       }
//       double elapsed2 = (System.currentTimeMillis() - start)/1000.0;
//       if (addTooSlow) {
//          System.out.println();
//          throw new RuntimeException(
//             "\n\nYour add method appears to have run too slowly.  (runtime: " + elapsed + " seconds)\n");
//       }
//       System.out.println("\n    Passed!  (runtime: " + elapsed2 + " seconds)\n");
//    }

// // returns true if list is sorted, false otherwise
//    public static boolean isSorted(SortedIntList list) {
//       for (int i = 0; i < list.size() - 1; i++) {
//          if (list.get(i) > list.get(i + 1)) {
//             return false;
//          }
//       }
//       return true;
//    }

// // Compares the boolean array to the SortedIntList to make sure that
// // they match.  If a number has not been chosen, then its index should be
// // reported as -1.  If it has been chosen, then it should have a
// // non-negative index and the number should actually be at that index.
//    public static boolean checkIndexes(int testSize, boolean[] chosen, SortedIntList list) {
//       for (int i = 0; i < chosen.length; i++) {
//          int original = i - testSize;
//          int index = list.indexOf(original);
      
//       // start by assuming it's not bad
//          boolean bad = false;
      
//       // then check for bad cases
//          if (chosen[i] && (index < 0 || index >= list.size()
//          || list.get(index) != original)) {
//             bad = true;
//          } 
//          else if (!chosen[i] && index >= 0) {
//             bad = true;
//          }
//          if (bad) {
//             String result = "\n\n" + original + " should not have index " + index
//                + "\nlist = " + list + "\n";
//          /*
//          // commenting out this output because it seems unhelpful
//          + " and chosen values =";
//          boolean any = false;
//          for (int j = 0; j < chosen.length; j++)
//          if (chosen[j]) {
//          result += " " + (j - testSize);
//          any = true;
//          }
//          if (!any) {
//          result += " nothing";
//          }
//          */
//             throw new RuntimeException(result);
//          }
//       }
//       return true;
//    }

// // Briefly tests the toString method for unique and non-unique lists.
//    public static void checkToString() {
//       System.out.println("Beginning toString test (should be [-1, 2, 5, 17] and [3, 6, 8, 42])");
//       SortedIntList list = new SortedIntList(5);
//       list.add(5);
//       list.add(-1);
//       list.add(17);
//       list.add(2);
//       System.out.println("    " + list.toString());
   
//       SortedIntList list2 = new SortedIntList(true);
//       list2.add(6);
//       list2.add(3);
//       list2.add(6);
//       list2.add(42);
//       list2.add(8);
//       System.out.println("    " + list2.toString());
//       System.out.println();
//    }

// // Briefly tests the min/max methods.
//    public static void checkMinMax() {
//       System.out.println("Beginning min/max test (should be -6 and 17)");
//       SortedIntList list = new SortedIntList();
//       list.add(5);
//       list.add(-6);
//       list.add(17);
//       list.add(2);
//       System.out.println("    min = " + list.min());
//       System.out.println("    max = " + list.max());
//       System.out.println();
//    }

// }
