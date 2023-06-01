package com.usama.junit_demo.bank;

public class BankAccount {

	private double balance;
	private double minBalance;
	private boolean isActive = true;
	private String holderName;

	public BankAccount() {
		super();
	}

	public BankAccount(double balance, double minBalance) {
		super();
		this.balance = balance;
		this.minBalance = minBalance;
	}

	public double getBalance() {
		return balance;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public double withdraw(double amount) {

		if (balance < minBalance + amount)
			throw new RuntimeException("Not Enough Money");
		this.balance -= amount;
		return balance;

	}

	public double deposit(double amount) {
		return balance += amount;
	}

}
