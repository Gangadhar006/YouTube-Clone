package com.youtube.user.constant;

public class ValidationConstants {
    public static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";
    public static final String EMAIL_PATTERN_MESSAGE = "Enter valid Email";
    public static final String PASSWORD_MESSAGE = "Password should not be empty!";
    public static final int PASSWORD_LENGTH = 8;
    public static final int USERNAME_LENGTH = 8;
    public static final String PASSWORD_PATTERN_MESSAGE = "Password must be at least " + PASSWORD_LENGTH + " characters long";
    public static final String USERNAME_PATTERN_MESSAGE = "Username must be at least " + USERNAME_LENGTH + " characters long";
}