package Lab4.task3and4;

import Lab4.task3and4.Plane;

public class PlaneTransport extends Plane {

    private int maxWeight;

    public PlaneTransport(String name,int maxWeight) {
        super(name, "TransportPlane");
        this.maxWeight = maxWeight;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("maxWeight = "+maxWeight);
    }
}
