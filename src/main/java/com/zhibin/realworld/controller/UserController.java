package com.zhibin.realworld.controller;


import com.zhibin.realworld.controller.request.LoginRequest;
import com.zhibin.realworld.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/api/users")
@RestController
public class UserController {
    @PostMapping("/login")
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
