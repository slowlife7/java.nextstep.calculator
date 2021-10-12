package com.study.calculator.v1;

import com.study.calculator.v1.Calculator;
import com.study.calculator.v1.CustomSeperator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    /**
     * 요구사항
     * 문자열 계산기의 요구사항은 전달하는 문자를 구분자로 분리한 후 각 숫자의 합을 구해 반환해야 한다.
     * 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한다.
     * 각 숫자의 합을 반환한다.
     * (예 "" => 0, "1,2" => 3, "1,2,3" => 6,"1,2:3" => 6
     * 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열
     * 앞부분의 "//"와 "\n"사이에 위치하는 문자를 커스텀 구분자로 사용한다.
     * 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환된다.
     * 문자열 계산기에 음수를 전달하는 경우 RuntimeException으로 예외 처리해야한다.
     *
     */

    /**
     *
     * 1.커스텀 구분자 구하기
     * 1.1커스텀 구분자로 문자열 분리
     * 2. 분리된 문자열이 음수인 경우 RuntimeException 예외 발생
     * 3. 문자열의 합 계산
     */

    private Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator(new CustomSeperator());
    }

    @Test
    @DisplayName("음수가 존재하는 경우 RuntimeException 발생")
    void add1() {
        Assertions.assertThrows(RuntimeException.class, () ->{
            calculator.add("-1:5,3");
        });
    }

    @Test
    @DisplayName("양수가 아닌 경우 NumberFormatException 발생")
    void add2(){
        Assertions.assertThrows(NumberFormatException.class, () ->{
            calculator.add("-ㅁ:5,3");
        });
    }

    @Test
    @DisplayName("합 구하기 => 커스텀 구분자가 존재 O")
    void add3(){
        String input = "//|\n1|5|6";
        Assertions.assertEquals(12, calculator.add(input));

        String input2 = "//;\n1;5;5";
        Assertions.assertEquals(11, calculator.add(input2));
    }

    @Test
    @DisplayName("합 구하기 => 커스텀 구분자 존재 X")
    void add4(){
        String input = "1,5:7";
        Assertions.assertEquals(13, calculator.add(input));
    }

    @Test
    @DisplayName("공백 입력시 0")
    void add5(){

        Assertions.assertEquals(0, calculator.add(""));
    }

}