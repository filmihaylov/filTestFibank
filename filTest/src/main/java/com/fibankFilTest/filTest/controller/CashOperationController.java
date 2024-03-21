package com.fibankFilTest.filTest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashOperationController {

    @RequestMapping("/api/v1/cash-operation")
    public String hello()
    {
        return "Hello javaTpoint";
    }
}
