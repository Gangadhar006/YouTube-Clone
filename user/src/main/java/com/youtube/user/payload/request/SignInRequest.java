package com.youtube.user.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import static com.youtube.user.constant.ValidationConstants.*;

@Setter
@Getter
@Builder
public class SignInRequest {
    @Pattern(regexp = EMAIL_PATTERN,
            message = EMAIL_PATTERN_MESSAGE)
    private String email;

    @NotBlank(message = PASSWORD_MESSAGE)
    private String password;
}