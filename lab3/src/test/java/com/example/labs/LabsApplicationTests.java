package com.example.labs;

import com.example.labs.calculations.Parametres;
import com.example.labs.calculations.Solution;
import com.example.labs.controller.CalculationController;
import com.example.labs.exceptions.BadRequestException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LabsApplicationTests {

    private final CalculationController TestCalcController = new CalculationController();

    @Test
    void testMultiply(){
        var solution = new Solution(new Parametres(12, 5, "m"));
        solution.calculateRoot();
        int expected = 60;
        assertEquals(expected, solution.getRoot());
    }

    @Test
    void testSum() throws BadRequestException {
        var solution = new Solution(new Parametres(11, 78, "s"));
        solution.calculateRoot();
        int expected = 89;
        assertEquals(expected, solution.getRoot());
    }
}
