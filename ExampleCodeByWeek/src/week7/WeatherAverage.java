// CS& 141, Fall 2023
// This program asks the user how many temperatures they want to input and then
// prompts them and reads that number of temperatures. It then outputs the 
// average, # days above average, all of the temperatures in a list and then the
// two hottest and two coldest days.
// NOTE: Too much code is in main! We will fix this next time.
// Allison Obourn

package week7;

import java.util.*;

public class WeatherAverage {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("How many days' temperatures? ");
        int days = console.nextInt();
        int sum = 0;
        int[] temps = new int[days];
        
        // read each day's temperature
        for (int i = 0; i < days; i++) {    
            System.out.print("Day " + (i + 1) + "'s high temp: ");
            int temp = console.nextInt(); 
            sum += temp;
            // add the temperature to the array
            temps[i] = temp;
        }
        
        double average = (double) sum / days;
        
        int above = 0;
        // count days above average
        for(int i = 0; i < temps.length; i++) {
           if(temps[i] > average) {
               above++;
           }
        }
        
        // report results
        System.out.printf("Average temp = %.1f\n", average);
        System.out.println( above + " days above average");
        String tempString = Arrays.toString(temps);
        System.out.println();
        System.out.println("Temperatures: " + tempString);
        
        // sort the array so that the smallest value is at the beginning and the largest
        // is at the end
        Arrays.sort(temps);
        System.out.println("Two coldest days: " + temps[0] + " " + temps[1]);
        int last = temps.length - 1;
        System.out.println("Two hottest days: " + temps[last] + " " + temps[last - 1]);
    }
}