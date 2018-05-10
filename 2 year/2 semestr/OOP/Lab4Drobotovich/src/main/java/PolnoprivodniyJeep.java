public class PolnoprivodniyJeep extends Jeep {

    private boolean isItPolnoprivodniyJeep;

    public PolnoprivodniyJeep(String name, double currentlySpeed,
                              int wheelsCount, double currentlyMass, int passangerCount) {
        super(name, currentlySpeed, wheelsCount, currentlyMass, passangerCount);

        this.isItPolnoprivodniyJeep = true;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("isItPolnoprivodniyJeep = "+isItPolnoprivodniyJeep);
    }
}
