// CS& 141, Winter 2024
// Thanks to Allison Obourn for parts of this program





package week9;

// Blueprint for a college student. College students have names and IDs 
// that cannot be changed and the number of units which can be increased

public class Student {
    private String name;
    private int id;
    private int units;
    
    // creates a student with the passed in name and ID. All students
    // start with 0 credits earned.
    public Student(String studentName, int studentId) {
        name = studentName;
        id = studentId;
    }
    
    // returns the student's name
    public String getName() {
        return name;
    }
    
    // returns the student's id
    public int getID() {
        return id;
    }
    
    // returns the number of credits the student has earned
    public int getUnits() {
        return units;
    }
    
    // adds the passed in number of units to the total units of the student
    public void incrementUnits(int newUnits) {
        units += newUnits;
    }
    
    // returns true if the student has 180 or more credits
    public boolean hasEnoughUnits() {
        return units >= 180;
    }
    
    // returns a string with the student's name and then their ID 
    // number in parentheses
    public String toString() {
        return name + " (#" + id + ")";
    }
}