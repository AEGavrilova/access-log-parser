public class DoubleDigit {
    public static boolean is2Digits(int x) {
        return (x > 9 && x < 100) || (x < -9 && x > -100);
    }
    public static void main(String[] args) {
        int x = 90;
        System.out.println(is2Digits(x));
    }
}

