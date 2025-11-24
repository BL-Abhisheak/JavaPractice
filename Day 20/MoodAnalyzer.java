package com.regex;

import java.util.regex.Pattern;

public class MoodAnalyzer {
    private static final String SAD_PATTERN = "(?i)sad";
    public String analyzeMood(String message) {
        Pattern pattern = Pattern.compile(SAD_PATTERN);
        if (pattern.matcher(message).find())
            return "sad";
        else return "happy";
    }


    public static void main(String[] args) {
        MoodAnalyzer ma = new MoodAnalyzer();
        System.out.println(ma.analyzeMood("sa"));
    }
}
