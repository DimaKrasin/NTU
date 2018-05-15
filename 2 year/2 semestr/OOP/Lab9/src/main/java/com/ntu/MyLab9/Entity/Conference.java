package com.ntu.MyLab9.Entity;

public class Conference {

    private long id;

    private String conferencename;
    private boolean isAvailable;
    private final int MAX_USERS_IN_CONFERENCE = 4;

    public Conference() {

    }

    public Conference(String conferencename) {
        this.conferencename = conferencename;
        isAvailable = true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConferencename() {
        return conferencename;
    }

    public void setConferencename(String conferencename) {
        this.conferencename = conferencename;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getMAX_USERS_IN_CONFERENCE() {
        return MAX_USERS_IN_CONFERENCE;
    }

    @Override
    public String toString() {

        System.out.println("Conference{" +
                "id=" + id +
                ", conferencename='" + conferencename + '\'' +
                ", isAvailable=" + isAvailable +
                '}');

        return "Conference{" +
                "id=" + id +
                ", conferencename='" + conferencename + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
