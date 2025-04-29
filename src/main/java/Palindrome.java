public class Palindrome {
    public static boolean palindrom(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (Math.abs(arr[left]) != Math.abs(arr[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,-2,-7,4,-7,-2,1};
        System.out.println(palindrom(arr));
    }
}


