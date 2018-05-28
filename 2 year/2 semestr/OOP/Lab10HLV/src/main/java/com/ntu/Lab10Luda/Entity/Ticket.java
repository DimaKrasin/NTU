package com.ntu.Lab10Luda.Entity;

public class Ticket extends Parent {

    private long ID;
    private String ticketname;
    private String race;
    private int trainnumber;
    private int sittingnumber;

    public Ticket() {
    }

    public long getId() {
        return ID;
    }

    public void setId(long ID) {
        this.ID = ID;
    }

    public String getTicketname() {
        return ticketname;
    }

    public void setTicketname(String ticketname) {
        this.ticketname = ticketname;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getTrainnumber() {
        return trainnumber;
    }

    public void setTrainnumber(int trainnumber) {
        this.trainnumber = trainnumber;
    }

    public int getSittingnumber() {
        return sittingnumber;
    }

    public void setSittingnumber(int sittingnumber) {
        this.sittingnumber = sittingnumber;
    }
}
