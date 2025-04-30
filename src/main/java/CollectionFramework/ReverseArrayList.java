package CollectionFramework;

import java.util.ArrayList;

public class ReverseArrayList {
    public static void reverse(ArrayList<Integer> list) {
        int n = list.size() - 1;
        for (int i = 0; i < list.size() / 2; i++) {
            int temp = list.get(i);
            list.set(i, list.get(n - i));
            list.set(n - i, temp);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        System.out.println("Исходный список: " + numbers);
        reverse(numbers);
        System.out.println("Перевёрнутый список: " + numbers);
    }
}