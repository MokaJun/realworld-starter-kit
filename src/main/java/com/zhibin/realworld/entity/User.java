package com.zhibin.realworld.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Id;

@Data
@AllArgsConstructor
public class User {
    @Id
    private String email;
    private String password;
    private String token;
    private String username;
    private String bio;
    private String image;

    public User(String email, String username, String password){
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
