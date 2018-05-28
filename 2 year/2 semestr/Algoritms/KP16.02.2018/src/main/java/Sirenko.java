import java.util.Random;

public class Sirenko {
    public static void main(String[] args) {
        task1();
    }

    private static void task1(){
        Random random = new Random();

        double[][] generalArr = new double[4][4];

        double count = 0;

        for (int i = 0; i < generalArr.length; i++) {
            for (int j = 0; j < generalArr[i].length; j++) {
                generalArr[i][j] = random.nextInt(9) - 4;
                if (generalArr[i][j] < 0 & i==j) {
                    count = count + generalArr[i][j];
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

        System.out.println("Отрицательних на главной диагонали: "+count);
    }
}
