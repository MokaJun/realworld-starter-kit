package com.zhibin.realworld.controller;


import com.zhibin.realworld.controller.request.LoginRequest;
import com.zhibin.realworld.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RequestMapping("/api/users/login")
@RestController
public class LoginController {
    @PostMapping
    public User login(HttpServletRequest request, @RequestBody LoginRequest loginRequest){
        String username = loginRequest.getUser().getEmail();
        String password = loginRequest.getUser().getPassword();
        if (username.equals("admin") && password.equals("password")){
            HttpSession session = request.getSession(true);
            session.setAttribute("userinfo","userinfo");
        }
        return new User("adminEmail", null, "admin", "bio", null);
    }
}
