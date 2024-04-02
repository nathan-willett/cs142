package Quiz5__2_2;

public class q5Problem6 {
    public static void main(String[] args) {
        System.out.println(coordinates(30, 60, 90));
    }

    public static boolean coordinates(int angle1, int angle2, int angle3) {
        int sum = angle1 + angle2 + angle3;
        
        // initialize complementary boolean and supplementary boolean as false
        boolean complementary = false;
        boolean supplementary = false;

        if (sum == 90) {
            complementary = true;
        }
        
        if (sum == 180) {
            supplementary = true;
        }

        return complementary || supplementary;
    }
}
