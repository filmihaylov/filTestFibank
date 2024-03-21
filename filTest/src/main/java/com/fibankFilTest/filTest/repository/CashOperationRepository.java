package com.fibankFilTest.filTest.repository;

import com.fibankFilTest.filTest.Models.CashOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashOperationRepository extends JpaRepository<CashOperation, Long> {

}
