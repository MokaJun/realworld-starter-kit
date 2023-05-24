package com.zhibin.realworld.controller.request;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonRootName("user")
public class UpdateUserRequest {
    private String email;
    private String username;
    private String password;
    private String image;
    private String bio;
}

