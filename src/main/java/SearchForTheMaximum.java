public class SearchForTheMaximum {
    public static int maxAbs(int[] arr) {
        if (arr == null || arr.length == 0) {
        }
        int maxAbsValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(maxAbsValue)) {
                maxAbsValue = arr[i];
            }
        }
        return maxAbsValue;
    }
    public static void main(String[] args) {
        int[] arr = {1, -2, -7, 4, 2, 2, 5};
        int result = maxAbs(arr);
        System.out.println(result);
    }
}
