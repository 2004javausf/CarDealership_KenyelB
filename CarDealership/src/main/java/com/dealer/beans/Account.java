package com.dealer.beans;

public class Account {
	String username;
	int cID;
	int accountNum;
	int balance;
	double monthlyDue;
	int terms;
	
	public Account() {
		super();
	
	}
	public Account( int cID, int accountNum, String username, int balance, int terms, double monthlyDue) {
		super();
		this.cID = cID;
		this.username = username;
		this.accountNum = accountNum;
		this.balance = balance;
		this.monthlyDue = monthlyDue;
		this.terms = terms;
	}



	public int getcID() {
		return cID;
	}
	public void setcID(int cID) {
		this.cID = cID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public double getMonthlyDue() {
		return monthlyDue;
	}
	public void setMonthlyDue(double monthlyDue) {
		this.monthlyDue = monthlyDue;
	}
	public int getTerms() {
		return terms;
	}
	public void setTerms(int terms) {
		this.terms = terms;
	}
	@Override
	public String toString() {
		return "Account [username=" + username + ", cID=" + cID + ", accountNum=" + accountNum + ", balance=" + balance
				+ ", monthlyDue=" + monthlyDue + ", terms=" + terms + "]";
	}
	
	
}
