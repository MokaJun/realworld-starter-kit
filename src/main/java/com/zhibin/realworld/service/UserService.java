package com.zhibin.realworld.service;

import com.zhibin.realworld.controller.request.RegisterRequest;
import com.zhibin.realworld.controller.request.UpdateUserRequest;
import com.zhibin.realworld.controller.response.RegisterResponse;
import com.zhibin.realworld.domain.user.*;
import com.zhibin.realworld.exception.LoginException;
import com.zhibin.realworld.exception.RegistrationException;
import com.zhibin.realworld.exception.UserNotExistException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public RegisterResponse register(RegisterRequest request) {
        String username = request.getUsername();
        String email = request.getEmail();
        String password = request.getPassword();
        if (userRepository.existsUserByEmail(email)) {
            throw new RegistrationException("user already exist");
        }
        User save = userRepository.save(new User(email, username, password));

        return new RegisterResponse(new RegisterResponse.Attributes(save.getEmail(), save.getEmail(), save.getPassword()));
    }

    public UUID validate(String email, String password) {
        User user = userRepository.findUserByEmail(email).orElseThrow(() -> new LoginException(888, "email not exist"));
        if (!user.getPassword().equals(password)){
            throw new LoginException(777, "password is wrong");
        }
        return user.getId();
    }

    public UserVO getUserByUUID(UUID uuid) {
        return userMapper.userToUserVO(userRepository.findById(uuid).orElseThrow(() -> new LoginException(888, "email not exist")));
    }

    public UserVO update(UUID uuid ,UpdateUserRequest request) {
        User userById = userRepository.findById(uuid).orElseThrow(UserNotExistException::new);
        String username = request.getUsername();
        String password = request.getPassword();
        String email = request.getEmail();
        String bio = request.getBio();
        String image = request.getImage();
        if (StringUtils.isNoneBlank(username)) userById.setUsername(username);
        if (StringUtils.isNoneBlank(password)) userById.setPassword(password);
        if (StringUtils.isNoneBlank(email)) userById.setEmail(email);
        if (StringUtils.isNoneBlank(bio)) userById.setBio(bio);
        if (StringUtils.isNoneBlank(image)) userById.setImage(image);
        User savedUser = userRepository.save(userById);
        return userMapper.userToUserVO(savedUser);
    }

    public ProfileVO getProfile(UUID uuidFromSession, String usernameTo) {
        User userTo = userRepository.findUserByUsername(usernameTo).orElseThrow(UserNotExistException::new);
        User me = userRepository.findById(uuidFromSession).orElseThrow(UserNotExistException::new);
        return new ProfileVO(me, userTo);
    }
}
