package com.regex;

import java.util.regex.Pattern;

public class Regex1 {

    //Starts with capital and minimum 3 characters
    public boolean  validFirstName(String firstName){
        String regex = "^[A-Z][a-z]{2,}$";
        return Pattern.matches(regex,firstName);
    }


    public boolean validateLastName(String lastName){
        String regex = "^[A-Z][a-z]{2,}$";
        return Pattern.matches(regex,lastName);
    }

    public boolean validateEmail(String email){
        String regex = "^[a-zA-Z0-9]+(\\.[a-zA-Z0-9+])?@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]{2,})(\\.[a-zA-Z0-9]{2,})?$";
        return Pattern.matches(regex,email);
    }

    public boolean validateMobile(String mobile){
        String regex = "^[0-9]{2} [0-9]{10}$";
        return Pattern.matches(regex,mobile);
    }


    // PASSWORD RULES (ALL MUST PASS)
    // Rule1 – Minimum 8 chars
    // Rule2 – At least 1 Upper Case
    // Rule3 – At least 1 Number
    // Rule4 – Exactly 1 Special Character
    public boolean validatePassword(String password){
        String regex = "^(?=. *[A-Z])(?=.[0-9])(?=.{8,})(?=[a-zA-Z0-9]*[^a-zA-Z0-9][a-zA-Z0-9]*$).*";
        return Pattern.matches(regex,password);
    }

    public static void main(String[] args) {
        Regex1 reg = new Regex1();
        System.out.println(reg.validFirstName("Abhisheak"));
        System.out.println(reg.validateLastName("Baskaran"));
        System.out.println(reg.validateLastName("askaran"));
        System.out.println(reg.validFirstName("fe"));
        System.out.println(reg.validateEmail("abc@gmail.co.in"));
        System.out.println(reg.validateMobile("8883606478"));
        System.out.println(reg.validateMobile("91 1234567890"));
        System.out.println(reg.validatePassword("Afdgg@1hfujf"));

    }
}
