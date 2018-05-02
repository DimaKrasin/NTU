package Task3;

import java.util.InputMismatchException;

public class DemoMyExceptionWithLab1New {

    public static void task3Implimentation() {
        Lab1New lab1New = new Lab1New();

        /*
        Метод dots() из первой лабораторной переделан и при считывание чисел с клавиатуры сканером
        отправляет их в медод stringToFloatWithMyExeption() для отлавливания ошибок при превращении
        строки в число
        */
        lab1New.dots();
    }

    public static float stringToFloatWithMyExeption(String str) {

        float result = 9;

        try {
            result = Float.parseFloat(str);
        } catch (InputMismatchException | NumberFormatException e) {
            try {
                throw new MyExceptionForLab1New();
            } catch (MyExceptionForLab1New myExceptionForLab1New) {
                myExceptionForLab1New.printStackTrace();
            }
        }

        return result;
    }
}
