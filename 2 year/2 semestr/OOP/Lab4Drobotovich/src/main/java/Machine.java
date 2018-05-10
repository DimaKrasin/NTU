public abstract class Machine implements Run {

    protected final double MAX_SPEED = 200;
    protected final double MIN_SPEED = 0;
    protected final double MAX_PASSENGERSCOUNT = 3;
    protected final double MIN_PASSENGERSCOUNT = 0;

    protected String name;
    protected double currentlySpeed;

    public Machine(String name, double currentlySpeed) {
        this.name = name;

        if(currentlySpeed>=MIN_SPEED){
            if(currentlySpeed<=MAX_SPEED){
                this.currentlySpeed = currentlySpeed;
            }
        }
    }

    @Override
    public void printInfo() {
        System.out.println("Name = "+name);
        System.out.println("Currently speed = "+currentlySpeed);
    }
}
