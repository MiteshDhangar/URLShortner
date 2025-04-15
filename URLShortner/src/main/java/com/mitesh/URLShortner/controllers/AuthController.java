package com.mitesh.URLShortner.controllers;

import com.mitesh.URLShortner.DTOs.LoginRequest;
import com.mitesh.URLShortner.DTOs.RegisterRequest;
import com.mitesh.URLShortner.models.User;
import com.mitesh.URLShortner.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Data
public class AuthController {
    @Autowired
    private UserService userService;
    @PostMapping("/public/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest request){
        return ResponseEntity.ok(userService.authenticateUser(request));
    }
    @PostMapping("/public/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request){
        User user=new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setRole("ROLE_USER");
        userService.registerUser(user);
        return ResponseEntity.ok("User Register successfully");
    }
}
