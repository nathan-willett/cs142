package week4;

public class variableScope {
    public static void main(String[] args) {
        performTest();
    }
    
    public static void performTest() {
        int count = 12;
        for (int i = 1; i <= 12; i++) {
            runSample();
            System.out.print(count);   
        }
    }
    
    public static void runSample() {
        System.out.print("sample");
    }
}