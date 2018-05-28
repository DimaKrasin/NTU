import java.util.Arrays;
import java.util.Random;

public class Zoryan {
    public static void main(String[] args) {
        //task1();
        //task2();
        //task3();
    }

    private static void task1() {
        int[] arr = new int[]{1, 10, -3, -5, 2, 6, 9};
        Arrays.stream(arr).forEach(value -> System.out.print(value+"; "));
        System.out.println();

        int min = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > min) {
                min = arr[i];
                index = i;
            }
            if (arr[i] <= 0) {
                System.out.println("Отрицательний елемент елемент под индексом " + i);
            }
        }
        System.out.println("Максимальный елемент = " + min + ", индекс = " + index);
    }

    private static void task2() {

        //int n
        //Это номер елента который мы хотим узнать (n-ый елемент)
        //Эго можно менять
        int n = 6;

        int x0 = 0;
        int x1 = 1;

        System.out.println("1 = " + x0 + "\n2 = " + x1);

        for (int i = 0; i < n - 2; i++) {
            int tmp = x1*(x0+1);
            System.out.println(i + 3 + " = " + tmp);

            x0 = x1;
            x1 = tmp;
        }


    }

    private static void task3(){
        Random random = new Random();

        //Задаем наш масив
        //Длину можно менять
        int[] mas = new int[5];


        System.out.println("Наш  массив:");

        //Идем по масиву
        for (int i = 0; i < mas.length; i++) {
            //Каждому елементу ставим рандомное значениэ
            mas[i] = random.nextInt(12) - 4;
            //Выводим этот елемент
            System.out.print(mas[i] + "; ");
        }

        System.out.println("\nМассив со здвинутыми елементами на 1 вправо:");

        int firstElement = 0;

        //Идем по масиву
        for (int i = 0; i < mas.length; i++) {

            //Записываем первый елемент в переменную  int firstElement
            //Это происходит один раз
            if (i == 0) {
                firstElement = mas[0];
            }

            //Это срабатывает только если это последный елемент в массиве
            //Это происходит один раз
            //Это завершает программу
            //Так как у последнего елемента нет следуешего то он
            //становится равен int firstElement
            //После этого програма завершается
            if(i==mas.length-1){
                mas[i] = firstElement;
                System.out.print(mas[i]+"; ");
                return;
            }

            //Каждый елемент становится равен следующиму
            //Это происходит каждый раз
            mas[i] = mas[i + 1];

            // просто выводим каждый елемент
            //Это происходит каждый раз
            System.out.print(mas[i]+"; ");

        }
    }
}
