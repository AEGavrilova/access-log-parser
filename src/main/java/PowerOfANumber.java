public class PowerOfANumber {
    public static void main(String[] args) {
        System.out.println(pow(2, 5));
    }

    public static int pow(int x, int y) {
        int result = 1;
        for (int i = 1; i <= y; i++) {
            result = result * x;
        }
        return result;
    }
}
