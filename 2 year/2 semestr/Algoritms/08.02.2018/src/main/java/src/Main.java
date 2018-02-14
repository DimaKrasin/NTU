package src;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //System.out.println("result = "+recursion(1,10));
        //System.out.println(task1(-99,-99,100));
        task2();
    }

    private static int recursion(int a,int count){
        if(count<=0){return a;}
        a=a+1;
        count=count-1;
        System.out.println("a="+a);
        System.out.println("count = "+count);
        return recursion(a,count);
    }

    private static int task1(int a,int b,int count){
        int c = a+b+100;
        if(count<=0){return c;}
        if(c>0){return c;}
        count=count-1;
        System.out.println("a= "+a+",b = "+b+",c = "+c+",count"+count);
        return task1(b,c,count);
    }

    private static void task2(){
        Random random = new Random();

        int[] mas = new int[10];

        for(int i = 0;i<mas.length;i++){
            mas[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(mas));

        int min = mas[1];
        int indexMin = 0;
        int max = mas[1];
        int indexMax = 0;

        for(int i =0;i<mas.length;i++){
            if(mas[i]>max){indexMax = i;max = mas[i];}
            if(mas[i]<min){indexMin = i;min = mas[i];}
        }

        int[] masResult = new int[mas.length-2];

        for(int i = 0, j=0;j<mas.length;j++){
            if(j!=indexMin){
                if(j!=indexMax){
                    masResult[i]=mas[j];
                    i=i+1;
                }
            }
        }

        int result =0;

        for(int i=0;i<masResult.length;i++){
            result = result +masResult[i];
        }

        double a= result/masResult.length;

        System.out.println("result = "+a);

    }


}
