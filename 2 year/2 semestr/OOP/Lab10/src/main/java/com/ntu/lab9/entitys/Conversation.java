package com.ntu.lab9.entitys;

public class Conversation extends AllEntitysParent {
    private String subWhoCallId;
    private String calledSubId;

    public Conversation(String subWhoCallId,String calledSubId){
        this.subWhoCallId = subWhoCallId;
        this.calledSubId = calledSubId;
    }

    public Conversation(){
    }

    //Getters and Setters


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
