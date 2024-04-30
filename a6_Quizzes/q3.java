import java.util.*;

public class q3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(List.of(34, 2, 5));

        mystery4(list);
    }

    public static void mystery4(ArrayList<Integer> list) {
        int size = list.size();
        for (int i = 1; i <= size; i++) {
            list.add(i, i * 10);
        }
        for (int i = 1; i < list.size(); i++) {
            list.remove(i);
        }
    }
}
