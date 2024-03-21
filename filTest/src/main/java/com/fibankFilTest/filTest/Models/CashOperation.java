package com.fibankFilTest.filTest.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "CashOperation")
@Data
public class CashOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name="CashBalance_id", nullable=false)
    private CashBalance CashBalance;

    Double Amount;
    String Currency;
    String Operation;
    Integer Denomination10;
    Integer Denomination20;
    Integer Denomination50;
}
