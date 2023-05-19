package com.zhibin.realworld.service;

import com.zhibin.realworld.controller.request.RegisterRequest;
import com.zhibin.realworld.controller.response.RegisterResponse;
import com.zhibin.realworld.entity.User;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    public RegisterResponse register(RegisterRequest request) {
        String username = request.getUser().getUsername();
        String email = request.getUser().getEmail();
        String password = request.getUser().getPassword();
        return new RegisterResponse(new RegisterResponse.Attributes(username, email, password));
    }
}
