import java.util.Arrays;

public class AddingAnArrayToAnArray {
    public static int[] add(int[] arr, int[] ins, int pos) {
        if (pos < 0 || pos > arr.length) {
            throw new IllegalArgumentException("Некорректная позиция: " + pos);
        }
        int[] result = new int[arr.length + ins.length];
        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }
        for (int i = 0; i < ins.length; i++) {
            result[pos + i] = ins[i];
        }
        for (int i = pos; i < arr.length; i++) {
            result[ins.length + i] = arr[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] ins = {7, 8, 9};
        int pos = 3;
        int[] result = add(arr, ins, pos);
        System.out.println(Arrays.toString(result));
    }
}

