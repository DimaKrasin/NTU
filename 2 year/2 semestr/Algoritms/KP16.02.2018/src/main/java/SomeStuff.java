import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SomeStuff {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // task1();
        //task2();
        task3();
    }

    private static void task1(){
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

        List<Integer> indexIfZero =new ArrayList<Integer>();
        List<Integer> lessThenIne = new ArrayList<Integer>();

        System.out.println("Ваш массив:");
        for(int i =0;i<arr.size();i++){
            System.out.print(arr.get(i)+";");

            if(arr.get(i)==0){indexIfZero.add(i);}
            if(arr.get(i)<1){lessThenIne.add(i);}
        }

        System.out.println("\nИндексы елементов которые ==0:");
        for(int i =0;i<indexIfZero.size();i++){
            System.out.print(indexIfZero.get(i)+";");
        }

        System.out.println("\nИндексы елементов которые меньше 1:");
        for(int i =0;i<lessThenIne.size();i++){
            System.out.print(lessThenIne.get(i)+";");
        }
    }

    private static void task2(){
        System.out.println("Введите номер члена последовательности:");
        int index =0;
        if(scanner.hasNextInt()){
            index=scanner.nextInt();
        }
        if(index == 0){
            System.out.println("Неверный номер");
            return;
        }

        System.out.println("result = " +task2Recursion(0,1,index-1));
    }

    private static int task2Recursion(int x0,int x1,int count){

        System.out.println("count = "+count);

        x0=x1+4*x0;
        count = count-1;
        if(count==0){return x0;}
        return task2Recursion(x1,x0,count);
    }

    private static void task3(){

        System.out.println("Введите размер массива:");
        int lenth=0;
        if(scanner.hasNextInt()){
            lenth=scanner.nextInt();
        }

        int[] mas = new int[lenth];
        System.out.println("ВвОДИТЕ ЕЛЕМЕНТЫ:");
        for(int i=0;i<lenth;i++){
            mas[i]=scanner.nextInt();
        }

        System.out.println("Ваш массив:");
        for(int i=0;i<lenth;i++){
            System.out.print(mas[i]+";");
        }

        System.out.println("\nВедите елемент который хотите вставить");
        int a =scanner.nextInt();
        System.out.println("Ведите индекс на который хотите вставить");
        int place = scanner.nextInt();


        int index =0;
        int[] newArr = new int[mas.length+1];
        for(int i = 0;i<mas.length;i++){
            if(i==place){
                newArr[index] =a;
                index =index+1;
            }
            newArr[index]=mas[i];
            index =index+1;
        }

        System.out.println("Ваш новый массив:");
        for(int i=0;i<newArr.length;i++){
            System.out.print(newArr[i]+" ");
        }
    }
}
