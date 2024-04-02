/*
 * Write a method named showTwos that shows the factors of 2 in a given integer. For example, the following calls should produce the 
 * following console output:
 * 
 * showTwos(7);	    7 = 7
 * showTwos(18);	18 = 2 * 9
 * showTwos(68);	68 = 2 * 2 * 17
 * showTwos(120);	120 = 2 * 2 * 2 * 15
 * showTwos(-68);	-68 = 2 * 2 * -17
 * 
 * The idea is to express the number as a product of factors of 2 and an odd number. The number 120 has 3 factors of 2 multiplied by 
 * the odd number 15. For odd numbers (e.g. 7), there are no factors of 2, so you just show the number itself. Notice that your method 
 * might be passed a negative number.
 */

package Lab7__2_4;

public class showTwosClass {
    public static void main(String[] args) {
        showTwos(7);
        showTwos(18);
        showTwos(68);
        showTwos(120);
        showTwos(-68);
    }

    public static void showTwos(int n) {
        boolean isNegative = n < 0;
        System.out.print(n + " = ");
        n = Math.abs(n);
        
        while (n % 2 == 0) {
            System.out.print("2 * ");
            n /= 2;
        }

        // Print the remaining factor, adjusting for negatives correctly
        if (isNegative) {
            System.out.println("-" + n); // Ensure the minus sign is only with the last factor
        } else {
            System.out.println(n);
        }
    }
}