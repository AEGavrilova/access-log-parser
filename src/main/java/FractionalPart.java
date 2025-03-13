public class FractionalPart {
    public static double fraction(double x) {
        return x - (int) x;
    }

    public static void main(String[] args) {
        double number = 10.101;
        double result = fraction(number);

        System.out.printf("%.3f\n", result);
    }
}