package com.youtube.user.service;

import com.youtube.user.payload.request.SignInRequest;
import com.youtube.user.payload.request.SignUpRequest;
import com.youtube.user.payload.response.SignInResponse;
import com.youtube.user.payload.response.SignUpResponse;

public interface IUserService {
    SignInResponse signin(SignInRequest request);

    SignUpResponse signup(SignUpRequest signupRequest);
}