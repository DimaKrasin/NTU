package com.ntu.lab9.dao;

import com.ntu.lab9.entitys.Subscriber;

import java.util.List;

public interface SubscriberDAO {

    Subscriber getSubscriberById(String id);
    List<Subscriber> getAllSubscriber();
    boolean insertSubscriber(Subscriber subscriber);
    boolean updateSubscriber(Subscriber subscriber);
    boolean updateSubscriber(Subscriber subscriber,String id);
    boolean deleteSubscriber(String id);

}
