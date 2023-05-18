package com.camfinances.api.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.camfinances.api.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long>{
    
}
