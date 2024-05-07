package com.youtube.user.controller;

import com.youtube.user.payload.request.SignInRequest;
import com.youtube.user.payload.request.SignUpRequest;
import com.youtube.user.payload.response.SignInResponse;
import com.youtube.user.payload.response.SignUpResponse;
import com.youtube.user.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.youtube.user.constant.ApiConstants.SIGNIN_URL;
import static com.youtube.user.constant.ApiConstants.SIGNUP_URL;
import static com.youtube.user.constant.ApiConstants.USER_BASE_URL;

@RestController
@RequiredArgsConstructor
@RequestMapping(USER_BASE_URL)
public class UserController {
    private final IUserService userService;

    @PostMapping(SIGNUP_URL)
    public ResponseEntity<SignUpResponse> signup(@RequestBody @Valid SignUpRequest signUpRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.signup(signUpRequest));
    }

    @PostMapping(SIGNIN_URL)
    public ResponseEntity<SignInResponse> signin(@RequestBody @Valid SignInRequest signInRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.signin(signInRequest));
    }
}
