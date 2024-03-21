package com.fibankFilTest.filTest.controller;

import com.fibankFilTest.filTest.Models.CashierUser;
import com.fibankFilTest.filTest.repository.CashierUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    CashierUserRepository CashierUserRepository;
    @RequestMapping("/intDB")
    public String hello()
    {
        CashierUser user = new CashierUser();

        user.setName("Fil");

        CashierUserRepository.save(user);


        return "Hello javaTpoint";
    }

}