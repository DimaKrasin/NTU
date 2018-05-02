package Lab4.task3and4;

import Lab4.task3and4.Plane;

import java.util.Objects;

public class PlaneTransport extends Plane {

    private int maxWeight;

    public PlaneTransport(String name, int maxWeight) {
        super(name,2000, "TransportPlane","Transport");
        this.maxWeight = maxWeight;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("maxWeight = "+maxWeight);
    }

    @Override
    public String toString() {
        return super.toString()+"PlaneTransport{" +
                "maxWeight=" + maxWeight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlaneTransport)) return false;
        if (!super.equals(o)) return false;
        PlaneTransport that = (PlaneTransport) o;
        return maxWeight == that.maxWeight;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), maxWeight);
    }
}
