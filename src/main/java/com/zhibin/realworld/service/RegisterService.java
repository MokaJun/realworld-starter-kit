package com.zhibin.realworld.service;

import com.zhibin.realworld.controller.request.RegisterRequest;
import com.zhibin.realworld.controller.response.RegisterResponse;
import com.zhibin.realworld.repositry.User;
import com.zhibin.realworld.exception.RegistrationException;
import com.zhibin.realworld.repositry.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final UserRepository userRepository;

    public RegisterResponse register(RegisterRequest request) {
        String username = request.getUser().getUsername();
        String email = request.getUser().getEmail();
        String password = request.getUser().getPassword();
        if (userRepository.existsUserByEmail(email)) {
            throw new RegistrationException("user already exist");
        }
        User save = userRepository.save(new User(email, username, password));

        return new RegisterResponse(new RegisterResponse.Attributes(save.getEmail(), save.getEmail(), save.getPassword()));
    }
}
