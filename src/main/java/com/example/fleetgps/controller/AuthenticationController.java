package com.example.fleetgps.controller;

import com.example.fleetgps.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    // Hardcoded credentials for authentication (for simplicity)
    private final String username = "user";
    private final String password = "password";

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            // Generate JWT token if credentials match
            return jwtTokenUtil.generateToken(username);
        }
        throw new RuntimeException("Invalid credentials");
    }
}
