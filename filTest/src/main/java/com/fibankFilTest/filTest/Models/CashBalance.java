package com.fibankFilTest.filTest.Models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CashBalance")
@Data
public class CashBalance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Override
    public int hashCode() {
        return (int)id * 12345;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof CashBalance) {
            if (((CashBalance) obj).getId() == getId()) {
                return true;
            }
        }

        return false;
    }

    @ManyToOne
    @JoinColumn(name="CashierUser_id", nullable=false)
    private CashierUser CashierUser;

    Double Amount;
    String Currency;
    Integer Denomination10;
    Integer Denomination20;
    Integer Denomination50;
}
