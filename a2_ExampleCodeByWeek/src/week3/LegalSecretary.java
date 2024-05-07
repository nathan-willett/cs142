// Allison Obourn
// CS 142, Spring 2024
// Lecture 9

// Models legal secretaries, a subtype of secratary who earns more
public class LegalSecretary extends Secretary {

   // returns the salary the employee earns - 5000 more than the base
   public double getSalary() {
        return super.getSalary() + 5000.0;
   }
}