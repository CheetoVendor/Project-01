package com.revatureproject01.project01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revatureproject01.project01.entity.Account;
import com.revatureproject01.project01.security.JwtTokenUtil;
import com.revatureproject01.project01.service.AccountService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private final AccountService userService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil,
            AccountService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestBody Account user) {
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            var authentication = authenticationManager.authenticate(authenticationToken);
            var jwt = jwtTokenUtil.generateToken(authentication.getName());
            return jwt;
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "Invalid credentials";
        }
    }
}
