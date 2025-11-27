package com.regex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RejexWithExceptionHandlingTest {

    RejexWithExceptionHandling obj = new RejexWithExceptionHandling();

    @Test
    void validFirstNameReturnsTrue() throws InvalidUserDetailsException {
        Assertions.assertTrue(obj.validateFirstName("Abhisheak"));
    }

    @Test
    void invalidFirstNameThrowsException() {
        Assertions.assertThrows(InvalidUserDetailsException.class,
                () -> obj.validateFirstName("abhi"));
    }

    @Test
    void validEmailReturnsTrue() throws InvalidUserDetailsException {
        Assertions.assertTrue(obj.validateEmail("abc@gmail.co.in"));
    }

    @Test
    void invalidEmailThrowsException() {
        Assertions.assertThrows(InvalidUserDetailsException.class,
                () -> obj.validateEmail("abc@.gmail"));
    }

    @Test
    void validMobileReturnsTrue() throws InvalidUserDetailsException {
        Assertions.assertTrue(obj.validateMobileNO("91 1234567890"));
    }

    @Test
    void invalidMobileThrowsException() {
        Assertions.assertThrows(InvalidUserDetailsException.class,
                () -> obj.validateMobileNO("8883606478"));
    }

    @Test
    void validPasswordReturnsTrue() throws InvalidUserDetailsException {
        Assertions.assertTrue(obj.validatePassword("Afdgg@1hfujf"));
    }

    @Test
    void invalidPasswordThrowsException() {
        Assertions.assertThrows(InvalidUserDetailsException.class,
                () -> obj.validatePassword("abc@123"));
    }
}
