package com.youtube.user.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class SignUpResponse {
    private String username;

    private String password;

    private String email;

    private LocalDateTime createdAt;
}
