package com.zhibin.realworld.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class RegisterResponse {

    private Attributes user;

    @Getter
    @AllArgsConstructor
    public static class Attributes {
        public String username;
        public String email;
        public String password;
    }
}
