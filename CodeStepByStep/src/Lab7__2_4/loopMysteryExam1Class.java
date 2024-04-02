/*
 * For each call of the method below, write the output that is printed and the value that is returned:
 */

package Lab7__2_4;

public class loopMysteryExam1Class {
    public static void main(String[] args) {
        loopMysteryExam1(5, 0);
        loopMysteryExam1(3, 2);
        loopMysteryExam1(16, 5);
        loopMysteryExam1(80, 9);
        loopMysteryExam1(1600, 40);
    }

    public static int loopMysteryExam1(int i, int j) {
        while (i != 0 && j != 0) {
            i = i / j;
            j = (j - 1) / 2;
            System.out.print(i + " " + j + " ");
        }
        System.out.println(i);
        return i + j;
    }
}