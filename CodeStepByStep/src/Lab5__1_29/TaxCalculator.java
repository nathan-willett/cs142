package Lab5__1_29;

/*
 * Write a method named computeTax that accepts a salary as a parameter and that returns the amount of tax you would owe if you make that
 * salary. The tax is based on your tax bracket as found from the first two columns below. Once you know which row to use, start with the "flat
 * amount" and add the "plus %" of the amount over the amount listed in the final column. For example, if your income is $50,000, then you use 
 * the third row of the table and compute the tax as $4,000 plus 25% of the amount over $29,050, which comes to $9,237.50. The total tax on 
 * $27,500 is $3,767.50. For $6,000, the tax is $600. For $120,000, the tax is $28,227. Assume your method is passed a value ≥ 0.
 */

 public class TaxCalculator {

    public static double computeTax(double salary) {
        double[][] brackets = {
            {0, 7150, 0, 10},       // (over, but not over, flat amount, plus % of excess over)
            {7150, 29050, 715, 15},
            {29050, 70350, 4000, 25},
            {70350, Double.POSITIVE_INFINITY, 14325, 28}
        };

        for (double[] bracket : brackets) {
            if (salary > bracket[0] && salary <= bracket[1]) {
                return bracket[2] + (bracket[3] / 100.0) * (salary - bracket[0]);
            }
        }

        // If the salary is beyond the last bracket
        return brackets[brackets.length - 1][2] + 
               (brackets[brackets.length - 1][3] / 100.0) * (salary - brackets[brackets.length - 1][0]);
    }

    public static void main(String[] args) {
        // Test the method with example salaries
        double[] testSalaries = {50000, 27500, 6000};
        for (double salary : testSalaries) {
            System.out.println("The tax for a salary of " + salary + " is: " + computeTax(salary));
        }
    }
}
