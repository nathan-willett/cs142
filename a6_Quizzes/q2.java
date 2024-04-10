public class q2 {
    public static void main(String[] args) {
        int[] a1 = {8};
        mystery(a1);
        
        int[] a2 = {6,3};
        mystery(a2);
    }

    public static void mystery(int[] list) {
        for (int i = 1; i < list.length; i++) {
            list[i] = list[i] + list[i - 1];
            
        }
        System.out.println(java.util.Arrays.toString(list));
    }
}
