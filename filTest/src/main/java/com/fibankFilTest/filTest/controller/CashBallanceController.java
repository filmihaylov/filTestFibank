package com.fibankFilTest.filTest.controller;

import com.fibankFilTest.filTest.Models.CashBalance;
import com.fibankFilTest.filTest.Models.ResponseModels.Balance;
import com.fibankFilTest.filTest.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashBallanceController {

    @Autowired
    BalanceService balanceService;
    @RequestMapping("/api/v1/cash-balance")
    public Balance getBalance()
    {
        CashBalance balance = balanceService.getCurrentBalance(1);
        Balance balanceResponse = new Balance();
        balanceResponse.setAmount(balance.getAmount());
        balanceResponse.setCurrency(balance.getCurrency());
        balanceResponse.setDenomination10(balance.getDenomination10());
        balanceResponse.setDenomination20(balance.getDenomination20());
        balanceResponse.setDenomination50(balance.getDenomination50());

        return balanceResponse;
    }
}
