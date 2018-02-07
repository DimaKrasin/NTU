import java.util.Scanner;

public class Main {

    private String name;
    private String age;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Write your name:");
        String name = sc.nextLine();
        System.out.println("Write your age:");
        String age = sc.nextLine();

        System.out.println("Name = "+name + "\nAge = "+age);

        System.out.println("Task 2 =============");
        dots();
    }

    private static void dots(){
        System.out.println("Координаты C:\nx=");
        float Xc = sc.nextFloat();
        System.out.println("y=");
        float Yc = sc.nextFloat();
        System.out.println("Координаты A:\nx=");
        float X1 = sc.nextFloat();
        System.out.println("y=");
        float Y1 = sc.nextFloat();

        float X2 = X1 + Xc;
        float Y2 = Y1 + Yc;

        System.out.println("B("+X2+","+Y2+")");
    }
}
