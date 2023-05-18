package com.camfinances.api.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.camfinances.api.model.Transaction;
import com.camfinances.api.repository.TransactionRepository;

import lombok.Data;

@Data
@Service
public class TransactionService {
    
    @Autowired
	private TransactionRepository transactionRepository;
	
	public Optional<Transaction> getTransaction(final Long id) {
		return transactionRepository.findById(id);
	}
	
	public Iterable<Transaction> getTransactions() {
		return transactionRepository.findAll();
	}
	
	public void deleteTransaction(final Long id) {
		transactionRepository.deleteById(id);
	}
	
	public Transaction saveTransaction(Transaction transaction) {
		Transaction savedTransaction = transactionRepository.save(transaction);
		return savedTransaction;
	}


}
