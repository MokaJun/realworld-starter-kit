package com.zhibin.realworld.controller;


import com.zhibin.realworld.controller.request.LoginRequest;
import com.zhibin.realworld.controller.request.RegisterRequest;
import com.zhibin.realworld.controller.response.LoginResponse;
import com.zhibin.realworld.controller.response.RegisterResponse;
import com.zhibin.realworld.domain.UserVO;
import com.zhibin.realworld.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.springframework.http.HttpStatus.CREATED;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users/login")
    public LoginResponse login(HttpServletRequest request, @RequestBody LoginRequest loginRequest){
        String email = loginRequest.getUser().getEmail();
        String password = loginRequest.getUser().getPassword();
        if (userService.validate(email, password)){
            HttpSession session = request.getSession(true);
            session.setAttribute("email",email);
        }
        return new LoginResponse(new LoginResponse.Attributes(email, password));
    }

    @ResponseStatus(CREATED)
    @PostMapping("/users")
    public RegisterResponse register(@RequestBody RegisterRequest request){
        return userService.register(request);
    }

    @GetMapping("/user")
    public UserVO currentUser(HttpServletRequest request){
        return userService.getUserByEmail(request.getSession(false).getAttribute("email").toString());
    }
}
