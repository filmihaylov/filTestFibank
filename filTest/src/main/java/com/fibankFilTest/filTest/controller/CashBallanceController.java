package com.fibankFilTest.filTest.controller;

import com.fibankFilTest.filTest.Models.CashBalance;
import com.fibankFilTest.filTest.Models.ResponseModels.Balance;
import com.fibankFilTest.filTest.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class CashBallanceController {

    @Autowired
    BalanceService balanceService;
    @RequestMapping(value = "/api/v1/cash-balance/{user_id}", method = RequestMethod.GET)
    public ResponseEntity<List<Balance>> get(@PathVariable("user_id") Integer user_id)
    {
        List<Balance> balanceList = new ArrayList<>();
        Set<CashBalance> balance = balanceService.getCurrentBalance(user_id).stream().collect(Collectors.toSet());
        if (null == balance) {
            return new ResponseEntity<List<Balance>>(HttpStatus.NOT_FOUND);
        }

        for (CashBalance bal : balance){
            Balance balanceResponse = new Balance();

            balanceResponse.setAmount(bal.getAmount());
            balanceResponse.setCurrency(bal.getCurrency());
            balanceResponse.setDenomination10(bal.getDenomination10());
            balanceResponse.setDenomination20(bal.getDenomination20());
            balanceResponse.setDenomination50(bal.getDenomination50());
            balanceList.add(balanceResponse);
        }


        return new ResponseEntity<List<Balance>>(balanceList, HttpStatus.OK);

    }
}
