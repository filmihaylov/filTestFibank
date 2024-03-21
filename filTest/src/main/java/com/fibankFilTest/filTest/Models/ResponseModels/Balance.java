package com.fibankFilTest.filTest.Models.ResponseModels;

import com.fibankFilTest.filTest.Models.CashOperation;
import com.fibankFilTest.filTest.Models.CashierUser;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
public class Balance {

    Double Amount;
    String Currency;
    Integer Denomination10;
    Integer Denomination20;
    Integer Denomination50;
}
