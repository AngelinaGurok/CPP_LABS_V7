package com.example.labs.controller;

import com.example.labs.exceptions.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculationController {
    void Validation(String a, String b, String option){
       String error = "";
       if(!(a.matches("((-|\\\\+)?[0-9])+"))){
           error+="Operator a must be integer!\n";
       }
       if(!(b.matches("((-|\\\\+)?[0-9])+"))){
           error+="Operator b must be integer!\n";
       }
       if(!((option.equals("s") || (option.equals("m"))))){
           error+="Operation must be m for multiply or s for sum!\n";
       }
       if(!(error.equals(""))) {
           throw new BadRequestException(error);
       }
    }
    @GetMapping(value = "/labs")
    public int calc(@RequestParam(value = "a", defaultValue = "1") String a,
                    @RequestParam(value = "b", defaultValue = "3") String b,
                    @RequestParam(value = "operation", defaultValue = "s") String operation) throws BadRequestException {

        int A = 0;
        int B = 0;
        int res = 0;

        Validation(a, b, operation);

        A = Integer.parseInt(a);
        B = Integer.parseInt(b);

        if(operation.equals("s")){
            res = A + B;
        }
        else if (operation.equals("m")) {
            res = A * B;
        }
        return res;
    }
}
