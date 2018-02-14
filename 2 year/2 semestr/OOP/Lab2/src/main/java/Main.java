//Krasin Dima PR-2-2 OOP Lab2

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n======================\n");
        task1();

        System.out.println("\n======================\n");
        task2(2,32);

        System.out.println("\n======================\n");
        task3(3,4);
    }

    private static void task3(int heightMatrix,int widthMatrix){
        //Даний двовимірний масив цілих чисел розміру NхN. Виведіть на екран суму головної діагоналі масиву.
        System.out.println("Даний двовимірний масив цілих чисел розміру NхN. Виведіть на екран суму головної діагоналі масиву.");
        int[][] arr = new int[heightMatrix][widthMatrix];
        Random random = new Random();
        int summDiagonal = 0;

        for(int i =0;i<heightMatrix;i++){
            for(int j = 0;j<widthMatrix;j++){
                arr[i][j] = random.nextInt(10);
                if(i==j){summDiagonal = summDiagonal+arr[i][j];}
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(summDiagonal);
    }

    private static void task2(int minValue,int maxValue){
        //Створіть масив з усіх парних чисел від 2 до 30 та знайдіть суму елементів.
        // Виведіть елементи масиву та їх суму на екран.
        System.out.println("Створіть масив з усіх парних чисел від 2 до 30 та знайдіть суму елементів. " +
                "Виведіть елементи масиву та їх суму на екран.");
       // ArrayList<Integer> arr = new ArrayList<Integer>();
        int[] arr = new int[14];

        int i =2;
        int summ = 0;
        //Наповнення
        for (int j=0;j<arr.length;j++,i=+2) {
            //arr.add(minValue);
            arr[j]=i;
            summ = summ+i;
        }

        //Фільтрація та знаходження сумми
        //int summ = arr.stream().filter((s)->s % 2 == 0).reduce((s1, s2) -> s1 + s2).orElse(0);
        System.out.println(summ);
    }

    private static void task1() {

//        Знайдіть помилку в програмі та додайте коментар з описом в чому полягає помилка та як її виправити.

//        package ua.edu.ntu;
//
//        public class FindMistake {
//            public static void main(String[] args) {
//                float a;
//                double b = 156.25;
//                a = b;
//                System.out.println("a = " + a);
//
//            }
//        }

//         Помилки:
//         156.25 не мае точного двійкового представлення
//         b - змінна подвійної точності, а змінна а - одиничної(гарантія поведінки цього порівняння відсутня)
//         Рішення:
//         Порівнювати числа з плавуючею комою перетворенням до цілочислених типів

        System.out.println("Знайдіть помилку в програмі та додайте коментар з описом в чому полягає помилка та як її виправити.\n");
        System.out.println("        public class FindMistake {\n" +
                "            public static void main(String[] args) {\n" +
                "                float a;\n" +
                "                double b = 156.25;\n" +
                "                a = b;\n" +
                "                System.out.println(\"a = \" + a);\n" +
                "\n" +
                "            }\n" +
                "        }");
        System.out.println("Помилки:\n" +
                "         156.25 не мае точного двійкового представлення\n" +
                "         b - константа подвійної точності, а змінна а - одиничної(гарантія поведінки цього порівняння відсутня)\n" +
                "Рішення:\n" +
                "         Порівнювати числа з плавуючею комою перетворенням до цілочислених типів");
    }
}
