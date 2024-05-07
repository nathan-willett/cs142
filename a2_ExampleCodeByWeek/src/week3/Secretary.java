// Allison Obourn
// CS 142, Spring 2024
// Lecture 9

// Models secretaries, a worker type who know how to take dictation.

public class Secretary extends Employee {

	// takes dictation and prints out that dictation
	public void takeDictation(String text) {
		System.out.println("dictation " + text);
	}
}
