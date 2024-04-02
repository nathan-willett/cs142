package week3;

public class ReuseTestMax {
  /** Main method */
  public static void main(String[] args) {
    int i = 5;
    int j = 2;
    int k = max(i, j); // Invoke max method
    System.out.println("The maximum between " + i +
      " and " + j + " is " + k);
    
    i++;
    j++;
    int l = Test(i, j); // Invoke Test method
    System.out.println("The new maximum between " + i +
      " and " + j + " is " + l);
  }
 
  /** Return the max between two numbers */
  public static int max(int num1, int num2) {
    int result1;

    if (num1 > num2)
      result1 = num1;
    else
      result1 = num2;

    return result1; // Return result1
  }

  /** One of the benefits of methods is for reuse. The max method can be invoked from any class besides TestMax. 
      If you create a new class Test, you can invoke the max method using ClassName.methodName (e.g., TestMax.max). */
      
  /** Return the new max between two numbers */
   public static int Test(int num1, int num2) {
    int result2;    
    result2 = ReuseTestMax.max(num1, num2); // Invoke Testmax method 
    return result2; // Return result2
  }
}