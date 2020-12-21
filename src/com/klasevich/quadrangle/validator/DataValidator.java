package com.klasevich.quadrangle.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {
    private static final String DATA_QUADRANGLE_REGEX = "(-?\\d{1,5}+(\\.\\d{0,5})?\\s){7}-?\\d{1,5}+(\\.\\d{0,5})?";

    public static boolean isCorrectLine(String line) {
        Pattern pattern = Pattern.compile(DATA_QUADRANGLE_REGEX);
        Matcher matcher = pattern.matcher(line);
        boolean result = matcher.matches();
        return matcher.matches();
    }
}
