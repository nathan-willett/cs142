/*
 * For each call of the method below, write the output that is printed as it would appear on the console.
 * 
 * loopMysteryExam5(12, 4);	
 * loopMysteryExam5(14, 2);	
 * loopMysteryExam5(27, 3);
 */ 

package SmallProblems5A__2_2;

public class loopMysteryExam5Class {
  public static void main(String[] args) {
    loopMysteryExam5(12, 4);
    loopMysteryExam5(14, 2);
    loopMysteryExam5(27, 3);
  }

  public static void loopMysteryExam5(int x, int y) {
   int z = y;
    
   while (x % z == 0) {
     System.out.print("(" + x + " " + z + ") ");
     x = x - z;
     z++;
   }
   System.out.println("(" + x + " " + z + ") " + y);
  }
}