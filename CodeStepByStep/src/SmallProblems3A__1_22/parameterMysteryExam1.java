/*
 * The following console program uses parameters and produces five lines of output. What are they?
 */

package SmallProblems3A__1_22;

public class parameterMysteryExam1 {
    public static void main(String[] args) {
        String x = "java";
        String y = "tyler";
        String z = "tv";
        String rugby = "hamburger";
        String java = "donnie";

        hamburger(x, y, z);
        hamburger(z, x, y);
        hamburger("rugby", z, java);
        y = hamburger(y, rugby, "x");
        hamburger(y, y, "java");
    }

    public static String hamburger(String y, String z, String x) {
        System.out.println(z + " and " + x + " like " + y);
        return z;
    }
}