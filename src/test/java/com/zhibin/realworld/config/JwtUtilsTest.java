package com.zhibin.realworld.config;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilsTest {

    @Test
    void should() {
        JwtUtils jwtUtils = new JwtUtils();
        jwtUtils.createToken(new HashMap<>(), new User("a","b", new ArrayList<>()));
    }

}