package com.youtube.user.constant;

import static com.youtube.user.constant.ApiConstants.USER_BASE_URL;
import static com.youtube.user.constant.ApiConstants.SIGNIN_URL;
import static com.youtube.user.constant.ApiConstants.SIGNUP_URL;

public class SwaggerConstants {
    public static final String[] PUBLIC_URL = {
            USER_BASE_URL.concat(SIGNIN_URL),
            USER_BASE_URL.concat(SIGNUP_URL),
            "/swagger-ui/**",
            "/swagger-resources/**",
            "/v3/api-docs/**"
    };
    public static final String API_TITLE = "YouTube";
    public static final String API_VERSION = "1.0";
    public static final String API_DESCRIPTION = "YouTube Clone App";
}
