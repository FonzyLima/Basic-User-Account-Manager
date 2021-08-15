package com.mobdeve.s11.lima.alfonso.formetiveexercise4;

public class Users {
    private String username, name, description, number;


    public Users(String username, String name, String description, String number) {
        this.username = username;
        this.name = name;
        this.description = description;
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getNumber() {
        return number;
    }
}
