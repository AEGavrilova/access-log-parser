public class GuessingGame {
    public static void main(String[] args) {
        int x;
        int randomNum = 3;
        int count = 1;
        do {
            System.out.println("Что за число я загадал (От 0 до 9)?");
            java.util.Scanner sc = new java.util.Scanner(System.in);
            x = sc.nextInt();
            if (x == randomNum) {
                System.out.println("Да, это " + randomNum + " Ты угадал с попытки № "+ count);
            } else {
                System.out.println("Нет, попробуй снова.");
            }
            count++;
        }
            while (randomNum != x);
    }
}