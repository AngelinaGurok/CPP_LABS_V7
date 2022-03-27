package com.example.labs.controller;

import com.example.labs.cache.Cache;
import com.example.labs.calculations.Parametres;
import com.example.labs.calculations.Solution;
import com.example.labs.exceptions.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculationController {
    void Validation(Integer a, Integer b, String option) {
        String error = "";
        if (a < 0 || b < 0) {
            throw new BadRequestException("Wrong data! Parameter A and B");
        }
        if (a < 0) {
            throw new BadRequestException("Wrong data! Parameter A");
        }
        if (b < 0) {
            throw new BadRequestException("Wrong data! Parameter B");
        }
        if (!((option.equals("s") || (option.equals("m"))))) {
            throw new BadRequestException("Wrong data! Parameter Operation");
        }
    }

    @GetMapping(value = "/labs")
    public ResponseEntity<Object> calc(@RequestParam(value = "a", defaultValue = "1") Integer a,
                                       @RequestParam(value = "b", defaultValue = "3") Integer b,
                                       @RequestParam(value = "operation", defaultValue = "s") String operation) throws BadRequestException {


        int res = 0;

        Validation(a, b, operation);

        var solution = new Solution(new Parametres(a, b, operation));
        solution.calculateRoot();

        return new ResponseEntity<>(solution.getRoot(), HttpStatus.OK);
    }

    @GetMapping(value = "/cache")
    public ResponseEntity<String> printCache() {
        return new ResponseEntity<>(Cache.getStaticStringCache(), HttpStatus.OK);
    }
}
