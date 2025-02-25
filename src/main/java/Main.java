import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Получение последовательности двух чисел из консоли
        System.out.println("Введите первое число");
        int firstNumber = new Scanner(System.in).nextInt();
        System.out.println("Введите второе число");
        int secondNumber = new Scanner(System.in).nextInt();
        //Сумма числел
        int x = 5;
        int y = 10;
        System.out.println("Сумма :"+(x+y));
        //Разность чисел
        System.out.println("Разность :"+ (x-y));
        //Произведение числе
        System.out.println("Произведение:"+ (x*y));
        //Частное чисел
        System.out.println("Частное :"+ ((double)x/y));
    }
}
