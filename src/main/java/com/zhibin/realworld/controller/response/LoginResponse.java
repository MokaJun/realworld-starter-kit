package com.zhibin.realworld.controller.response;

import com.zhibin.realworld.controller.request.LoginRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Getter
public class LoginResponse {

    private Attributes user;
    @Getter
    @AllArgsConstructor
    public static class Attributes {
        public String email;
        public String password;
    }
}
