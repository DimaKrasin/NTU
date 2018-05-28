package com.ntu.Lab10Luda.DAO;

import com.ntu.Lab10Luda.Entity.Ticket;
import com.ntu.MyConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAOimpl implements TicketDAO {
    @Override
    public Ticket getTicketById(long id) {
        try (Connection connection = MyConnectionFactory.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM ticket WHERE id=" + id);
        ) {
            if (rs.next()) {
                return extractTicketFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return null;
    }

    @Override
    public List<Ticket> getAllTickets() {
        try (Connection connection = MyConnectionFactory.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM ticket");
        ) {

            List<Ticket> conferences = new ArrayList<>(); //змінна для формування списку

            while (rs.next()) {
                Ticket personclient = extractTicketFromResultSet(rs);
                conferences.add(personclient);  //додаємо одну до списку
            }

            return conferences; //повертаємо список

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean insertTicket(Ticket ticket) {
        try (Connection connection = MyConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "INSERT INTO ticket(ticketname,race,trainnumber,sittingnumber)" +
                             " VALUES (?,?,?,?)");
        ) {
            ps.setString(1,ticket.getTicketname());
            ps.setString(2,ticket.getRace());
            ps.setInt(3,ticket.getTrainnumber());
            ps.setInt(4,ticket.getSittingnumber());


            int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE

            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateTicket(Ticket ticket) {
        try (Connection connection = MyConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "UPDATE  ticket set ticketname=?," +
                             "race=?,trainnumber=?,sittingnumber=? WHERE id=?");
        ) {

            ps.setString(1,ticket.getTicketname());
            ps.setString(2,ticket.getRace());
            ps.setInt(3,ticket.getTrainnumber());
            ps.setInt(4,ticket.getSittingnumber());
            ps.setLong(5,ticket.getId());

            int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE

            if (i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteTicket(long id) {
        try (Connection connection = MyConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM ticket WHERE id=?");
        ) {
            ps.setLong(1, id);
            int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private Ticket extractTicketFromResultSet(ResultSet rs) throws SQLException {

        Ticket ticket = new Ticket();

        ticket.setId(rs.getLong("ID"));
        ticket.setTicketname(rs.getString("ticketname"));
        ticket.setRace(rs.getString("race"));
        ticket.setTrainnumber(rs.getInt("trainnumber"));
        ticket.setSittingnumber(rs.getInt("sittingnumber"));

        return ticket;

    }
}
