package com.fibankFilTest.filTest.Models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "CashierUser")
@Data
public class CashierUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    String Name;
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
    @OneToMany(mappedBy="CashierUser")
    private Set<CashBalance> CashBalance;
}
