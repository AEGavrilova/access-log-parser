import java.util.Scanner;

public class SafeDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число: ");
        int numerator = scanner.nextInt();

        System.out.println("Введите число: ");
        int denominator = scanner.nextInt();

        if (denominator != 0) {
            int result = safeDiv(numerator, denominator);
            System.out.println("Результат: " + result);
        } if (numerator == 0 || denominator == 0) {
            System.out.println("Результат: 0");
        }
    }

    private static int safeDiv(int numerator, int denominator) {
        return numerator / denominator;
    }
}