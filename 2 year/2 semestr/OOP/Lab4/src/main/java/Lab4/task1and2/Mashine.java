package Lab4.task1and2;

public abstract class Mashine implements Run {

    private static final int MAX_SPEED = 200;
    private static final int MIN_SPEED = 5;

    private static final int MAX_PASSENGER_COUNT = 250;
    private static final int MIN_PASSENGER_COUNT = 0;

    private String name;
    private int currentlySpeed;

    public Mashine(String name, int currentlySpeed) {
        this.name = name;
        this.currentlySpeed = currentlySpeed;
    }

    public void printInfo() {
        System.out.println("Mashine{" +
                "name='" + name + '\'' +
                ", currentlySpeed=" + currentlySpeed +
                '}');
    }
}
