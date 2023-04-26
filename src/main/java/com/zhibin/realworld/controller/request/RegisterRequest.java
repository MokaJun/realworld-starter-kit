package com.zhibin.realworld.controller.request;

import lombok.Data;
import lombok.Getter;

@Data
public class RegisterRequest {
    private Attributes user;

    @Getter
    public static class Attributes {
        public String username;
        public String email;
        public String password;
    }
}