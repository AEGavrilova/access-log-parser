import java.util.Arrays;

public class RemoveNegativity {
    public static int[] deleteNegative(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num >= 0) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int num : arr) {
            if (num >= 0) {
                result[index++] = num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 4, -2, 2, -5};
        int[] result = deleteNegative(arr);
        System.out.println(Arrays.toString(result));
    }
}

