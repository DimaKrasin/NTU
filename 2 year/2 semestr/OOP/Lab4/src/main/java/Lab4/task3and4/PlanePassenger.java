package Lab4.task3and4;

import Lab4.task3and4.Plane;

import java.util.Objects;

public class PlanePassenger extends Plane {

    private int maxPassengerCount;

    public PlanePassenger(String name,int maxPassengerCount) {
        super(name,1000, "PassengerPlane","Passenger");
        this.maxPassengerCount = maxPassengerCount;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("maxPassengerCount = "+maxPassengerCount);
    }

    @Override
    public String toString() {
        return super.toString()+"PlanePassenger{" +
                "maxPassengerCount=" + maxPassengerCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlanePassenger)) return false;
        if (!super.equals(o)) return false;
        PlanePassenger that = (PlanePassenger) o;
        return maxPassengerCount == that.maxPassengerCount;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), maxPassengerCount);
    }
}
