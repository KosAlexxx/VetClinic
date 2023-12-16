package main.java.com.magicvet.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private final static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private final static String FIRST_NAME_PATTERN = "^[A-zА-я]{1,}[- ]?[A-zА-я]{2,}$";
    private final static String LAST_NAME_PATTERN = "^[A-zА-я]{1,}[- ]?[A-zА-я]{2,}$";

    public static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isFirstNameValid(String firstName){
        Pattern pattern = Pattern.compile(FIRST_NAME_PATTERN);
        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();
    }

    public static boolean isLastNameValid(String lastName){
        Pattern pattern = Pattern.compile(LAST_NAME_PATTERN);
        Matcher matcher = pattern.matcher(lastName);
        return matcher.matches();
    }

}
