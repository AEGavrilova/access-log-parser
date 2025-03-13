public class LengthOfNumber {
    public static void main(String[] args) {
        System.out.println(numLen(12567));
    }

    public static int numLen(long x) {
        int count = 0, num = 12567;
        while (num != 0) {
            num /= 10;
            ++count;
        }
        return count;
    }
}
