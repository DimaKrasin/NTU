package com.ntu.Lab10Luda.DAO;

import com.ntu.Lab10Luda.Entity.Personclient;
import com.ntu.MyConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonclientDAOimpl implements PersonclientDAO {
    @Override
    public Personclient getPersonclientById(long id) {
        try (Connection connection = MyConnectionFactory.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Personclient WHERE id=" + id);
        ) {
            if (rs.next()) {
                return extractPersonclientFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return null;
    }

    @Override
    public List<Personclient> getAllPersonclients() {
        try (Connection connection = MyConnectionFactory.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Personclient");
        ) {

            List<Personclient> conferences = new ArrayList<>(); //змінна для формування списку

            while (rs.next()) {
                Personclient personclient = extractPersonclientFromResultSet(rs);
                conferences.add(personclient);  //додаємо одну до списку
            }

            return conferences; //повертаємо список

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean insertPersonclient(Personclient personclient) {
        try (Connection connection = MyConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "INSERT INTO Personclient(firstName,middleName, " +
                             "lastName,phone,serialOfPassport," +
                             "numOfPassport,address) VALUES (?,?,?,?,?,?,?)");
        ) {

            ps.setString(1,personclient.getFirstName());
            ps.setString(2,personclient.getMiddleName());
            ps.setString(3,personclient.getLastName());
            ps.setString(4,personclient.getPhone());
            ps.setString(5,personclient.getSerialOfPassport());
            ps.setInt(6,personclient.getNumOfPassport());
            ps.setString(7,personclient.getAddress());


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
    public boolean updatePersonclient(Personclient personclient) {
        try (Connection connection = MyConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "UPDATE  Personclient set firstName = ?,middleName=?," +
                             "lastName=?,phone=?,serialOfPassport=?," +
                             "numOfPassport=?,address=? WHERE id=?");
        ) {

            ps.setString(1,personclient.getFirstName());
            ps.setString(2,personclient.getMiddleName());
            ps.setString(3,personclient.getLastName());
            ps.setString(4,personclient.getPhone());
            ps.setString(5,personclient.getSerialOfPassport());
            ps.setInt(6,personclient.getNumOfPassport());
            ps.setString(7,personclient.getAddress());
            ps.setLong(8,personclient.getID());

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
    public boolean deletePersonclient(long id) {
        try (Connection connection = MyConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("DELETE FROM Personclient WHERE id=?");
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

    private Personclient extractPersonclientFromResultSet(ResultSet rs) throws SQLException {

        Personclient personclient = new Personclient();

        personclient.setID(rs.getLong("ID"));
        personclient.setFirstName(rs.getString("firstName"));
        personclient.setMiddleName(rs.getString("middleName"));
        personclient.setLastName(rs.getString("lastName"));
        personclient.setPhone(rs.getString("phone"));
        personclient.setSerialOfPassport(rs.getString("serialOfPassport"));
        personclient.setNumOfPassport(rs.getInt("numOfPassport"));
        personclient.setAddress(rs.getString("address"));


        return personclient;

    }
}
