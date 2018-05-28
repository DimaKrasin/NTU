package com.ntu.Lab10Luda.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Ticketregister extends Parent {
    private long ID;
    private long ticketId;
    private long personclientId;

    public Ticketregister() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public long getPersonclientId() {
        return personclientId;
    }

    public void setPersonclientId(long personclientId) {
        this.personclientId = personclientId;
    }


}
