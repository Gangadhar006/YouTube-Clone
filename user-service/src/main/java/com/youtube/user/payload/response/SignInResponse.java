package com.youtube.user.payload.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class SignInResponse {
    private String token;
}
