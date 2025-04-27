package com.spring.jpa.repositorie;

import com.spring.jpa.entitie.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateTransactionDetailsRepo extends JpaRepository<TransactionDetails, Integer> {
}
