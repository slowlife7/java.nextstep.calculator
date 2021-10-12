package com.study.calculator.v1;

public class CustomSeperator {

    private String defaultSeperator = ",:";
    private String regExp = "//.?\n";
    private int withoutSeperator = 0;

    private boolean isCustomSeperator(String str) {
        if(str.length() > 4) {
            String includeCustomSeperator = str.substring(0, 4);
            return includeCustomSeperator.matches(regExp);
        }
        return false;
    }

    public String getSeperator(String str) {

        if(!isCustomSeperator(str)) {
            return defaultSeperator;
        }
        withoutSeperator = 4;
        return str.substring(2, 3);
    }

    public String getTarget(String str) {
        return str.substring(withoutSeperator);
    }
}
