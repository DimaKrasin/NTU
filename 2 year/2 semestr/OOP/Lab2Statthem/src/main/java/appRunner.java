import java.util.Arrays;
import java.util.Random;


public class appRunner {


        public static void main(String[] args) {


            System.out.println("task2");
            task2();
            System.out.println("task3");
          task3(4,4);
        }

        private static void task3(int N,int M){
            int[][] arr = new int[N][M];
            Random random = new Random();

            int summ = 0;
            int count = 0;

            for(int i =0;i<N;i++){
                for(int j = 0;j<M;j++){
                    arr[i][j] = random.nextInt(10)+1;
                    System.out.print(arr[i][j] + " ");
                   if(arr[i][j] % 3 == 0) {
                      summ = summ + arr[i][j];
                       ++count;
                   }
                }
                System.out.println();
            }
            System.out.println("result = " + summ/count);
        }

        private static void task2(){


            int[] arr1 = new int[]{1,3,2,5,1,6,2};
            int[] arr2 = new int[]{1,4,2,9,9,6,0};

            System.out.println("arr1:");
            System.out.println(Arrays.toString(arr1));
            System.out.println("arr2:");
            System.out.println(Arrays.toString(arr2));


            for (int i=0;i<arr1.length;i++) {
                if(arr1[i] == arr2[i])
                    arr1[i] = 0;
            }
            System.out.println();
            System.out.println("arr1:");
            System.out.println(Arrays.toString(arr1));



        }


    }


