package Lab2__1_22;

public class methodTracing3 {
    public static void main(String[] args) {
        methodA();
        methodB();
        methodC();
        methodB();
    }

    public static void methodB() {
        methodA();
        System.out.print("B ");
    }

    public static void methodC() {
        methodB();
        System.out.print("C ");
        methodA();
    }

    public static void methodA() {
        System.out.print("A ");
    }
}