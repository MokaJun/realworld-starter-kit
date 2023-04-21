package com.zhibin.realworld.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String email;
    private String token;
    private String username;
    private String bio;
    private String image;
}
