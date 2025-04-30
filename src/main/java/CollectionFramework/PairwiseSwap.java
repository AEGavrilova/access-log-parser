package CollectionFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PairwiseSwap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите чётное число N: ");
        int N = scanner.nextInt();

        if (N % 2 != 0) {
            System.out.println("Ошибка: N должно быть чётным!");
            return;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        System.out.println("Исходный список: " + list);

        for (int i = 0; i < N; i += 2) {
            if (i + 1 < N) {
                int temp = list.get(i);
                list.set(i, list.get(i + 1));
                list.set(i + 1, temp);
            }
        }
        System.out.println("Список после обмена: " + list);
    }
}