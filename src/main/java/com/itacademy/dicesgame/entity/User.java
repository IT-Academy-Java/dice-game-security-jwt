package com.itacademy.dicesgame.entity;

public class User {

    private String user;
    private String pwd;
    private String token;

    public User() {
    }

    public User(String user, String pwd, String token) {
        this.user = user;
        this.pwd = pwd;
        this.token = token;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
