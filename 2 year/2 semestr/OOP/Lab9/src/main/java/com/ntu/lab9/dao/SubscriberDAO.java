package com.ntu.lab9.dao;

import com.ntu.lab9.entitys.Subscriber;

import java.util.List;

public interface SubscriberDAO {

    Subscriber getSubscriberById(String id);
    List<Subscriber> getAllSubscriber();
    boolean insertSubscriber(Subscriber book);
    boolean updateSubscriber(Subscriber book);
    boolean deleteSubscriber(String id);

}
