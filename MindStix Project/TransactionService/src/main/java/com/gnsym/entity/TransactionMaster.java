package com.gnsym.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class TransactionMaster {
	@Id
    @Field("_id")
	String transactionId;
	long accountId;
	String email;	
	String type;
	double amount;

	public TransactionMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public TransactionMaster(String transactionId, long accountId, String email, String type, double amount) {
		super();
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.email = email;
		this.type = type;
		this.amount = amount;
	}



	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
