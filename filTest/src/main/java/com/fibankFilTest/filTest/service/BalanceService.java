package com.fibankFilTest.filTest.service;

import com.fibankFilTest.filTest.Models.CashBalance;
import com.fibankFilTest.filTest.Models.CashierUser;
import com.fibankFilTest.filTest.repository.CashBalanceRepository;
import com.fibankFilTest.filTest.repository.CashierUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class BalanceService {
    @Autowired
    CashBalanceRepository balanceRepository;
    @Autowired
    CashierUserRepository cashierUserRepository;

    public Set<CashBalance> getCurrentBalance(int id){

        CashierUser user = cashierUserRepository.getOne((long) id);
        return user.getCashBalance();
    }

    public CashBalance getBalance(int id){
        CashBalance balance = balanceRepository.getOne((long) id);
        return balance;
    }
}
