package com.myWebApiServer.myWebApi.controller;

import com.myWebApiServer.myWebApi.payload.request.AuthRequest;
import com.myWebApiServer.myWebApi.payload.TokenResponse;
import com.myWebApiServer.myWebApi.exception.ResourceNotFoundException;
import com.myWebApiServer.myWebApi.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthController(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/welcome")
    public String apiWelcome() {
        return "Welcome to API!";
    }

    @PostMapping("/login")
    public TokenResponse AuthenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return new TokenResponse(jwtService.GenerateToken(authRequest.getUsername()));
        } else {
            throw new ResourceNotFoundException("could not found user..!!");
        }
    }
}
