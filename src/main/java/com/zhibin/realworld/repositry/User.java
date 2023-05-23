package com.zhibin.realworld.repositry;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
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
