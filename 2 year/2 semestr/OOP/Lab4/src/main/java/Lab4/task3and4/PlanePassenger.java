package Lab4.task3and4;

import Lab4.task3and4.Plane;

public class PlanePassenger extends Plane {

    private int maxPassengerCount;

    public PlanePassenger(String name,int maxPassengerCount) {
        super(name, "PassengerPlane");
        this.maxPassengerCount = maxPassengerCount;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("maxPassengerCount = "+maxPassengerCount);
    }
}
