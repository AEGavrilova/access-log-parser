import java.util.ArrayList;
import java.util.List;

public class AllOccurrences {
    public static int[] findAll(int[] arr, int x) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                indices.add(i);
            }
        }
        int[] result = new int[indices.size()];
        for (int i = 0; i < indices.size(); i++) {
            result[i] = indices.get(i);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 8, 2, 2, 9};
        int x = 2;
        int[] result = findAll(arr, x);
        System.out.println(java.util.Arrays.toString(result));
    }
}

