package com.fibankFilTest.filTest.service;

import com.fibankFilTest.filTest.Models.CashBalance;
import com.fibankFilTest.filTest.repository.CashBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {

    @Autowired
    CashBalanceRepository balanceRepository;

    public CashBalance getCurrentBalance(int id){
       return balanceRepository.getOne((long)id);
    }
}
