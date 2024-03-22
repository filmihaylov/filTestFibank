package com.fibankFilTest.filTest.controller;

import com.fibankFilTest.filTest.Models.CashBalance;
import com.fibankFilTest.filTest.Models.RequestModels.CashOperation;
import com.fibankFilTest.filTest.Models.ResponseModels.Balance;
import com.fibankFilTest.filTest.service.BalanceService;
import com.fibankFilTest.filTest.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class CashOperationController {

    @Autowired
    OperationService operationService;

    @PostMapping(name = "/api/v1/cash-operation")
    public ResponseEntity post(@RequestBody CashOperation cashOperation)
    {
        try {
            com.fibankFilTest.filTest.Models.CashOperation operation = new com.fibankFilTest.filTest.Models.CashOperation();
            operation.setOperation(cashOperation.getOperation().toString());
            operation.setAmount(cashOperation.getAmount());
            operation.setCurrency(cashOperation.getCurrency().toString());
            operation.setDenomination10(cashOperation.getDenomination10());
            operation.setDenomination20(cashOperation.getDenomination20());
            operation.setDenomination50(cashOperation.getDenomination50());
            operationService.performOperation(operation, cashOperation.getBalanceId());
        }
        catch (Exception ex){
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
