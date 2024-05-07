package com.youtube.user.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {
    String extractEmail(String token);

    String generateToken(String email);

    Boolean isTokenValid(String token, UserDetails userDetails);
}