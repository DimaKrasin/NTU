import java.util.Random;

/*
в конструкторе класса Task2 создается случайная строка которая передается
в Integer.parseInt(randomString). Это обернуто в try-catch.
*/

public class Task2 {

    public static void task1Implementation(){

        String randomString = createRandomString(1);

        System.out.println("\nTask 2\nWe try to use random generated string '"+randomString+"' in 'Integer.parseInt' method");


        try {
            Integer i = Integer.parseInt(randomString);

            System.out.println(i);
        } catch (NumberFormatException e) {
            System.out.println("catch NumberFormatException in 'parseInt' method");
        }

    }

    private static String createRandomString(int randomStringLenth) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < randomStringLenth) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
