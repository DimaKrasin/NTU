package com.ntu.MyLab9.DAO;

import com.ntu.MyLab9.Entity.Conference;
import com.ntu.MyLab9.Entity.User;
import com.ntu.MyLab9.MyConnectionFactory;

import java.sql.*;

public class Conference_UsersDAOimpl implements Conference_UsersDAO {

    private UserDAO userDAO = new UserDAOimpl();
    private ConferenceDAO conferenceDAO = new ConferenceDAOimpl();

    @Override
    public boolean addUserToConference(long conferenceid, long userid) {

        Conference conference = conferenceDAO.geConferenceById(conferenceid);
        User user = userDAO.getUserById(userid);

        if (conference.isAvailable() & !user.isInConference()) {

            try (Connection connection = MyConnectionFactory.getConnection();
                 PreparedStatement ps = connection.prepareStatement(
                         "INSERT INTO conference_users(userid, conferenceid) VALUES (?,?)");
            ) {
                ps.setLong(1, userid);
                ps.setLong(2, conferenceid);

                int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE

                if (i == 1) {

                    user.setInConference(true);
                    userDAO.updateUser(user);


                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(
                            "SELECT COUNT(*) FROM conference_users WHERE conferenceid = "+'"'+conference.getId()+'"');

                    if (rs.next()) {
                        if(rs.getLong("COUNT(*)")>=4){
                            conference.setAvailable(false);

                            conferenceDAO.updateConference(conference);
                        }
                    }
                    return true;
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean deleteUserFromConference(long id) {

        try (Connection connection = MyConnectionFactory.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM conference_users WHERE id=" + id);
        ) {
            if (rs.next()) {
                long userid = rs.getLong("userid");
                long conferenceid = rs.getLong("conferenceid");

                User user = userDAO.getUserById(userid);
                user.setInConference(false);
                userDAO.updateUser(user);

                Conference conference = conferenceDAO.geConferenceById(conferenceid);
                conference.setAvailable(true);
                conferenceDAO.updateConference(conference);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }



        try (Connection connection = MyConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM conference_users WHERE id=?");
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
