package com.regex;

import java.util.regex.Pattern;

public class RejexWithExceptionHandling {

    public static final String FIRSTNAME_REGEX = "^[A-Z][a-z]{2,}$";
    public static final String LASTNAME_REGEX = "^[A-Z][a-z]{2,}$";
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9]+(\\.[a-zA-Z0-9+])?@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]{2,})(\\.[a-zA-Z0-9]{2,})?$";
    public static final String MOBILENUM_REGEX = "^[0-9]{2} [0-9]{10}$";
    public static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[0-9])(?=.{8,})(?=[a-zA-Z0-9]*[^a-zA-Z0-9][a-zA-Z0-9]*$).*";


    public boolean validateFirstName(String fname) throws InvalidUserDetailsException{
        if (!Pattern.matches(FIRSTNAME_REGEX,fname)){
            throw new InvalidUserDetailsException("INVALID FIRST NAME");
        }
        return true;
    }

    public boolean validateLastName(String lname) throws InvalidUserDetailsException{
        if (!Pattern.matches(LASTNAME_REGEX,lname)){
            throw new InvalidUserDetailsException("INVALID LAST NAME");
        }
        return true;
    }


    public boolean validateEmail(String email) throws InvalidUserDetailsException{
        if (!Pattern.matches(EMAIL_REGEX,email)){
            throw new InvalidUserDetailsException("INVALID EMAIL");
        }
        return true;
    }


    public boolean validateMobileNO(String mobile) throws InvalidUserDetailsException{
        if (!Pattern.matches(MOBILENUM_REGEX,mobile)){
            throw new InvalidUserDetailsException("INVALID MOBILE NUMBER");
        }
        return true;
    }

    public boolean validatePassword(String password) throws InvalidUserDetailsException{
        if (!Pattern.matches(PASSWORD_REGEX,password)){
            throw new InvalidUserDetailsException("INVALID PASSWORD");
        }
        return true;
    }


    public static void main(String[] args) throws InvalidUserDetailsException {
        RejexWithExceptionHandling reg = new RejexWithExceptionHandling();
        System.out.println(reg.validateFirstName("Abhisheak"));
        System.out.println(reg.validateLastName("Baskaran"));
        System.out.println(reg.validateLastName("askaran"));
        System.out.println(reg.validateFirstName("fe"));
        System.out.println(reg.validateEmail("abc@gmail.co.in"));
        System.out.println(reg.validateMobileNO("8883606478"));
        System.out.println(reg.validateMobileNO("91 1234567890"));
        System.out.println(reg.validatePassword("Afdgg@1hfujf"));

    }
}
