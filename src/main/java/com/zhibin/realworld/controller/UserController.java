package com.zhibin.realworld.controller;


import com.zhibin.realworld.controller.request.LoginRequest;
import com.zhibin.realworld.controller.request.RegisterRequest;
import com.zhibin.realworld.controller.response.LoginResponse;
import com.zhibin.realworld.controller.response.RegisterResponse;
import com.zhibin.realworld.domain.User;
import com.zhibin.realworld.service.LoginService;
import com.zhibin.realworld.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.springframework.http.HttpStatus.CREATED;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final RegisterService registerService;
    private final LoginService loginService;

    @PostMapping("/users/login")
    public LoginResponse login(HttpServletRequest request, @RequestBody LoginRequest loginRequest){
        String email = loginRequest.getUser().getEmail();
        String password = loginRequest.getUser().getPassword();
        if (loginService.validate(email, password)){
            HttpSession session = request.getSession(true);
            session.setAttribute("email",email);
        }
        return new LoginResponse(new LoginResponse.Attributes(email, password));
    }

    @ResponseStatus(CREATED)
    @PostMapping("/users")
    public RegisterResponse register(@RequestBody RegisterRequest request){
        return registerService.register(request);
    }

    @GetMapping("/user")
    public User currentUser(HttpServletRequest request){
        return loginService.getUserByEmail(request.getSession(false).getAttribute("email").toString());
    }
}
