package com.study.calculator.v2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public int add(String text) {

        if(isBlank(text)) {
            return 0;
        }
        String[] arr = split(text);
        return toSum(arr);
    }

    private int toSum(String[] arr) {
        int sum = 0;
        for( String s : arr) {
            sum += toPositive(s);
        }
        return sum;
    }

    private int toPositive(String s) {
        int result = Integer.parseInt(s);
        if(result < 0) {
            throw new RuntimeException();
        }
        return result;
    }

    private boolean isBlank(String text) {
        return text == null || text.equals("");
    }

    public String[] split(String text) {

        String delimeter = "[,:]";
        String targetText = text;

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(targetText);
        if(matcher.find()) {
            delimeter = "["+matcher.group(1)+"]";
            targetText = matcher.group(2);
        }
        return targetText.split(delimeter);
    }
}
