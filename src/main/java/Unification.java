import java.util.Arrays;

public class Unification {
    public static int[] concat(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            result[arr1.length + i] = arr2[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {7, 8, 9};
        int[] result = concat(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }
}

