// Allison Obourn
// CS 142, Spring 2024
// Lecture 9

// A class to represent employees in general (20-page manual).
public class Employee {
    private int years;
    
    // creates a new employee with the passed in number of years at the company
    public Employee(int years) {
        this.years = years;
    }

    // returns the number of hours in the employees work week
    public int getHours() {
        return 40; // works 40 hours / week
    }

    // returns the salary the employee earns
    public double getSalary() {
        return 40000.0; // $40,000.00 / year
    }

    // returns the number of vacation days an employee has
    public int getVacationDays() {
        return 10; // 2 weeks' paid vacation
    }

    // returns the color of the vacation form this employee must submit
    // to take a vacation
    public String getVacationForm() {
        return "yellow"; // use the yellow form
    }
}
