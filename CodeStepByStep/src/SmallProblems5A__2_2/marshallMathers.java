package SmallProblems5A__2_2;

public class marshallMathers {
    public static void main(String[] args) {
        // index 0123456789012345678901234
        String s1 = "Snoop Dogg";
        String s2 = "Marshall 'Eminem' Mathers";
        String s3 = s2.substring(18);
        String book = "Art & Science of Java";

        System.out.println(s1.length());
        System.out.println(s2.length());
        System.out.println(s1.indexOf("o"));
        System.out.println(s2.indexOf("x"));
        System.out.println(s1.substring(6, 9));
        System.out.println(s2.substring(21));
        System.out.println(book.substring(6, 12));
        System.out.println(s3.toLowerCase());
    }
}