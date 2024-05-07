package com.youtube.user.exception;

import com.youtube.user.payload.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorResponse>> handleBadRequestExceptions(MethodArgumentNotValidException ex) {
        List<ErrorResponse> errorResponseList = new ArrayList<>();
        List<ObjectError> errorList = ex.getBindingResult().getAllErrors();

        for (ObjectError error : errorList) {
            errorResponseList.add(
                    new ErrorResponse(HttpStatus.BAD_REQUEST, error.getDefaultMessage())
            );
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseList);
    }
}