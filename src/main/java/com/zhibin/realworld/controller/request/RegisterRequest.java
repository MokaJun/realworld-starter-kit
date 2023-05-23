package com.zhibin.realworld.controller.request;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.Getter;

@JsonRootName("user")
@Getter
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
}