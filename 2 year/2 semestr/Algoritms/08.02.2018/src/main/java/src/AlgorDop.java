package src;

import java.util.Arrays;

public class AlgorDop {
    public static void main(String[] args) {
        int[] myArr = new int[]{3, 5, 1, 2, 8,1,7};

        shakerSort(myArr);
        //byDima(myArr);


        System.out.println("\nФинальный вариант");
        System.out.println(Arrays.toString(myArr));
    }

    private static void byDima(int array[]) {

        int buff;
        int left = 0;
        int right = array.length - 1;
        for(int d =0;d<array.length-1;d++) {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    buff = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buff;
                }
            }
        }

    }

    private static void shakerSort(int array[]) {
        int buff;
        int left = 0;
        int right = array.length - 1;
        int count = 1;
        do {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    buff = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buff;
                }
            }

            right--;

            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    buff = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = buff;
                }
            }

            left++;

            System.out.println("Проход номер "+count);
            count = count+1;
            System.out.println(Arrays.toString(array));

        } while (left < right);
    }
}
