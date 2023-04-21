package com.zhibin.realworld.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@Getter
public class LoginRequest {
    private Attributes user;
    @Getter
    public static class Attributes {
        public String email;
        public String password;
    }
}

