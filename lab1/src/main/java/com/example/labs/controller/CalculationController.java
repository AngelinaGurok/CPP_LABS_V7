package com.example.labs.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculationController {
    @GetMapping(value = "/labs")
    public int calc(@RequestParam(value = "a", defaultValue = "1") String a,
                    @RequestParam(value = "b", defaultValue = "3") String b,
                    @RequestParam(value = "operation", defaultValue = "s") String operation) {

        int A = 0;
        int B = 0;
        int res = 0;

        if (a.matches("((-|\\\\+)?[0-9])+") && b.matches("((-|\\\\+)?[0-9])+")) {
            A = Integer.parseInt(a);
            B = Integer.parseInt(b);
        }

        if (operation.equals("s")) {
            res = A + B;
        } else if (operation.equals("m")) {
            res = A * B;
        }
        return res;
    }
}
