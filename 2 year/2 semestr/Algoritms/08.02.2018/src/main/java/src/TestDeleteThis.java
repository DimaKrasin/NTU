package src;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class TestDeleteThis {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        double centerX = 100;
        double radius = 10;

        double radonDegree = 270;
        double newCenterX = 0;

        double degreeInRad = Math.toRadians(radonDegree);

        /////////////////////////sin 45 = 0.707


        for(int i =0;i<360;i++){
            double tmp = Math.toRadians(i);
            newCenterX = centerX - (Math.cos(tmp)) * radius;
            System.out.println(newCenterX + " при "+i+" градусах");
        }

        //
//        for(int i =0;i<360;i++){
//            double tmp = Math.toRadians(i);
//            newCenterX = centerX + (Math.sin(tmp)) * radius;
//            System.out.println(newCenterX + " при "+i+" градусах");
//        }

        //1
       // newCenterX = centerX + (Math.sin(Math.toRadians(radonDegree))) * radius;

//        //2
//        newCenterX = centerX + (Math.sin(Math.toRadians(90 - (radonDegree-90))))*radius;
//        System.out.println("newCenterX = " + newCenterX);
//
//        //3
//        newCenterX = centerX - (Math.sin(Math.toRadians(radonDegree-180))*radius);
//        System.out.println("newCenterX = " + newCenterX);
    }
}
