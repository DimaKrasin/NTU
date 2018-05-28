package com.ntu.Lab10Luda.DAO;

import com.ntu.Lab10Luda.Entity.Ticketregister;

import java.util.List;

public interface TicketregisterDAO {

    Ticketregister getTicketregisterById(long id);
    List<Ticketregister> getAllTicketregister();

    boolean insertTicketregister(Ticketregister ticketregister);
    boolean deleteTicketregister(long id);
}
