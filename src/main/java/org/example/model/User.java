package org.example.model;

import org.example.example2.MyCustomValidation;

import javax.validation.constraints.NotNull;

public class User {

    @NotNull(message = "Username cannot be null")
    @MyCustomValidation(min = 3, max = 10, message = "Username must be between 3 and 10 characters")
    private String username;

    // Constructors, getters, and setters

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
