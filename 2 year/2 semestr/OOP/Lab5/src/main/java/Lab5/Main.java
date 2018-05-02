package Lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Вариант 11 Красин ПР-2-2

    /*
    Дано рядок зі слів, розділених пробілом. Поміняти місцями в
кожному слові першу та останню букву. Вивести результат на екран.
     */
    /*
    Дано рядок зі слів, розділених пробілами. Використовуючи
StringBuilder розставити слова у такому порядку, щоб остання буква
даного слова збігалася з першою літерою наступного без урахування
регістру.
     */

public class Main {

    public static void main(String[] args) {
        String str = scanLine();

        //task1
        //reverseFirstAndLastLetter(str);


        //task2
       prioritizeWords(str);
    }

    private static String scanLine() {

        System.out.println("Enter your string:");

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }

    //task1
    private static void reverseFirstAndLastLetter(String str) {

        StringBuilder stringBuilder;

        for (String word : str.split(" ")) {

            stringBuilder = new StringBuilder(word);

            char firsLetter = stringBuilder.charAt(0);
            char lastLetter = stringBuilder.charAt(stringBuilder.length() - 1);

            stringBuilder.setCharAt(0, lastLetter);
            stringBuilder.setCharAt(stringBuilder.length() - 1, firsLetter);

            System.out.print(stringBuilder + " ");
        }
    }

    //task2
    private static void prioritizeWords(String str) {

        //Split масивва по пробелу
        List<StringBuilder> words = new ArrayList<StringBuilder>();

        for (String tmp : str.split(" ")) {
            words.add(new StringBuilder(tmp));
        }

        StringBuilder finalView = new StringBuilder();
        finalView.append(words.get(0)+" ");

        //подбор пар слов
        for (int i = 0; i < words.size(); i++) {

            boolean haveCouple = calculate(words,finalView);
            if (!haveCouple) {

                StringBuilder associatedWords = new StringBuilder();
                associatedWords.append(words.get(0));
                associatedWords.append(words.get(1));

                finalView.append(words.get(1)+" ");

                words.remove(0);
                words.remove(0);

                words.add(0, associatedWords);
            }
        }

        finalView.append(words.get(words.size()-1));
        System.out.println(finalView);
        //for(int i =0;i<words.size();i++){
          //  System.out.println(words.get(i));
        //}
    }

    private static boolean calculate(List<StringBuilder> words,StringBuilder finalView) {

        boolean haveCouple = false;

        for (int j = 0; j < words.size(); j++) {
            if (words.get(0).charAt(words.get(0).length() - 1)
                    == words.get(j).charAt(0)) {

                StringBuilder associatedWords = new StringBuilder();
                associatedWords.append(words.get(0));
                associatedWords.append(words.get(j));

                finalView.append(words.get(j)+" ");

                haveCouple = true;

                words.remove(0);
                if (j - 1 >= 0) {
                    words.remove(j - 1);
                }

                words.add(0, associatedWords);
            }
        }

        return haveCouple;
    }
}

