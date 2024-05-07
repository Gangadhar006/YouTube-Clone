package com.youtube.user.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private HttpStatusCode statusCode;
    private String message;
}
