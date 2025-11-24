package com.regex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoodAnalyzerWithExceptionHandlingTest {

    MoodAnalyzerWithExceptionHandling analyzer = new MoodAnalyzerWithExceptionHandling();

    @Test
    void givenMessage_WhenContainsSad_ShouldReturnSad() throws InvalidUserDetailsException {
        String result = analyzer.analyzeMood("I am sad today");
        Assertions.assertEquals("SAD", result);
    }

    @Test
    void givenMessage_WhenContainsHappy_ShouldReturnHappy() throws InvalidUserDetailsException {
        String result = analyzer.analyzeMood("I am a happy person");
        Assertions.assertEquals("HAPPY", result);
    }

    @Test
    void givenMessage_WhenContainsNeitherSadNorHappy_ShouldThrowException() {
        Assertions.assertThrows(
                InvalidUserDetailsException.class,
                () -> analyzer.analyzeMood("I am a human")
        );
    }

    @Test
    void givenNullMessage_ShouldThrowException() {
        Assertions.assertThrows(
                InvalidUserDetailsException.class,
                () -> analyzer.analyzeMood(null)
        );
    }

    @Test
    void givenEmptyMessage_ShouldThrowException() {
        Assertions.assertThrows(
                InvalidUserDetailsException.class,
                () -> analyzer.analyzeMood("   ")
        );
    }

}