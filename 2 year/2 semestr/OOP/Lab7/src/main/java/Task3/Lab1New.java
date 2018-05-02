package Task3;

import java.util.Scanner;

public class Lab1New {
    private  Scanner sc = new Scanner(System.in);

    public void inputYourName() {

        System.out.println("Write your name:");
        String name = sc.nextLine();
        System.out.println("Write your age:");
        String age = sc.nextLine();

        System.out.println("Name = "+name + "\nAge = "+age);
    }

    public void dots(){
        System.out.println("Координаты C:\nx=");
        float Xc = DemoMyExceptionWithLab1New.stringToFloatWithMyExeption(sc.nextLine());
        System.out.println("y=");
        float Yc = DemoMyExceptionWithLab1New.stringToFloatWithMyExeption(sc.nextLine());
        System.out.println("Координаты A:\nx=");
        float X1 = DemoMyExceptionWithLab1New.stringToFloatWithMyExeption(sc.nextLine());
        System.out.println("y=");
        float Y1 = DemoMyExceptionWithLab1New.stringToFloatWithMyExeption(sc.nextLine());

        float X2 = X1 + Xc;
        float Y2 = Y1 + Yc;

        System.out.println("B("+X2+","+Y2+")");
    }
}
