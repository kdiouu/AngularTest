package com.projectcompany.Projectname.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectcompany.Projectname.model.Transaction;
import com.projectcompany.Projectname.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionrepository;
	
	@Transactional
	public List<Transaction> findAll(){
		return transactionrepository.findAll();
	}
	
	@Transactional
	public Optional<Transaction> findById(String name) {
		return transactionrepository.findById(name);
	}
	@Transactional
	public Transaction save(Transaction transaction) {
		return	transactionrepository.save(transaction);
	}
	
	public void delete(String pk) {
		transactionrepository.deleteById(pk);
	}
}
