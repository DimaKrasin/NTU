package Lab4.task3and4;

public class Plane {
    private String name;
    private String type;

    public Plane(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void printInfo(){
        System.out.println("name = " + name+"\ntype = "+type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
