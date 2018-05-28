package com.ntu.Lab10Luda.DAO;

import com.ntu.Lab10Luda.Entity.Ticket;

import java.util.List;

public interface TicketDAO {
    Ticket getTicketById(long id);
    List<Ticket> getAllTickets();

    boolean insertTicket(Ticket ticket);
    boolean updateTicket(Ticket ticket);
    boolean deleteTicket(long id);
}
