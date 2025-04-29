public class WeFindTheFirstValue {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,2,2,5};
        System.out.println(findFirst(arr,2));
    }
    public static int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) { return i; }
        }
        return -1;
    }
}
