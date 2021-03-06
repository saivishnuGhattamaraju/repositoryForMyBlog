package com.org.coop.retail.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.org.coop.retail.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	
	@Query(value="SELECT CONCAT(DATE_FORMAT(:actionDate, '%d%m%Y'), '/', :branchId, '/', COUNT(*)+1) AS TRAN_ID "
			+ "FROM transactions WHERE "
			+ "action_date = :actionDate and branch_id = :branchId", nativeQuery=true)
	public String getTransactionNumber(@Param("branchId")int branchId, @Param("actionDate")Date actionDate);
	
	@Query(value="SELECT CONCAT(:branchId, '/', COUNT(*)) AS BILL_NO "
			+ "FROM transactions WHERE "
			+ "purpose = :purpose and branch_id = :branchId", nativeQuery=true)
	public String getBillNumber(@Param("branchId")int branchId, @Param("purpose")String purpose);
}
