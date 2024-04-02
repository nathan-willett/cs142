/*
 * Write a method named crazyCaps that accepts a string as a parameter and returns a new string with its capitalization 
 * altered such that the characters at even indexes are all in lowercase and odd indexes are all in uppercase. For example, 
 * if a variable s stores "Hey!! THERE!", the call of crazyCaps(s); should return "hEy!! tHeRe!".
 */

package SmallProblems5B__2_5;

import java.util.Scanner;

public class crazyCapsClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a string.");           // prompt the user
        String a = input.nextLine();                              // store the input as string 'a'
        System.out.println(crazyCaps(a));
        input.close();
    }

    public static String crazyCaps(String a) {
        String output = "";                                        // to store the modified string
        int length = a.length();
        
        for (int i = 0; i < length; i++) {
            char currentChar = a.charAt(i);
            if (i % 2 == 0) {                                      // even char index
                output += Character.toLowerCase(currentChar);
            } else {                                               // odd index
                output += Character.toUpperCase(currentChar);
            }
        }
        return output;
    }
}