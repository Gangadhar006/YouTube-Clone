package com.youtube.user;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.youtube.user.constant.SwaggerConstants.*;
import static com.youtube.user.constant.SecurityConstants.*;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = API_TITLE,
                version = API_VERSION,
                description = API_DESCRIPTION
        )
)
@SecurityScheme(
        name = SECURITY_SCHEME_NAME,
        type = SecuritySchemeType.HTTP,
        scheme = BEARER,
        bearerFormat = SECURITY_BEARER_FORMAT
)
@SecurityRequirement(name = SECURITY_SCHEME_NAME)
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
