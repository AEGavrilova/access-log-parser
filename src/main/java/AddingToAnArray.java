import java.util.Arrays;

public class AddingToAnArray {
    public static int[] add(int[] arr, int x, int pos) {
        if (pos < 0 || pos > arr.length) {
            throw new IllegalArgumentException("Некорректная позиция: " + pos);
        }
        int[] result = new int[arr.length + 1];
        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }
        result[pos] = x;
        for (int i = pos; i < arr.length; i++) {
            result[i + 1] = arr[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int x = 9;
        int pos = 3;
        int[] result = add(arr, x, pos);
        System.out.println(Arrays.toString(result));
    }
}
