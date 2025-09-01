package com.example.twitter_s19.controller;

import com.example.twitter_s19.entity.User;
import com.example.twitter_s19.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Kullanıcı kaydı
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // Kullanıcı login (basit örnek, password kontrolü service içinde yapılabilir)
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        return userService.findByUsername(user.getUsername())
                .map(u -> u.getPassword().equals(user.getPassword()) ?
                        ResponseEntity.ok("Login successful") :
                        ResponseEntity.status(401).body("Invalid credentials"))
                .orElse(ResponseEntity.status(404).body("User not found"));
    }
}

