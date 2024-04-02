package SmallProblems4B__1_29;

/*
 * Write a method named stutter that accepts a string parameter returns a new string replacing each of its characters with 
 * two consecutive copies of that character. For example, a call of stutter("hello") would return "hheelllloo".
 */

public class stutter {
    static final String str1 = "hello";
    public static void main(String[] args) {
        System.out.println(stutterMethod(str1));    // pass str1 to stutterMethod, then output the result
    }

    public static String stutterMethod(String str1) {
        String str2 = "";   // initialize str2
        for (int i = 0; i < str1.length(); i++) {
            str2 += str1.charAt(i);     // add the character at index i to str2
            str2 += str1.charAt(i);     // add the character at index i to str2 again
        }
        return str2;    // return str2
    }
}