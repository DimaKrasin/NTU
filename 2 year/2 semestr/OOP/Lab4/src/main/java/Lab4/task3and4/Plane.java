package Lab4.task3and4;

import Lab4.task1and2.Mashine;

import java.util.Objects;

public class Plane extends Mashine {
    private String type;

    public Plane(String name, int currentlySpeed, String name1, String type) {
        super(name, currentlySpeed);
        this.type = type;
    }

    public void printInfo(){
        super.printInfo();
        System.out.println("type = "+type);
    }

    @Override
    public void getCurrentlySpeed() {

    }

    @Override
    public void getCurrentlyMass() {

    }

    @Override
    public void getPassengerCount() {

    }

    @Override
    public void getMotorsCount() {

    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString()+"Plane{" +
                "type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        if (!super.equals(o)) return false;
        Plane plane = (Plane) o;
        return Objects.equals(type, plane.type);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), type);
    }

}
