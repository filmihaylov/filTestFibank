package com.fibankFilTest.filTest.Models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "CashOperation")
@Data
public class CashOperation implements Serializable {
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

    Double Amount;
    String Currency;
    String Operation;
    Integer Denomination10;
    Integer Denomination20;
    Integer Denomination50;
}
