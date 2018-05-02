/*
        В task1Implementation() вызивается 3 метода класса Integer
        в которые должны передаватся строки для последующего преобразования их в Integer
        но туда передается некоректная строка - stringToInteger
        это вызывает NumberFormatException которая отрабатывается в блоках try-catch
        NumberFormatException - checked
*/

public class Task1 {

    public static void task1Implementation() {

        System.out.println("\nTask 1");

        String stringToInteger = "ThisStringCall'NumberFormatException'( must be int, not String)";

        try {
            Integer i1 = Integer.parseUnsignedInt(stringToInteger);

            System.out.println(i1);
        } catch (NumberFormatException e) {
            System.out.println("catch NumberFormatException in 'parseUnsignedInt' method");
        }

        try {
            Integer i2 = Integer.parseInt(stringToInteger);

            System.out.println(i2);
        } catch (NumberFormatException e) {
            System.out.println("catch NumberFormatException in 'parseInt' method");
        }

        try {
            Integer i3 = Integer.decode(stringToInteger);

            System.out.println(i3);
        } catch (NumberFormatException e) {
            System.out.println("catch NumberFormatException in 'decode' method ");
        }
    }
}
