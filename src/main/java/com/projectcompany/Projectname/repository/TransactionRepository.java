package com.projectcompany.Projectname.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectcompany.Projectname.model.Transaction;

@Repository("transactionrepository")
public interface TransactionRepository extends JpaRepository<Transaction, String> {
	


}
