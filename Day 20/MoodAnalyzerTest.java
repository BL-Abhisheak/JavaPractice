package com.regex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoodAnalyzerTest {

    @Test
    public void givenMessageWhenSadShouldReturnSad() {
        MoodAnalyzer analyzer = new MoodAnalyzer();
        String mood = analyzer.analyzeMood("This is just sad");
        Assertions.assertEquals("sad", mood);
    }

    @Test
    public void givenMessageWhenNotSadShouldReturnHappy() {
        MoodAnalyzer analyzer = new MoodAnalyzer();
        String mood = analyzer.analyzeMood("I'm happy");
        Assertions.assertEquals("happy", mood);
    }

}