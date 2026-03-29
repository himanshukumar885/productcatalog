package com.myshop.productcatalog.controller;

import com.myshop.productcatalog.model.User;
import com.myshop.productcatalog.repository.UserRepository;
import com.myshop.productcatalog.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody User user) {
        user.setPassword(
                passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
        Map<String, String> response = new HashMap<>();
        response.put("message", "User registered successfully!");
        return response;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {
        User existing = userRepository
                .findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        Map<String, String> response = new HashMap<>();

        if (passwordEncoder.matches(
                user.getPassword(), existing.getPassword())) {
            String token = jwtUtil.generateToken(
                    existing.getUsername());
            response.put("token", token);
        } else {
            response.put("error", "Wrong password!");
        }
        return response;
    }
}
