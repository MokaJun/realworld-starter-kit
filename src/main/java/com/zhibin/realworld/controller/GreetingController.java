package com.zhibin.realworld.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/greeting")
@RestController
public class GreetingController {
    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("hello from my API");
    }

    @GetMapping("/say-good-bye")
    public ResponseEntity<String> sayGoodBye(){
        return ResponseEntity.ok("say good bye");
    }
}
