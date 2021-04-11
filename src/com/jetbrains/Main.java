package com.jetbrains;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main {
    public static void main(String[] args) throws RuntimeException {
        // wrong regex test example
        String regex = "\\";
        String text = "aaaas";

        /*
        // right regex test example
        String regex = "....s";
        String text = "aaaas";
         */

        if (matches(text, regex)) {
            System.out.println("Ok");
        } else {
            System.out.println("Fail");
        }
    }

    public static boolean matches(String text, String regex) throws RuntimeException {
        boolean result = false;
        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher regexMatcher = pattern.matcher(new RegexCharSequence(text));
            result = regexMatcher.matches();
        } catch (PatternSyntaxException e) {
            System.err.println("This string could not compile: " + e.getPattern());
            System.err.println(e.getMessage());
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}

