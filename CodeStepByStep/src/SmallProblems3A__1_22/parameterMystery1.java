package SmallProblems3A__1_22;

/*
 * The following console program uses parameters and produces two lines of output. What are they?
 */

public class parameterMystery1 {
    public static void main(String[] args) {
        int x = 9;
        int y = 2;
        int z = 5;

        mystery(z, y, x);
        mystery(y, x, z);
    }

    public static void mystery(int x, int z, int y) {
        //System.out.println(x);
        //System.out.println(y);
        //System.out.println(z);
        System.out.println(z + ", " + (y - x));
    }
}