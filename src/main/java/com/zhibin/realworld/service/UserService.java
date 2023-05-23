package com.zhibin.realworld.service;

import com.zhibin.realworld.controller.request.RegisterRequest;
import com.zhibin.realworld.controller.response.RegisterResponse;
import com.zhibin.realworld.domain.user.UserMapper;
import com.zhibin.realworld.domain.user.UserVO;
import com.zhibin.realworld.exception.LoginException;
import com.zhibin.realworld.domain.user.User;
import com.zhibin.realworld.domain.user.UserRepository;
import com.zhibin.realworld.exception.RegistrationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
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

    public boolean validate(String email, String password) {
        User user = userRepository.findUserByEmail(email).orElseThrow(() -> new LoginException(888, "email not exist"));
        if (!user.getPassword().equals(password)){
            throw new LoginException(777, "password is wrong");
        }
        return true;
    }

    public UserVO getUserByEmail(String email) {
        return userMapper.userToUserVO(userRepository.findUserByEmail(email).orElseThrow(() -> new LoginException(888, "email not exist")));
    }
}
