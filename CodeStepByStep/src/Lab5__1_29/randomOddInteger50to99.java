package Lab5__1_29;

import java.util.Random;

public class randomOddInteger50to99 {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = rand.nextInt(25) * 2 + 51;
        
        System.out.println("Random odd integer between 50 and 99: " + n);
    }
}
