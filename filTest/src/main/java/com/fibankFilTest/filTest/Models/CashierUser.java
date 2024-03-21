package com.fibankFilTest.filTest.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CashierUser")
@Data
public class CashierUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    String Name;

    @OneToMany(mappedBy="CashierUser")
    private Set<CashBalance> CashBalance;
}
