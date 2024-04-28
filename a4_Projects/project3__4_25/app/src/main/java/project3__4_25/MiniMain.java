// CS 142 Critters
// Authors: Marty Stepp, Stuart Reges and Allison Obourn
//
// A small testing program with a main method to test your animals.
// Most of your testing should be done in CritterMain.java, but this smaller
// file can help you to test simpler behavior or see a bit about how
// the CritterMain uses your animals.
// This program does NOT test all aspects of your animals' behavior; you should
// perform your own testing to make sure your animals work properly.
//
// If you have not finished all of the animals yet, you can comment out the
// code for the animals you have not written.
// In jGRASP, select a group of lines and press Ctrl-W to comment them out,
// or put /* ... */ around them.
//
// YOU DON'T NEED TO EDIT THIS FILE FOR YOUR ASSIGNMENT (but you may if you like).
//

public class MiniMain {
	public static void main(String[] args) {
		test1();
		// test2();
	}
	
	// Small, very simple test (Aardvark only).
	public static void test1() {
		System.out.println("Test 1 (Aardvark):");
		
		// create an Aardvark and move it 10 times
		Aardvark animal = new Aardvark(true);
		System.out.print(animal.toString() + " ");
		
		for (int i = 1; i <= 10; i++) {
			Critter.Direction move = animal.getMove();
			System.out.print(move + " " + animal.toString() + " ");
		}
		System.out.println();
		System.out.println();
	}
	

/*
	// A bigger test (move several animals).  You can un-comment this
	// test (delete the /* and * /) once you implement the rest of the animals.
	// You'll also need to un-comment the call to test2 up in main.
	
	public static void test2() {
		System.out.println("Test 2 (all animals):");

		// Aardvark
		Aardvark Aardvark1 = new Aardvark(true);
		Aardvark Aardvark2 = new Aardvark(false);
		moves(Aardvark1, 5);
		moves(Aardvark2, 10);
		System.out.println();
		
		// Cat
		Cat cat1 = new Cat();
		Cat cat2 = new Cat();
		moves(cat1, 17);
		moves(cat2, 14);
		System.out.println();
		
		// Koala (movement is random so may not match perfectly)
		Koala koala1 = new Koala(4);
		Koala koala2 = new Koala(0);
		moves(koala1, 8);
		moves(koala2, 12);
		eating(koala1, 6);
		System.out.println();

		// tiger
		Tiger tiger1 = new Tiger();
		Tiger tiger2 = new Tiger();
		moves(tiger1, 13);
		moves(tiger2, 8);
		System.out.println();
	}
*/
	
	// Moves the given animal the given number of times and prints which
	// way the animal wanted to move each time.
	public static void moves(Critter critter, int times) {
		System.out.print(critter.getClass().getName() + " moving " + times + " times: ");
		System.out.print(critter.toString() + " ");
		for (int i = 1; i <= times; i++) {
			Critter.Direction move = critter.getMove();
			System.out.print(move + " ");
		}
		System.out.println(critter.toString());
	}
	
	// Asks the given animal if he wants to eat the given number of times
	// and prints whether the animal wanted to eat each time.
	public static void eating(Critter critter, int times) {
		System.out.print(critter.getClass().getName() + " eating " + times + " times: ");
		System.out.print(critter.toString() + " ");
		for (int i = 1; i <= times; i++) {
			boolean ate = critter.eat();
			System.out.print(ate + " " + critter.toString() + " ");
		}
		System.out.println();
	}
}
