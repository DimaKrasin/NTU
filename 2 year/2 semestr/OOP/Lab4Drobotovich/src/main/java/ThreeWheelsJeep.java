public class ThreeWheelsJeep extends Jeep {

    private boolean isItThreeWheelsJeep;

    public ThreeWheelsJeep(String name, double currentlySpeed, double currentlyMass, int passangerCount) {
        super(name, currentlySpeed, 3, currentlyMass, passangerCount);
        isItThreeWheelsJeep =true;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("isItThreeWheelsJeep = "+isItThreeWheelsJeep);
    }
}
