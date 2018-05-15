import java.util.Random;

public class Serega {
    public static void main(String[] args) {
        //task1();
        //task2();
        //task3();
    }

    private static void task1() {
        Random random = new Random();

        int[] generalArr = new int[8];

        int minElement = 0;
        int minElementIndex = 0;


        //Идем по масиву (это generalArr)
        for (int i = 0; i < generalArr.length; i++) {

            //Каждому елементу ставим рандомное значениэ
            generalArr[i] = random.nextInt(12) - 4;

            //Выводим этот елемент
            System.out.print(generalArr[i] + "; ");

            //Сначала minElement будет равен самому первому елементу
            if (i == 0) {
                minElement = generalArr[i];
                minElementIndex = i;
            }

            //Затем мы проверяем каждый елемент и если он меньше minElement то мы перезапысываем minElement на него

            if (generalArr[i] < minElement) {
                minElement = generalArr[i];
                minElementIndex = i;
            }


        }

        System.out.println("\nСамый маленький елемент = " + minElement);
        System.out.println("Эго индекс = " + minElementIndex);


        System.out.println("Положительный елементы под индексом:");

        //Еще раз идем по массиву
        for (int i = 0; i < generalArr.length; i++) {

            //И если елемент больше нуля выводим его индекс
            if (generalArr[i] > 0) {
                System.out.print(i + "; ");
            }

        }

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
            int tmp = 2 * x1 + 3 * x0;
            System.out.println(i + 3 + " = " + tmp);

            x0 = x1;
            x1 = tmp;
        }


    }

    private static void task3() {

        Random random = new Random();

        //Задаем наш масив
        //Длину можно менять
        int[] mas = new int[5];


        System.out.println("Маш  массив:");

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

}

