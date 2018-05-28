import java.util.Arrays;
import java.util.Random;

public class Kostya {

    public static void main(String[] args) {

        //Сдвиг массив влево на 1
        //taskLast();

        //Variant 4
        //task1();
        //task2();
        //task3();
    }



    private static void taskLast() {

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

        System.out.println("Массив со здвинутыми елементами на 1 влево:");

        //Идем по масиву
        for (int i = 0; i < mas.length; i++) {
            int firstElement = 0;

            //Записываем первый елемент в переменную  int firstElement
            //Это происходит один раз
            if (i == 0) {
                firstElement = mas[i];
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

    private static void task1() {
        //List<Double> list = Utils.inputDoubleArray();

        Random random = new Random();

        double[][] generalArr = new double[4][4];

        double count = 0;

        for (int i = 0; i < generalArr.length; i++) {
            for (int j = 0; j < generalArr[i].length; j++) {
                generalArr[i][j] = random.nextInt(9) - 4;
                if (generalArr[i][j] < 0) {
                    count = count + 1;
                }
            }
        }


        System.out.println("Матрица:");
        for (int i = 0; i < generalArr.length; i++) {
            int countPositiveInSpovpez = 0;
            for (int j = 0; j < generalArr[i].length; j++) {
                System.out.print(generalArr[i][j] + "   ");
                if (generalArr[j][i] < 0) {
                    countPositiveInSpovpez = countPositiveInSpovpez + 1;
                }
            }
            System.out.println("\n");
        }

        System.out.println("Отрицательных елементов  = " + count);

        for (int i = 0; i < generalArr.length; i++) {
            int countPositiveInSpovpez = 0;
            for (int j = 0; j < generalArr[i].length; j++) {
                if (generalArr[j][i] < 0) {
                    countPositiveInSpovpez = countPositiveInSpovpez + 1;
                }
            }
            System.out.println("в столбце" + i + 1 + " = " + countPositiveInSpovpez);
        }
    }

    private static void task2() {
        int[][] generalArr = new int[4][4];

        int count1 = generalArr.length-1;

        for (int i = 0; i < generalArr.length; i++) {
            for (int j = 0; j < generalArr[i].length; j++) {

                System.out.println("");
                if (j == count1 ) {
                    generalArr[i][j] = 1;
                    count1 = count1 -1;
                }else {
                    generalArr[i][j] = 0;
                }
            }
        }

        System.out.println("Матрица:");
        for (int i = 0; i < generalArr.length; i++) {
            for (int j = 0; j < generalArr[i].length; j++) {
                System.out.print(generalArr[i][j] + "   ");
            }
            System.out.println("\n");
        }
    }

    private static void task3() {

        int[] arr = new int[]{3,5,1,4,2};

        System.out.println("До");
        Arrays.stream(arr).forEach((System.out::println));

        int temp, j;
        for(int i = 0; i < arr.length - 1; i++){
            if (arr[i] > arr[i + 1]) {
                temp = arr[i + 1];
                arr[i + 1] = arr[i];
                j = i;
                while (j > 0 && temp < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = temp;
            }
        }

        System.out.println("После");
        Arrays.stream(arr).forEach((System.out::println));
    }
}
