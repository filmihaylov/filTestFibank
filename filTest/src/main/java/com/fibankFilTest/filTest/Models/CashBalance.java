package com.fibankFilTest.filTest.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CashBalance")
@Data
public class CashBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany(mappedBy="CashBalance")
    private Set<CashOperation> operations;

    @ManyToOne
    @JoinColumn(name="CashierUser_id", nullable=false)
    private CashierUser CashierUser;

    Double Amount;
    String Currency;
    Integer Denomination10;
    Integer Denomination20;
    Integer Denomination50;
}
