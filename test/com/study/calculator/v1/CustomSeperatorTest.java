package com.study.calculator.v1;

import com.study.calculator.v1.CustomSeperator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CustomSeperatorTest {

    private CustomSeperator customSeperator;
    @BeforeEach
    void init() {
        customSeperator = new CustomSeperator();
    }

    @Test
    @DisplayName("커스텀 구분자가 존재하는 경우")
    void getSeperator1() {
        //given
        String test = "//|\n1|3|5";
        //when
        String seperator = customSeperator.getSeperator(test);
        //then
        Assertions.assertEquals(seperator, "|");
    }

    @Test
    @DisplayName("커스텀 구분자가 존재하지 않는 경우")
    void getSeperator2(){
        //given
        String test = "1,3;5";
        //when
        String seperator = customSeperator.getSeperator(test);
        //then
        Assertions.assertEquals(seperator, ",:");
    }
    
    @Test
    void matcherTest(){
        String text = "//|\n1|5|6";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()) {
            String customDelimeter = m.group(1);
            System.out.println("customDelimeter = " + customDelimeter);
            String[] tokens = m.group(2).split(customDelimeter);

        }
    }
}