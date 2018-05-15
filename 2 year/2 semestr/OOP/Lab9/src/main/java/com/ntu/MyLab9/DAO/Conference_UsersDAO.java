package com.ntu.MyLab9.DAO;

public interface Conference_UsersDAO {
    boolean addUserToConference(long conferenceid,long userid);
    boolean deleteUserFromConference(long id);
}
