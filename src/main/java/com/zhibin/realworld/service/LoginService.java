package com.zhibin.realworld.service;

import com.zhibin.realworld.controller.request.LoginRequest;
import com.zhibin.realworld.controller.request.RegisterRequest;
import com.zhibin.realworld.controller.response.LoginResponse;
import com.zhibin.realworld.controller.response.RegisterResponse;
import com.zhibin.realworld.exception.LoginException;
import com.zhibin.realworld.exception.RegistrationException;
import com.zhibin.realworld.repositry.User;
import com.zhibin.realworld.repositry.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public boolean validate(LoginRequest request) {
        String email = request.getUser().getEmail();
        String password = request.getUser().getPassword();
        User user = userRepository.findUserByEmail(email).orElseThrow(() -> new LoginException(888, "email not exist"));
        if (!user.getPassword().equals(password)){
            throw new LoginException(777, "password is wrong");
        }
        return true;
    }
}
