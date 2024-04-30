import java.util.*;

public class q3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(List.of(34, 2, 5));
        //list.addAll(List.of(12, 34, 65, 1, 4));
        //list.addAll(List.of(54, 23, 7, 2, 4, 2));
        System.out.print(Arrays.toString(mystery4(list).toArray()));
    }

    public static ArrayList<Integer> mystery4(ArrayList<Integer> list) {
        int size = list.size();
        for (int i = 1; i <= size; i++) {
            list.add(i, i * 10);
        }
        for (int i = 1; i < list.size(); i++) {
            list.remove(i);
        }
        return list;
    }
}
