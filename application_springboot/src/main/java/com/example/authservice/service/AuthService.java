package com.example.authservice.service;

import com.example.authservice.model.AuthTokens;
import com.example.authservice.model.RefreshTokenRequest;
import com.example.authservice.model.UserCredentials;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class AuthService {

    public AuthTokens login(UserCredentials userCredentials) {
        // For demonstration purposes, let's assume a simple check.
        // In a real application, you would validate against a user database.
        if ("user@example.com".equals(userCredentials.getEmail()) && "password".equals(userCredentials.getPassword())) {
            String accessToken = "dummy-access-token-" + UUID.randomUUID().toString();
            String refreshToken = "dummy-refresh-token-" + UUID.randomUUID().toString();
            AuthTokens tokens = new AuthTokens();
            tokens.setAccessToken(accessToken);
            tokens.setRefreshToken(refreshToken);
            return tokens;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }
    }

    public AuthTokens refresh(RefreshTokenRequest refreshTokenRequest) {
        // For demonstration, we'll accept any non-blank refresh token.
        // In a real application, you would validate the refresh token.
        if (refreshTokenRequest.getRefreshToken() != null && !refreshTokenRequest.getRefreshToken().isEmpty()) {
            String accessToken = "new-dummy-access-token-" + UUID.randomUUID().toString();
            String refreshToken = "new-dummy-refresh-token-" + UUID.randomUUID().toString();
            AuthTokens tokens = new AuthTokens();
            tokens.setAccessToken(accessToken);
            tokens.setRefreshToken(refreshToken);
            return tokens;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid refresh token");
        }
    }
}
