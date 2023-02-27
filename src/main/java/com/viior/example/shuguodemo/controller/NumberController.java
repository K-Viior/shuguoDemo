package com.viior.example.shuguodemo.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.viior.example.shuguodemo.pojo.INumber;
import com.viior.example.shuguodemo.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/number")
public class NumberController {

    @Autowired
    private NumberService numberService;
    @PostMapping("/saveNumber")
    public String saveNumber(@RequestBody INumber number) {
        return numberService.saveNumber(number);
    }

    @PostMapping("/saveNumberSlowly")
    public String saveNumberSlowly(@RequestBody INumber number) {
        return numberService.saveNumberSlowly(number);
    }
}
