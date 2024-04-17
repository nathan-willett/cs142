package a4_Projects.project1.app.src.main.java.project1;

import java.util.NoSuchElementException;

public class SortedIntListTest {
    public static void main(String[] args) {
        testAddAndUnique();
        testMinAndMax();
        testEmptyListExceptions();
    }

    /**
     * Tests if duplicate values are successfully prevented from being added, in addition
     * to checking the proper size of the list.
     * 
     * Pass Criteria:
     * Any duplicate values are rejected.
     * The number of elements added to the list should only equal the number of unique elements.
     */
    private static void testAddAndUnique() {
        System.out.println("Testing add method and unique property...");

        SortedIntList list = new SortedIntList(true, 10);
        list.add(6);
        list.add(2);
        list.add(8);
        list.add(2); // '2' should be rejected

        // Check the results
        if (list.size() == 3 && list.indexOf(2) == 0 && list.indexOf(6) == 1 && list.indexOf(8) == 2) {
            System.out.println("Test passed: add and unique properties are correct.\n");
        } else {
            System.out.println("Test failed: expected size 3 with elements in positions [2, 6, 8].\n");
        }
    }

    /**
     * Calls the min and max methods and verifies the results with the expected output.
     * 
     * Pass criteria:
     * The actual min and max values should match the expected min and max.
     */
    private static void testMinAndMax() {
        System.out.println("Testing min and max methods...");

        SortedIntList list = new SortedIntList();
        list.add(3);
        list.add(1);
        list.add(6);

        // Expected: min=1, max=6
        System.out.println("Expected min: 1, Actual min: " + list.min());
        System.out.println("Expected max: 6, Actual max: " + list.max());
        if (list.min() == 1 && list.max() == 6) {
            System.out.println("Test passed: Min and Max values are correct." + '\n');
        } else {
            System.out.println("Test failed: Min and Max values are not as expected." + '\n');
        }
    }

    /**
     * tests the min() and max() methods when they are called on an empty list.
     * 
     * Pass Criteria:
     * NoSuchElementException must be thrown when both the min() and max() methods are called.
     */
    private static void testEmptyListExceptions() {
        System.out.println("Testing behavior on empty list...");

        SortedIntList list = new SortedIntList();

        // Test for NoSuchElementException on min() and max() methods
        try {
            list.min();
            System.out.println("Test failed: Expected NoSuchElementException for min() on empty list.");
        } catch (NoSuchElementException e) {
            System.out.println("Test passed: NoSuchElementException thrown as expected for min() on empty list.");
        }

        try {
            list.max();
            System.out.println("Test failed: Expected NoSuchElementException for max() on empty list.");
        } catch (NoSuchElementException e) {
            System.out.println("Test passed: NoSuchElementException thrown as expected for max() on empty list.");
        }
    }
}
