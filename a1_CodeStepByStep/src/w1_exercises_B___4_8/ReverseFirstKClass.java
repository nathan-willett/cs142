/* Write a method named reverseFirstK that accepts an array of integers and an index k as parameters and modifies the first k
elements of the array to be in reverse order. For example, if the array a stores {10, -2, 33, 55, 9, 17, 6}, the call of
reverseFirstK(a, 5) should reverse the first 5 elements, modifying it to store {9, 55, 33, -2, 10, 17, 6}. If the value
of k is 1, 0, negative, or greater than the length of the array, do not modify the array. */
public class ReverseFirstKClass {
   public static void main(String[] args) {
      int[] a = { 10, -2, 33, 55, 9, 17, 6 };
      reverseFirstK(a, 4);

      for (int value : a) {
         System.out.print(value + " ");
      }
   }

   public int[] reverseFirstK(int[] list, int k) {
      if (k > 0 && k <= list.length) {
         int temp;
         if (k > 0 && k <= list.length) {
            for (int i = 0; i < k / 2; i++) {
               temp = list[i];
               list[i] = list[k - i - 1];
               list[k - i - 1] = temp;
            }
         }
      }
   }
}