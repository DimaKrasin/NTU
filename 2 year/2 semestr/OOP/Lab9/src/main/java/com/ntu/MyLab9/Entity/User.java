package com.ntu.MyLab9.Entity;

public class User {

    private long id;
    private String username;
    private String surname;
    private String nickName;
    private boolean inConference;

    public User() {
    }

    public User(String username, String surname, String nickName) {
        this.username = username;
        this.surname = surname;
        this.nickName = nickName;
        this.inConference = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean isInConference() {
        return inConference;
    }

    public void setInConference(boolean inConference) {
        this.inConference = inConference;
    }

    @Override
    public String toString() {

        System.out.println("User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", surname='" + surname + '\'' +
                ", nickName='" + nickName + '\'' +
                ", inConference=" + inConference +
                '}');

        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", surname='" + surname + '\'' +
                ", nickName='" + nickName + '\'' +
                ", inConference=" + inConference +
                '}';
    }
}
