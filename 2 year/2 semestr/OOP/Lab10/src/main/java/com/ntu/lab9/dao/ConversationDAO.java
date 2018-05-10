package com.ntu.lab9.dao;

import com.ntu.lab9.entitys.Conversation;

import java.util.List;

public interface ConversationDAO {
    Conversation getConversationById(long id);
    List<Conversation> getAllConversation();
    boolean insertConversation(Conversation conversation);
    boolean updateConversation(Conversation conversation);
    boolean updateConversation(Conversation conversation,String id1,String id2);
    boolean deleteConversation(long id);
    boolean deleteConversation(Conversation conversation);
}
