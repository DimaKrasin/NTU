package com.ntu.Lab10Luda.DAO;

import com.ntu.Lab10Luda.Entity.Personclient;

import java.util.List;

public interface PersonclientDAO {
    Personclient getPersonclientById(long id);
    List<Personclient> getAllPersonclients();

    boolean insertPersonclient(Personclient personclient);
    boolean updatePersonclient(Personclient personclient);
    boolean deletePersonclient(long id);
}
