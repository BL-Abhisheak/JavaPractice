package com.regex;

import java.util.regex.Pattern;

public class Regex2 {
    public static boolean validateEmail(String email){
    String regex = "^[A-Za-z0-9]+([._+-]?[A-Za-z0-9]+)*@[A-Za-z0-9]+\\.[A-Za-z]{2,}+$";

    return Pattern.matches(regex,email);
    }

    public static void main(String[] args) {

        String[] validEmails = {
                "abc@yahoo.com",
                "abc-100@yahoo.com",
                "abc.100@yahoo.com",
                "abc111@abc.com",
                "abc-100@abc.net",
                "abc.100@abc.com.au",
                "abc+100@gmail.com"
        };

        String[] invalidEmails = {
                "abc",                     // No @
                "abc@.com.my",             // TLD cannot start with dot
                "abc123@gmail.a",          // .a invalid TLD
                "abc123@.com",             // Domain cannot start with dot
                "abc123@.com.com",         // Domain cannot start with dot
                ".abc@abc.com",            // Cannot start with dot
                "abc()*@gmail.com",        // Invalid characters
                "abc@%*.com",              // Invalid domain characters
                "abc..2002@gmail.com",     // Double dots
                "abc.@gmail.com",          // Cannot end with dot
                "abc@abc@gmail.com",       // Double @
                "abc@gmail.com.1a",        // Digits in TLD
                "abc@gmail.com.aa.au"      // Multiple TLDs not allowed
        };

        System.out.println("----- VALID EMAIL TESTS -----");
        for (String email : validEmails) {
            System.out.println(email + " → " + validateEmail(email));
        }

        System.out.println("\n----- INVALID EMAIL TESTS -----");
        for (String email : invalidEmails) {
            System.out.println(email + " → " + validateEmail(email));
        }

    }
}
