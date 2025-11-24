package com.regex;

import jdk.dynalink.beans.StaticClass;

import java.sql.SQLOutput;
import java.sql.Statement;
import java.util.regex.Pattern;

public class MoodAnalyzerWithExceptionHandling {
    private static final String SAD_PATTERN = "(?i)sad";
    private static final String HAPPY_PATTERN = "(?i)happy";

    public String analyzeMood(String message) throws InvalidUserDetailsException{

        if (message == null || message.trim().isEmpty()) {
            throw new InvalidUserDetailsException("Message cannot be null or empty");
        }

        Pattern sad = Pattern.compile(SAD_PATTERN);
        Pattern happy = Pattern.compile(HAPPY_PATTERN);

        if (sad.matcher(message).find())
           return "SAD";
        else if (happy.matcher(message).find()) {
            return "HAPPY";
        } else {
            throw new InvalidUserDetailsException("Enter a valid string which contains 'HAPPY' or 'SAD' word");
        }
    }


    public static void main(String[] args) throws InvalidUserDetailsException {
        MoodAnalyzerWithExceptionHandling ma = new MoodAnalyzerWithExceptionHandling();
       // System.out.println(ma.analyzeMood("I am a human"));
        System.out.println(ma.analyzeMood("I am a happy person"));
        System.out.println(ma.analyzeMood("I am sad"));

    }
}
