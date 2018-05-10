public class Main {
    public static void main(String[] args) {
        PolnoprivodniyJeep polnoprivodniyJeep = new PolnoprivodniyJeep(
                "AllWheelsJeep",40,4,450,2);

        polnoprivodniyJeep.printInfo();

        System.out.println("\n");

        ThreeWheelsJeep threeWheelsJeep = new ThreeWheelsJeep(
                "ThreeWheelsJeep",70,670,1);

        threeWheelsJeep.printInfo();
    }
}
