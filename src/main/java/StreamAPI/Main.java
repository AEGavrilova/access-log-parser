package StreamAPI;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        printList(numbers);
    }

    public static void printList(ArrayList<Integer> list) {
        list.forEach(number -> System.out.println(number));
    }
}