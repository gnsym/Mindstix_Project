package com.gnsym.entity;

public class Customer {
	
	long accountId;
	double balance=0;
	String name;
	String fatherName;
	String motherName;
	int age;
	String gender;
	String address;
	String email;
	long phoneNumber;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Customer(long accountId, double balance, String name, String fatherName, String motherName, int age,
			String gender, String address, String email, long phoneNumber) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.name = name;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}


	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}

}
