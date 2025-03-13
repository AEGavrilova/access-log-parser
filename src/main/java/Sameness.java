public class Sameness {
    public static void main(String[] args) {
        System.out.println(equalNum(1111));
    }

    public static boolean equalNum(int x) {
        if (x < 0) return false;

        int y = x % 10;
        x /= 10;
        while (x > 0) {
            if (y != x % 10) return false;
            x /= 10;
        }
        return true;
    }
}
