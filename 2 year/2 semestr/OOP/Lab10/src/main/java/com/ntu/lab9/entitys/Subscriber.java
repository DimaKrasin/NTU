package com.ntu.lab9.entitys;

public class Subscriber extends AllEntitysParent {
    private String number;
    private boolean available;

    public Subscriber(String number){
        this.number = number;
        this.available = true;
    }

    public Subscriber(){ }

    public Subscriber(String number,Boolean available){
        this.number = number;
        this.available = available;
    }

    public void call(Subscriber subscriber2){
        System.out.println("Hi "+subscriber2.getNumber()+"!");
        System.out.println("I'm "+this.getNumber()+", and now we talk");
    }

    //Getters and Setters

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
