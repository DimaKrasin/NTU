import java.util.Random;

public class Main {

    public static void main(String[] args) {

        //zadanie1();
        //zadanie2();
        zadanie3();

    }

    private static void zadanie1() {
//        Знайдіть помилку в програмі та додайте коментар з описом в чому
//        полягає помилка та як її виправити.
//
//        byte b;
//        int a;
//        a = 20;
//        b = 1000 / a;
//
//        System.out.println(" b = "+b);


        byte b;
        int a;
        a = 20;
        b = (byte) (1000 / a);

        System.out.println(" b = " + b);

    }

    private static void zadanie2() {


        //Даний масив дійсних чисел . Знайти суму елементів масиву.

        int[] arr = new int[5];

        int summ = 0;

        System.out.println("\n");

        //Наповнення
        for (int j = 0; j < arr.length; j++) {
            System.out.print(j + "; ");
            arr[j] = j;
            summ = summ + arr[j];
        }

        System.out.println("\nsum = " + summ);
    }

    private static void zadanie3() {
//        Даний двовимірний масив цілих чисел розміру NхM.Відсортуйте
//        елементи в рядках по зростанню.

        int heightMatrix = 5;
        int widthMatrix = 5;

        int[][] arr = new int[heightMatrix][widthMatrix];
        Random random = new Random();

        System.out.println("До сортировки");

        for (int i = 0; i < heightMatrix; i++) {
            for (int j = 0; j < widthMatrix; j++) {
                arr[i][j] = random.nextInt(10);
                System.out.print(arr[i][j] + "; ");
            }
            System.out.println();
        }

        System.out.println("После сортировки");

        for (int i = 0; i < heightMatrix; i++) {


            for(int d = 0;d<widthMatrix;d++) {
                for (int j = 0; j < widthMatrix - 1; j++) {
                    if (arr[i][j] < arr[i][j + 1]) {
                        int tmp = arr[i][j + 1];
                        arr[i][j + 1] = arr[i][j];
                        arr[i][j] = tmp;
                    }
                }
            }


            for (int j = 0; j < widthMatrix; j++) {

                System.out.print(arr[i][j] + "; ");
            }
            System.out.println();
        }
    }

}
