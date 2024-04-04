package chapter7;

import java.util.Arrays;

public class RandomShuffling {
  public static void main(String[] args) {
    double[] myList = {1.9, 2.9, 3.4, 3.5};
    RandomShuffle(myList);
    System.out.println(Arrays.toString(myList));
  }

  public static void RandomShuffle(double[] myList) {
    for (int i = 0; i < myList.length; i++) {
      // Generate an index j randomly
      int j = (int)(Math.random() * myList.length);

      // Swap myList[i] with myList[j]
      double temp = myList[i];
      myList[i] = myList[j];
      myList[j] = temp;
    }
  }
}
