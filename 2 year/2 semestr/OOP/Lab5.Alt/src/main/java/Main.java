public class Main {
    public static void main(String[] args) {
        String str = "ke,eeee llllo";

        int maxLenth = 3;

        int count= 0;

        for (String retval : str.split(" |,")) {
            if(retval.length()>maxLenth){
                count=count+1;
            }
        }

        System.out.println("Число слов с длинной больше заданой = " + count);
    }


}
