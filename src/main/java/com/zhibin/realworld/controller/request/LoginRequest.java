package com.zhibin.realworld.controller.request;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;


@Getter
@JsonRootName("user")
public class LoginRequest {
    private String email;
    private String password;
}

