/*
 * Write a method mostFrequentDigit that takes a number as a parameter and returns the digit 
 * value that occurs most frequently in it.
 * 
 * For example, the number 669260267 contains: one 0, two 2s, four 6s, one 7, and one 9. 
 * mostFrequentDigit(669260267) returns 6.
 * mostFrequentDigit(57135203) returns 3.
 * 
 * If there is a tie, return the digit with the lower value.
 */

package Lab11__2_19;

public class mostFrequentDigitClass {

    /**
     * The main method for testing the mostFrequentDigit method.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        int x = 669260267;
        System.out.println(mostFrequentDigit(x));
    }

    /**
     * Finds the most frequent digit in a number. In case of a tie, returns the digit 
     * with the lower value.
     * @param x the number to analyze
     * @return the most frequent digit
     */
    public static int mostFrequentDigit(int x) {
        String number = String.valueOf(x);
        int[] digitCount = new int[10];

        // Iterate over each character in the 'number' string
        for (int i = 0; i < number.length(); i++) {
            // Convert the character at index 'i' to its numeric value
            int digit = Character.getNumericValue(number.charAt(i));
            // Increment the count of the current digit in the 'digitCount' array
            digitCount[digit]++;
        }

        int mostFrequent = 0;

        // Iterate over each element in the 'digitCount' array
        for (int i = 0; i < digitCount.length; i++) {
            /* Check if the count of the current digit is greater than the count of the 
            most frequent digit found so far */
            if (digitCount[i] > digitCount[mostFrequent]                
                // Or if the count is equal but the current digit is smaller    
                || (digitCount[i] == digitCount[mostFrequent] && i < mostFrequent)) {
                // If so, update 'mostFrequent' to the current digit
                mostFrequent = i;
            }
        }
        return mostFrequent;
    }
}