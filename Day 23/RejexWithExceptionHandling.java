package com.regex;

import java.util.regex.Pattern;

public class RejexWithExceptionHandling {

    public static final String FIRSTNAME_REGEX = "^[A-Z][A-Za-z]{2,}$";
    public static final String LASTNAME_REGEX = "^[A-Z][A-Za-z]{2,}$";

    //public static final String EMAIL_REGEX = "^[a-zA-Z0-9]+(\\.[a-zA-Z0-9+])?@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]{2,})(\\.[a-zA-Z0-9]{2,})?$";
      public static final String EMAIL_REGEX = "^[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)?@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$";

    public static final String MOBILENUM_REGEX = "^[0-9]{2} [0-9]{10}$";

    //public static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[0-9])(?=.{8,})(?=[a-zA-Z0-9]*[^a-zA-Z0-9][a-zA-Z0-9]*$).*";
      public static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[0-9])(?=^[A-Za-z0-9]*[^A-Za-z0-9][A-Za-z0-9]*$).{8,}$";





    public boolean validateFirstName(String fname) throws InvalidUserDetailsException{

        if (fname==null || fname.isBlank()){
            throw new InvalidUserDetailsException("First name cannot be empty!!!");
        }

        fname = fname.trim();
        if (!Pattern.matches(FIRSTNAME_REGEX,fname)){
            throw new InvalidUserDetailsException("INVALID FIRST NAME");
        }
        return true;
    }

    public boolean validateLastName(String lname) throws InvalidUserDetailsException{
        if (lname==null || lname.isBlank()){
            throw new InvalidUserDetailsException("Last name cannot be empty!!!");
        }
        lname=lname.trim();

        if (!Pattern.matches(LASTNAME_REGEX,lname)){
            throw new InvalidUserDetailsException("INVALID LAST NAME");
        }
        return true;
    }


    public boolean validateEmail(String email) throws InvalidUserDetailsException{

        if (email == null || email.isBlank()) {
            throw new InvalidUserDetailsException("EMAIL CANNOT BE NULL OR EMPTY");
        }
        email = email.trim();

        if (!Pattern.matches(EMAIL_REGEX,email)){
            throw new InvalidUserDetailsException("INVALID EMAIL");
        }
        return true;
    }


    public boolean validateMobileNO(String mobile) throws InvalidUserDetailsException{

        if (mobile == null || mobile.isBlank()) {
            throw new InvalidUserDetailsException("MOBILE NUMBER CANNOT BE NULL OR EMPTY");
        }
        mobile = mobile.trim();


        if (!Pattern.matches(MOBILENUM_REGEX,mobile)){
            throw new InvalidUserDetailsException("INVALID MOBILE NUMBER");
        }
        return true;
    }

    public boolean validatePassword(String password) throws InvalidUserDetailsException{

        if (password == null || password.isBlank()) {
            throw new InvalidUserDetailsException("PASSWORD CANNOT BE NULL OR EMPTY");
        }
        password = password.trim();


        if (!Pattern.matches(PASSWORD_REGEX,password)){
            throw new InvalidUserDetailsException("INVALID PASSWORD");
        }
        return true;
    }



    UserValidator createValidator(String regex, String errormsg){
        return (input) ->{
            if (input==null||input.isBlank()) throw new InvalidUserDetailsException(errormsg);
            input = input.trim();
            if (!Pattern.matches(regex,input)) throw new InvalidUserDetailsException(errormsg);
            return true;
        };
    }


    UserValidator firstNameValidator = createValidator(FIRSTNAME_REGEX, "INVALID FIRST NAME");
    UserValidator lastNameValidator = createValidator(LASTNAME_REGEX, "INVALID LAST NAME");
    UserValidator emailValidator = createValidator(EMAIL_REGEX, "INVALID EMAIL");
    UserValidator mobileNumberValidator = createValidator(MOBILENUM_REGEX, "INVALID MOBILE NUMBER");
    UserValidator passwordValidator = createValidator(PASSWORD_REGEX, "INVALID PASSWORD");

    public static void main(String[] args) {
        RejexWithExceptionHandling reg = new RejexWithExceptionHandling();

        // --- FIRST NAME TESTS ---
        try {
            System.out.println("First Name valid: " + reg.firstNameValidator.validate("Abhisheak"));
            System.out.println("First Name invalid: " + reg.firstNameValidator.validate("ab"));
        } catch (InvalidUserDetailsException e) {
            System.out.println(e.getMessage());
        }

        // --- LAST NAME TESTS ---
        try {
            System.out.println("Last Name valid: " + reg.lastNameValidator.validate("Baskaran"));
            System.out.println("Last Name invalid: " + reg.lastNameValidator.validate("ba"));
        } catch (InvalidUserDetailsException e) {
            System.out.println(e.getMessage());
        }

        // --- EMAIL TESTS ---
        try {
            System.out.println("Email valid: " + reg.emailValidator.validate("abc.xyz@bl.co.in"));
            System.out.println("Email invalid: " + reg.emailValidator.validate("abc@.com"));
        } catch (InvalidUserDetailsException e) {
            System.out.println(e.getMessage());
        }

        // --- MOBILE NUMBER TESTS ---
        try {
            System.out.println("Mobile valid: " + reg.mobileNumberValidator.validate("91 9876543210"));
            System.out.println("Mobile invalid: " + reg.mobileNumberValidator.validate("1234567890"));
        } catch (InvalidUserDetailsException e) {
            System.out.println(e.getMessage());
        }

        // --- PASSWORD TESTS ---
        try {
            System.out.println("Password valid: " + reg.passwordValidator.validate("Abcdef1@"));
            System.out.println("Password invalid: " + reg.passwordValidator.validate("abcdef1@"));
            System.out.println("Password invalid: " + reg.passwordValidator.validate("Abcdefgh"));
            System.out.println("Password invalid: " + reg.passwordValidator.validate("Abcdef12@@"));
        } catch (InvalidUserDetailsException e) {
            System.out.println(e.getMessage());
        }
    }

}
