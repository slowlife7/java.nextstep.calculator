package com.study.calculator.v2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void init(){
        calculator = new Calculator();
    }

    @Test
    @DisplayName("문자열 입력받아 정수로 계산")
    void add_single_word(){
        assertEquals(5, calculator.add("5"));
    }

    @Test
    @DisplayName("문자열 입력 X")
    void add_no_input() {
        assertEquals(0, calculator.add(""));
        assertEquals(0, calculator.add(null));
    }

    @Test
    @DisplayName("문자열 합 구하기")
    void add_sum() {
        assertEquals(10, calculator.add("1,2,7"));
        assertEquals(11, calculator.add("1,2:8"));
        assertEquals(12, calculator.add("1:2:9"));
    }

    @Test
    @DisplayName("음수가 포함되어 있으면 Runtime Exception 발생")
    void add_runtime_exception(){
        assertThrows(RuntimeException.class, () -> {
            calculator.add("-1:5,3");
        });
    }

    @Test
    @DisplayName("커스텀 구분자가 존재 O, 해당 구분자로 add 계산")
    void add_exist_custom(){
        Assertions.assertEquals(3, calculator.split("//|\n1|5|6").length);
        Assertions.assertArrayEquals(new String[]{"1","5","6"}, calculator.split("//|\n1|5|6"));
    }
}
