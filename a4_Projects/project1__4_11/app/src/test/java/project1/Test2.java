// package a4_Projects.project1.app.src.test.java.project1;

// // CS 142, Project 1 (SortedIntList)
// //
// // This program tests stage 2 of the SortedIntList project.
// // You can change the constant values to conduct larger
// // tests to better verify your SortedIntList class.
// //
// // adapted from 9/29/06 version by Alex Loddengaard

// import java.util.*;

// public class Test2 {
// 	public static final int TEST_SIZE = 25;
	
// 	//the lower this is, the more duplicates there will be
// 	public static final int MAX_INT = 10;
	
// 	public static void main(String[] args) {
// 		SortedIntList list;
		
// 		//test the first constructor
// 		System.out.println("Testing SortedIntList(true, " + 10 + ")");
// 		list = new SortedIntList(true, 10);
// 		fill(list, 10);
// 		if (!test(list, true)) {
// 			System.out.println("    Failed!");
// 		} else {
// 			System.out.println("    Passed!");
// 		}
		
// 		System.out.println();
		
// 		//test the second constructor
// 		System.out.println("Testing SortedIntList(true, " + TEST_SIZE + ")");
// 		list = new SortedIntList(true, TEST_SIZE);
// 		fill(list, TEST_SIZE);
// 		if (!test(list, true)) {
// 			System.out.println("    Failed!");
// 		} else {
// 			System.out.println("    Passed!");
// 		}
		
// 		System.out.println();
		
// 		//test the third constructor
// 		System.out.println("Testing SortedIntList(false, " + 10 + ")");
// 		list = new SortedIntList(false, 10);
// 		fill(list, SortedIntList.DEFAULT_CAPACITY);
// 		if (!test(list, false)) {
// 			System.out.println("    Failed!");
// 		} else {
// 			System.out.println("    Passed!");
// 		}
		
// 		System.out.println();
		
// 		//test the forth constructor
// 		System.out.println("SortedIntList(false, " + TEST_SIZE + ")");
// 		list = new SortedIntList(false, TEST_SIZE);
// 		fill(list, TEST_SIZE);
// 		if (!test(list, false)) {
// 			System.out.println("    Failed!");
// 		}
// 		else {
// 			System.out.println("    Passed!");
// 		}
		
// 		System.out.println("\nAll tests passed!");
// 	}
	
// 	//pre:  l is a SortedIntList, size will not exceed l's capacity
// 	//post: l is filled with TEST_SIZE random values
// 	public static void fill(SortedIntList l, int size) {
// 		Random rand = new Random();
		
// 		//fill l with size elements
// 		for (int i = 0; i < size; i++) {
// 			l.add(rand.nextInt(MAX_INT));
// 		}
// 	}
	
// 	//pre: l is a filled SortedIntList, unique should be true if all values
// 	//     should be unique
// 	//post: tests is l is a valid SortedIntList and prints errors
// 	public static boolean test(SortedIntList l, boolean unique) {
// 		boolean ret = true;
// 		String error = "";
		
// 		//loop through the list checking for order and duplicates
// 		for (int i = 1; i < l.size(); i++) {
// 			//check for duplicates if the list is supposed to be unique
// 			if (unique && l.get(i - 1) == l.get(i)) {
// 				ret = false;
// 				error += "\n\tDuplicate value " + l.get(i) + " found at indexes "
// 				+ (i - 1) + " and " + i;
// 			}
// 			//check for order
// 			if (l.get(i - 1) > l.get(i)) {
// 				ret = false;
// 				error += "\n\tNot in sorted order at indexes "
// 				+ (i - 1) + " and " + i;
// 			}
// 		}
		
// 		//print the error and the list if an error exists
// 		if (!ret) {
// 			System.out.println(error);
// 			System.out.println();
// 			System.out.println("\t" + l);
// 			System.out.println();
// 		}
		
// 		return ret;
// 	}
// }
