package com.fibankFilTest.filTest.Models.RequestModels;

import com.fibankFilTest.filTest.Models.Currency;
import com.fibankFilTest.filTest.Models.Operation;
import lombok.Data;

@Data
public class CashOperation {
    Operation operation;
    double  amount;
    Currency currency;
    int  denomination10;
    int  denomination20;
    int  denomination50;
    int  balanceId;
}
