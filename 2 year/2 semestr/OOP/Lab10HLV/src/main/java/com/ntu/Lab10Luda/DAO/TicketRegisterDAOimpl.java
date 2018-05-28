package com.ntu.Lab10Luda.DAO;

import com.ntu.Lab10Luda.Entity.Ticketregister;
import com.ntu.MyConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketRegisterDAOimpl implements TicketregisterDAO {


    private Ticketregister extractTicketRegisterFromResultSet(ResultSet rs) throws SQLException {

        Ticketregister ticketregister = new Ticketregister();

        ticketregister.setID(rs.getLong("ID"));
        ticketregister.setTicketId(rs.getLong("ticketId"));
        ticketregister.setPersonclientId(rs.getLong("personclientId"));

        return ticketregister;

    }

    @Override
    public Ticketregister getTicketregisterById(long id) {
        try (Connection connection = MyConnectionFactory.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM ticketregister WHERE id=" + id);
        ) {
            if (rs.next()) {
                return extractTicketRegisterFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return null;
    }

    @Override
    public List<Ticketregister> getAllTicketregister() {
        try (Connection connection = MyConnectionFactory.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM ticketregister");
        ) {

            List<Ticketregister> conferences = new ArrayList<>(); //змінна для формування списку

            while (rs.next()) {
                Ticketregister personclient = extractTicketRegisterFromResultSet(rs);
                conferences.add(personclient);  //додаємо одну до списку
            }

            return conferences; //повертаємо список

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean insertTicketregister(Ticketregister ticketregister) {
        try (Connection connection = MyConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "INSERT INTO ticketregister(" +
                             "ticketId,personclientId)" +
                             " VALUES (?,?)");
        ) {
            ps.setLong(1,ticketregister.getTicketId());
            ps.setLong(2,ticketregister.getPersonclientId());



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
    public boolean deleteTicketregister(long id) {
        try (Connection connection = MyConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM ticketregister WHERE id=?");
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
}
