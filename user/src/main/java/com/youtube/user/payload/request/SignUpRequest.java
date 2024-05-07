package com.youtube.user.payload.request;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import static com.youtube.user.constant.ValidationConstants.*;

@Setter
@Getter
@Builder
public class SignUpRequest {

    @Length(min = USERNAME_LENGTH, message = USERNAME_PATTERN_MESSAGE)
    private String username;

    @Length(message = PASSWORD_PATTERN_MESSAGE, min = PASSWORD_LENGTH)
    private String password;

    @Pattern(regexp = EMAIL_PATTERN,
            message = EMAIL_PATTERN_MESSAGE)
    private String email;
}