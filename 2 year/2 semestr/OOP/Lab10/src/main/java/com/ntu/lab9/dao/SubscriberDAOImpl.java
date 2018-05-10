package com.ntu.lab9.dao;

import com.ntu.lab9.ConnectionFactory;
import com.ntu.lab9.entitys.Subscriber;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriberDAOImpl implements SubscriberDAO {


    @Override
    public Subscriber getSubscriberById(String id) {
        // Connection connection = ConnectionFactory.getConnection();

        //try-with-resources
        try (Connection connection = com.ntu.lab9Example.ConnectionFactory.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM subscriber WHERE id=" + id)
        ) {

            if (rs.next()) {
                ///для зручності перенесли даний код у приватний метод extractBookFromResultSet

                return extractSubscriberFromResultSet(rs);


            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
     /*   finally {
        	if (connection != null) {
        		try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        	}
        }*/

        return null;
    }

    @Override
    public List<Subscriber> getAllSubscriber() {
        //try-with-resources
        try (Connection connection = ConnectionFactory.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM subscriber")
        ) {

            List<Subscriber> subscribers = new ArrayList<>(); //змінна для формування списку

            while (rs.next()) {
                Subscriber subscriber = extractSubscriberFromResultSet(rs);
                subscribers.add(subscriber);  //додаємо одну до списку
            }

            return subscribers; //повертаємо список книжок

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return null;
    }

    @Override
    public boolean insertSubscriber(Subscriber subscriber) {
        //try-with-resources
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO subscriber(id,available) VALUES (?, ?)")
        ) {

            ps.setString(1, subscriber.getNumber());
            ps.setBoolean(2, subscriber.isAvailable());

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
    public boolean updateSubscriber(Subscriber subscriber) {
        //try-with-resources
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE subscriber set ID = ?, available= ? WHERE ID=?")
        ) {
            ps.setString(1, subscriber.getNumber());
            ps.setBoolean(2, subscriber.isAvailable());
            ps.setString(3, subscriber.getNumber());

            int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE

            if (i == 1) {

                return true;

            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        return false;
    }

    public boolean updateSubscriber(Subscriber subscriber,String id) {
        //try-with-resources
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE subscriber set ID = ?, available= ? WHERE ID=?")
        ) {
            ps.setString(1, subscriber.getNumber());
            ps.setBoolean(2, subscriber.isAvailable());
            ps.setString(3, id);

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
    public boolean deleteSubscriber(String id) {
        //try-with-resources
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM subscriber WHERE id=?")
        )
        {

            ps.setString(1, id);

            int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE

            if(i == 1) {

                return true;

            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        return false;
    }

    private Subscriber extractSubscriberFromResultSet(ResultSet rs) throws SQLException {

        return new Subscriber(rs.getString("id"), rs.getBoolean("available"));

    }

}
