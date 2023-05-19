package com.zhibin.realworld.controller;


import com.zhibin.realworld.controller.request.LoginRequest;
import com.zhibin.realworld.controller.request.RegisterRequest;
import com.zhibin.realworld.controller.response.LoginResponse;
import com.zhibin.realworld.controller.response.RegisterResponse;
import com.zhibin.realworld.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.springframework.http.HttpStatus.CREATED;

@RequestMapping("/api/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final RegisterService registerService;

    @PostMapping("/login")
    public LoginResponse login(HttpServletRequest request, @RequestBody LoginRequest loginRequest){
        String email = loginRequest.getUser().getEmail();
        String password = loginRequest.getUser().getPassword();
        if (email.equals("admin") && password.equals("password")){
            HttpSession session = request.getSession(true);
            session.setAttribute("userinfo","userinfo");
        }
        return new LoginResponse(new LoginResponse.Attributes("adminEmail", "admin"));
    }

    @ResponseStatus(CREATED)
    @PostMapping()
    public RegisterResponse register(@RequestBody RegisterRequest request){
        return registerService.register(request);
    }
}
