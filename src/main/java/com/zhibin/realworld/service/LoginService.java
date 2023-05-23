package com.zhibin.realworld.service;

import com.zhibin.realworld.controller.response.RegisterResponse;
import com.zhibin.realworld.exception.LoginException;
import com.zhibin.realworld.domain.User;
import com.zhibin.realworld.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public boolean validate(String email, String password) {
        User user = userRepository.findUserByEmail(email).orElseThrow(() -> new LoginException(888, "email not exist"));
        if (!user.getPassword().equals(password)){
            throw new LoginException(777, "password is wrong");
        }
        return true;
    }

    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow();
    }
}
