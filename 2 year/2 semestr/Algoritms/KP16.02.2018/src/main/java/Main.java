
import java.text.BreakIterator;
import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //task1();
        //task2();
        //task3();
        //toxaTask1();
        lesha();

    }

    private static void lesha(){

        StringBuffer[] arr1 = new StringBuffer[1];
        StringBuffer[] arr2 = new StringBuffer[1];

        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        String source = "This is a test. This is a T.L.A? test. Now with a Dr. in it.";
        iterator.setText(source);
        int start = iterator.first();
        for (int end = iterator.next();
             end != BreakIterator.DONE;
             start = end, end = iterator.next()) {

            System.out.println(source.substring(start,end));
            if(source.substring(start,end-1).endsWith("?")){
                System.out.println("впросительное");
            }
        }
    }

    private static void task1(){
        //List<Double> list = Utils.inputDoubleArray();

        Random random = new Random();

        double[][] generalArr = new double[4][4];

        double count = 0;

        for(int i =0;i<generalArr.length;i++){
            for(int j =0;j<generalArr[i].length;j++){
                generalArr[i][j]= random.nextInt(9)-4;
                if(generalArr[i][j]>0){
                    count = count+1;
                }
            }
        }


        System.out.println("Матрица:");
        for(int i =0;i<generalArr.length;i++){
            int countPositiveInSpovpez = 0;
            for(int j =0;j<generalArr[i].length;j++){
                System.out.print(generalArr[i][j]+"   ");
                if(generalArr[j][i]>0){countPositiveInSpovpez=countPositiveInSpovpez+1;}
            }
            System.out.println("\n");
        }

        System.out.println("Положительных елементов  = "+count);

        for(int i =0;i<generalArr.length;i++){
            int countPositiveInSpovpez = 0;
            for(int j =0;j<generalArr[i].length;j++){
                if(generalArr[j][i]>0){countPositiveInSpovpez=countPositiveInSpovpez+1;}
            }
            System.out.println("в столбце"+i+1+" = "+countPositiveInSpovpez);
        }
    }

    private static  void task2(){
        int[][] generalArr = new int[4][4];

        for(int i =0;i<generalArr.length;i++){
            for (int j = 0;j<generalArr[i].length;j++){
                generalArr[i][j] = j+1;
            }
        }

        System.out.println("Матрица:");
        for(int i =0;i<generalArr.length;i++){
            int countPositiveInSpovpez = 0;
            for(int j =0;j<generalArr[i].length;j++){
                System.out.print(generalArr[i][j]+"   ");
                if(generalArr[j][i]>0){countPositiveInSpovpez=countPositiveInSpovpez+1;}
            }
            System.out.println("\n");
        }
    }

    private static void task3(){
        int[] arr = new int[]{1,10,3,5,2,6,9};

        for(int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length-1;j++){
                if(arr[j]<arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] =tmp;
                }
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
    }

    private static void toxaTask1(){
        int[] arr = new int[]{1,10,3,5,2,6,9};

        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i =0;i<arr.length;i++){
            if(arr[i]<min){min = arr[i];index=i;}
            if(arr[i]>=0){
                System.out.println("Положительный елемент под индексом "+i);
            }
        }
        System.out.println("Минимальный елемент = "+min+", индекс = "+index);
    }

}
