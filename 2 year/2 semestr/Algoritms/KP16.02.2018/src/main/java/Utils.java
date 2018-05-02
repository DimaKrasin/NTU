import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {

    private static Scanner scanner = new Scanner(System.in);

    public static List<Double> inputDoubleArray (){

        //Создаем и считываем массив
        List<Double> arr = new ArrayList<Double>();

        System.out.println("Вводите массив:");

        boolean b =true;

        while (b) {
            if (scanner.hasNextDouble()) {
                arr.add(scanner.nextDouble());
            } else {
                b=false;
            }
        }

        return arr;
    }

}
