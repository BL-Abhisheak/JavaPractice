package com.regex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class Regex1Test {

    @Test
    public void firstNameWhenCrctReturnTrue(){
        Regex1 reg = new Regex1();
        boolean result = reg.validFirstName("abhisheak");
        Assertions.assertEquals(false, result);

    }

    @Test
    public void lastNaameIsValidOrNot(){
        Regex1 reg = new Regex1();
        boolean result = reg.validateLastName("Baskaran");
        Assertions.assertEquals(true,result);
    }

    @Test
    public void using2DotsContinuousForEmailReturnsFalse(){
        Regex1 reg = new Regex1();
        boolean result = reg.validateEmail("abh..@gmail.co.in");
        Assertions.assertEquals(false, result);
    }


    @Test
    public void mobilenumberWithoutCountryCodeReturnsFalse(){
        Regex1 reg = new Regex1();
        boolean result = reg.validateMobile("1234567890");
        Assertions.assertEquals(false, result);
    }

    @Test
    public void mobilenumberWithoutSpaceCodeReturnsFalse(){
        Regex1 reg = new Regex1();
        boolean result = reg.validateMobile("911234567890");
        Assertions.assertEquals(false, result);
    }


    @Test
    public void passwordWithoutUpperCaseReturnsFalse(){
        Regex1 reg = new Regex1();
        boolean result = reg.validatePassword("nsdfgjdg@1dfdjg5432564");
        Assertions.assertEquals(false, result);
    }


    @Test
    public void passwordWithMoreThan1SpecialCharacterReturnsFalse(){
        Regex1 reg = new Regex1();
        boolean result = reg.validatePassword("nsdfgjdg@1dfd@jg5432564");
        Assertions.assertEquals(false, result);
    }


    @Test
    public void passwordWithoutNumbersReturnsFalse(){
        Regex1 reg = new Regex1();
        boolean result = reg.validatePassword("kdfgvzhjsdfh@shdgvbsfjedhAA");
        Assertions.assertEquals(false, result);
    }


    @Test
    public void passwordWithLessThan8CharactersReturnsFalse(){
        Regex1 reg = new Regex1();
        boolean result = reg.validatePassword("Afhr1@r");
        Assertions.assertEquals(false, result);
    }

    @Test
    public void validPasswordReturnsTrue(){
        Regex1 reg = new Regex1();
        boolean result = reg.validatePassword("Afhr1@rAA");
        Assertions.assertEquals(true, result);
    }

}