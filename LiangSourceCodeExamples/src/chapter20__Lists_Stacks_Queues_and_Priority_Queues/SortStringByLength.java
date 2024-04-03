package LiangSourceCodeExamples.src.chapter20__Lists_Stacks_Queues_and_Priority_Queues;


public class SortStringByLength {
  public static void main(String[] args) {
    String[] cities = {"Atlanta", "Savannah", "New York", "Dallas"};
    java.util.Arrays.sort(cities, new MyComparator());

    for (String s : cities) {
      System.out.print(s + " ");
    }
  }

  public static class MyComparator implements
      java.util.Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
      return s1.length() - s2.length();
    }
  }
}