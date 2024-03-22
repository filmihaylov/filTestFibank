package com.fibankFilTest.filTest.service;

import com.fibankFilTest.filTest.Models.CashBalance;
import com.fibankFilTest.filTest.Models.CashOperation;
import com.fibankFilTest.filTest.Models.Operation;
import com.fibankFilTest.filTest.repository.CashBalanceRepository;
import com.fibankFilTest.filTest.repository.CashOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class OperationService {

    @Autowired
    CashBalanceRepository balanceRepository;

    @Autowired
    CashOperationRepository operationRepository;


    public void performOperation(CashOperation cashOperation, long balanceId){
        CashBalance balance = balanceRepository.getOne(balanceId);
        if(cashOperation.getOperation().equals(Operation.DEPOSIT.toString())){
            balance.setAmount(balance.getAmount()+cashOperation.getAmount());
            balance.setDenomination10(balance.getDenomination10()+cashOperation.getDenomination10());
            balance.setDenomination20(balance.getDenomination20()+cashOperation.getDenomination20());
            balance.setDenomination50(balance.getDenomination50()+cashOperation.getDenomination50());
        }
        if(cashOperation.getOperation().equals(Operation.WITHDRAW.toString())){
            balance.setAmount(balance.getAmount()-cashOperation.getAmount());
            balance.setDenomination10(balance.getDenomination10()-cashOperation.getDenomination10());
            balance.setDenomination20(balance.getDenomination20()-cashOperation.getDenomination20());
            balance.setDenomination50(balance.getDenomination50()-cashOperation.getDenomination50());
        }
        balanceRepository.save(balance);
        operationRepository.save(cashOperation);
    }


}
