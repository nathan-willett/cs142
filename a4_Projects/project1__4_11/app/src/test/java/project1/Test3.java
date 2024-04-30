// package a4_Projects.project1.app.src.test.java.project1;

// // CS 142, Project 1 (SortedIntList)
// //
// // This program tests stage 3 of the SortedIntList project.  The methods
// // called in main each perform a series of checks and throw an exception if
// // anything test fails.  The program uses the list size as its primary
// // measure of correctness.  It doesn't verify, for example, that the list
// // stores the correct numbers.  It just verifies that it has the expected
// // number of values.
// //
// // adapted from 1/6/07 version by Stuart Reges


// import java.util.*;

// public class Test3 {
// 	// number of times to repeat each test at each size (try 2--10)
// 	public static final int REPETITIONS = 2;
	
// 	// maximum list size to use in a test (start small, then increase it)
// 	public static final int MAX_TEST_SIZE = 50;
	
// 	// set to false if you don't want to see printlns for every passed test run
// 	public static final boolean VERBOSE = true;
	
// 	public static void main(String[] args) {
// 		// the program performs 10 tests each for test sizes from 0 to 99
// 		for (int testSize = 0; testSize <= MAX_TEST_SIZE; testSize++) {
// 			for (int i = 0; i < REPETITIONS; i++) {
// 				SortedIntList list1 = new SortedIntList(false, testSize);
// 				testTrue(list1, testSize);
// 				SortedIntList list2 = new SortedIntList(false, 2 * testSize);
// 				testFalse(list2, testSize);
// 			}
// 		}
// 		System.out.println("\nAll tests passed!");
// 	}
	
// 	// This method tests the case where unique is set to true most of the time
// 	public static void testTrue(SortedIntList list, int testSize) {
// 		if (VERBOSE) {
// 			System.out.println("Beginning testTrue  basic getUnique/setUnique test of size " + testSize);
// 		}
// 		setAndTestUnique(list, true, testSize);
// 		boolean[] chosen = new boolean[testSize];
// 		int count = 0;
// 		Random r = new Random();
		
// 		// this loop generates random numbers until all test numbers have
// 		// been added to the list
// 		while (count < testSize) {
// 			int next = r.nextInt(testSize);
// 			list.add(next);
// 			if (!chosen[next]) {
// 				count++;
// 				chosen[next] = true;
// 			}
// 			checkSize("while adding initial numbers to list", list, count, testSize);
// 		}
		
// 		// make sure we can turn unique off and on again
// 		setAndTestUnique(list, false, testSize);
// 		setAndTestUnique(list, true, testSize);
// 		checkSize("after setting unique to false and then back to true", list, testSize, testSize);
		
// 		// batter the list with duplicates to make sure it works
// 		for (int i = 0; i < testSize * 10; i++) {
// 			int next = r.nextInt(testSize);
// 			list.add(next);
// 		}
// 		checkSize("after attempting to add many duplicates", list, testSize, testSize);
		
// 		if (VERBOSE) {
// 			System.out.println("    Passed!");
// 		}
// 	}
	
// 	// This method tests the case where unique is set to false most of the time
// 	public static void testFalse(SortedIntList list, int testSize) {
// 		if (VERBOSE) {
// 			System.out.println("Beginning testFalse basic getUnique/setUnique test of size " + testSize);
// 		}
// 		setAndTestUnique(list, false, testSize);
// 		boolean[] chosen = new boolean[testSize];
// 		int count = 0;
// 		Random r = new Random();
		
// 		// this loop will add each test number exactly once to the list
// 		while (count < testSize) {
// 			int next = r.nextInt(testSize);
// 			if (!chosen[next]) {
// 				list.add(next);
// 				count++;
// 				chosen[next] = true;
// 			}
// 			checkSize("after adding many distinct values to the list", list, count, testSize);
// 		}
		
// 		// then we add testSize duplicates to the list
// 		for (int i = 1; i <= testSize; i++) {
// 			int next = r.nextInt(testSize);
// 			list.add(next);
// 			checkSize("after adding a duplicate of value " + next, list, testSize + i, testSize);
// 		}
		
// 		// and make sure that they are removed when we set unique back to true
// 		setAndTestUnique(list, true, testSize);
// 		checkSize("after setting unique to true", list, testSize, testSize);
		
// 		// then add testSize more duplicates
// 		setAndTestUnique(list, false, testSize);
// 		for (int i = 1; i <= testSize; i++) {
// 			int next = r.nextInt(testSize);
// 			list.add(next);
// 			checkSize("after setting unique back to false and then adding a duplicate of value " + next, list, testSize + i, testSize);
// 		}
		
// 		// and again make sure they are removed when unique is set to false
// 		setAndTestUnique(list, true, testSize);
// 		checkSize("after setting unique back to true (duplicates should be removed)", list, testSize, testSize);
		
// 		if (VERBOSE) {
// 			System.out.println("    Passed!");
// 		}
// 	}
	
// 	// sets the unique property to the given value and makes sure that
// 	// getUnique returns the same value
// 	public static void setAndTestUnique(SortedIntList list, boolean unique,
// 	int testSize) {
// 		list.setUnique(unique);
// 		if (list.getUnique() != unique) {
// 			throw new RuntimeException(
// 			"\n\ngetUnique = " + list.getUnique() +
// 			" after setting it to " + unique +
// 			" with test size = " + testSize + "\n");
// 		}
// 	}
	
// 	// Checks to see if the list has the appropriate size.
// 	public static void checkSize(String message, SortedIntList list, int size, int testSize) {
// 		if (list.size() != size) {
// 			throw new RuntimeException("\n\n" + message +
// 			",\nsize = " + list.size() + " when it should be " + size +
// 			"\ntest size = " + testSize +
// 			"\nyour list = " + list + "\n\n" +
// 			"(if your size does match the number of elements in your list, \n" +
// 				"this error probably means you have not properly added the \n" +
// 			"number of elements requested by the test case.)\n");
// 		}
// 	}
// }
