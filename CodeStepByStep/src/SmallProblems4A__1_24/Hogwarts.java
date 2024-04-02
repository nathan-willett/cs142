package SmallProblems4A__1_24;

/*
* For the following console program, trace through its execution by hand to write the three lines of output that are produced when it runs:
*
* File: Hogwarts.java
* -------------------
* This program is just testing your understanding of parameter passing.
*/

import static java.lang.System.out; // Add the import statement for the println method

public class Hogwarts {
    public static void main(String[] args) {
        bludger(2001);
    }

    private static void bludger(int y) {
        int x = y / 1000;
        int z = (x + y);
        x = quaffle(z, y);
        out.println("bludger: x = " + x + ", y = " + y + ", z = " + z); // Use the println method from the imported class
    }

    private static int quaffle(int x, int y) {
        int z = snitch(x + y, y);
        y /= z;
        out.println("quaffle: x = " + x + ", y = " + y + ", z = " + z); // Use the println method from the imported class
        return z;
    }
    private static int snitch(int x, int y) {
        y = x / (x % 10);
        out.println("snitch: x = " + x + ", y = " + y); // Use the println method from the imported class
        return y;
    }
}
