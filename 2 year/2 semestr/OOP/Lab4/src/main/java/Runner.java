public class Runner {
    public static void main(String[] args) {

//        int x1 = 390;
//        int y1 = 283;
//
//        int x2 =400;
//        int y2 = 300;

        //center
        int x1 =1;
        int y1 = 6;

        //c
        int x2 =4;
        int y2 =4;

        System.out.println("Special 1");
        //54
        for(int i = x1+1;i<=x1+1;i++){
            System.out.println(i);
            for(int j = y1-1;j>=y1-1;j--){
                if ( ((y1-y2)*i+(x2-x1)*j+(x1*y2-x2*y1))==0)
                    System.out.println("x ="+i+" y="+j);
                break;
            }
        }

        System.out.println("Right direction");
        for(int i = x1+1;i<10;i++){
            for(int j = y1+1;j<10;j++){
                if ( ((y1-y2)*i+(x2-x1)*j+(x1*y2-x2*y1))==0)
                    System.out.println("x ="+i+" y="+j);
                break;
            }
        }

        System.out.println("Left direction");
        for(int i = x1-1;i>=x1-1;i--){
            for(int j = y1;j<=y1+1;j++){
                if ( ((y1-y2)*i+(x2-x1)*j+(x1*y2-x2*y1))==0)
                    System.out.println("x ="+i+" y="+j);
               break;
            }
        }
    }
}
