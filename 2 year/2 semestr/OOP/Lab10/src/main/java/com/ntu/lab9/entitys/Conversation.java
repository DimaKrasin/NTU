package com.ntu.lab9.entitys;

public class Conversation extends AllEntitysParent {

    private long ID;

    private String subWhoCallId;
    private String calledSubId;

    public Conversation(String subWhoCallId,String calledSubId){
        this.subWhoCallId = subWhoCallId;
        this.calledSubId = calledSubId;
    }

    public Conversation(){
    }

    public Conversation(long ID, String subWhoCallId, String calledSubId) {
        this.ID = ID;
        this.subWhoCallId = subWhoCallId;
        this.calledSubId = calledSubId;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getSubWhoCallId() {
        return subWhoCallId;
    }

    public void setSubWhoCallId(String subWhoCallId) {
        this.subWhoCallId = subWhoCallId;
    }

    public String getCalledSubId() {
        return calledSubId;
    }

    public void setCalledSubId(String calledSubId) {
        this.calledSubId = calledSubId;
    }
}
