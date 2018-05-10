public class Jeep extends Machine{

    protected int wheelsCount;
    protected double CurrentlyMass;
    protected int passangerCount;

    public Jeep(String name, double currentlySpeed,int wheelsCount,double currentlyMass,int passangerCount) {
        super(name, currentlySpeed);

        if(wheelsCount>0) {
            if(wheelsCount<=4) {
                this.wheelsCount = wheelsCount;
            }
        }

        this.CurrentlyMass = currentlyMass;


        if(passangerCount>=MIN_PASSENGERSCOUNT){
            if(passangerCount<=MAX_PASSENGERSCOUNT){
                this.passangerCount = passangerCount;
            }
        }
    }

    @Override
    public double getCurrentlySpeed() {
        return super.currentlySpeed;
    }

    @Override
    public double getCurrentlyMass() {
        return getCurrentlyMass();
    }

    @Override
    public int getCurrentlyPassengerCount() {
        return passangerCount;
    }

    @Override
    public int getWheelsCount() {
        return wheelsCount;
    }

    @Override
    public void printInfo() {
        super.printInfo();

        System.out.println("wheelsCount = "+wheelsCount);
        System.out.println("CurrentlyMass = " + CurrentlyMass);
        System.out.println("passangerCount = "+passangerCount);
    }
}
