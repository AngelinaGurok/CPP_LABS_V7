package com.example.labs;

import com.example.labs.controller.CalculationController;
import com.example.labs.exceptions.BadRequestException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LabsApplicationTests {

    private final CalculationController TestCalcController = new CalculationController();

    @Test
    void testMultiply() throws BadRequestException {
        int result = TestCalcController.calc("5", "12", "m");
        int expected = 60;
        assertEquals(expected, result);
    }

    @Test
    void testSum() throws BadRequestException {
        int result = TestCalcController.calc("15", "6", "s");
        int expected = 21;
        assertEquals(expected, result);
    }

    @Test
    void testSumBelowZero() throws BadRequestException {
        int result = TestCalcController.calc("-14","5", "s");
        int expected = -9;
        assertEquals(expected,result);
    }

    @Test
    void testMultiplyBelowZero() throws BadRequestException {
        int result = TestCalcController.calc("-3","-5", "m");
        int expected = 15;
        assertEquals(expected,result);
    }
}
