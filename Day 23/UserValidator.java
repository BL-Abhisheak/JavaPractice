package com.regex;

@FunctionalInterface
public interface UserValidator {
    boolean validate(String input) throws InvalidUserDetailsException;
}

