package com.example.authservice.controller;

import com.example.authservice.api.AuthApi;
import com.example.authservice.model.AuthTokens;
import com.example.authservice.model.RefreshTokenRequest;
import com.example.authservice.model.UserCredentials;
import com.example.authservice.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1") // No application.yaml or properties => default port is 8080
public class AuthController implements AuthApi {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ResponseEntity<AuthTokens> loginUser(@Valid @RequestBody UserCredentials userCredentials) {
        return ResponseEntity.ok(authService.login(userCredentials));
    }

    @Override
    public ResponseEntity<AuthTokens> refreshToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(authService.refresh(refreshTokenRequest));
    }
}
