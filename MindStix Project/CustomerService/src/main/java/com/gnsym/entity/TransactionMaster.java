package com.gnsym.entity;

public class TransactionMaster {
	long accountId;
	String type;
	double amount;

	public TransactionMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionMaster(long accountId, String type, double amount) {
		super();
		this.accountId = accountId;
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

}
