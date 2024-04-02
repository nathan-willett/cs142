package Lab4__1_29;

public class ParameterMysteryExam2 {
    public static void main(String[] args) {
    String x = "happy";
    String y = "pumpkin";
    String z = "orange";
    String pumpkin = "sleepy";
    String orange = "vampire";
    orange(y, x, z);
    x = orange(x, z, y);
    orange(pumpkin, z, "y");
    z = "green";
    orange("x", "pumpkin", z);
    orange(x, z, orange);
    }
    public static String orange(String z, String y, String x) {
    System.out.println(y + " and " + z + " were " + x);
    return x + y + z;
    }
   }
   