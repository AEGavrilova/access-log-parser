package CollectionFramework;

import java.util.Arrays;

public class BubbleSortExample {

    public static void bubbleSort(int[] intArray) {
        for (int i = 0; i < intArray.length - 1; i++) {
            for (int j = 0; j < intArray.length - i - 1; j++) {
                if (intArray[j] > intArray[j + 1]) {
                    int temp = intArray[j];
                    intArray[j] = intArray[j + 1];
                    intArray[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(numbers));

        bubbleSort(numbers);

        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(numbers));
    }
}
