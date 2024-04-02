package Lab1__1_16;

// What is the output of the following code?
public class methodTracing1 {
    public static void main(String[] args) {
        message1();
        message2();
        System.out.print("4 ");
    }

    public static void message1() {
        System.out.print("7 ");
    }

    public static void message2() {
        System.out.print("5 ");
        message1();
        System.out.print("6 ");
    }
}
