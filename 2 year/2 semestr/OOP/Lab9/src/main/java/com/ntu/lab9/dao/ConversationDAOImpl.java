package com.ntu.lab9.dao;

import com.ntu.lab9.entitys.Conversation;
import com.ntu.lab9.ConnectionFactory;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConversationDAOImpl implements ConversationDAO {

    @Override
    public Conversation getConversationById(long id) {
        // Connection connection = ConnectionFactory.getConnection();

        //try-with-resources
        try (Connection connection = com.ntu.lab9Example.ConnectionFactory.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM conversation WHERE id=" + id);
        ) {

            if (rs.next()) {
                ///для зручності перенесли даний код у приватний метод extractBookFromResultSet


                return extractСonversationFromResultSet(rs);


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
    public List<Conversation> getAllConversation() {
        //try-with-resources
        try (Connection connection = ConnectionFactory.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM conversation");
        ) {

            List<Conversation> conversations = new ArrayList<>(); //змінна для формування списку Сonversation

            while (rs.next()) {
                Conversation conversation = extractСonversationFromResultSet(rs);
                conversations.add(conversation);  //додаємо одну Сonversation до списку
            }

            return conversations; //повертаємо список книжок

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return null;
    }

    @Override
    public boolean insertConversation(Conversation conversation) {
        //try-with-resources
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO conversation(subWhoCallId,calledSubId) VALUES (?, ?)");
        ) {

            ps.setString(1, conversation.getSubWhoCallId());
            ps.setString(2, conversation.getCalledSubId());

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
    public boolean updateConversation(Conversation conversation) {
        //try-with-resources
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE conversation set subWhoCallId = ?, calledSubId = ? WHERE id=?");
        ) {
            ps.setString(1, conversation.getSubWhoCallId());
            ps.setString(2, conversation.getCalledSubId());

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
    public boolean deleteConversation(long id) {
        //try-with-resources
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM Conversation WHERE id=?");
        )
        {

            ps.setLong(1, id);

            int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE

            if(i == 1) {

                return true;

            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        return false;
    }

    private Conversation extractСonversationFromResultSet(ResultSet rs) throws SQLException {

        return new Conversation(rs.getString("subWhoCallId"), rs.getString("calledSubId"));

    }

}
