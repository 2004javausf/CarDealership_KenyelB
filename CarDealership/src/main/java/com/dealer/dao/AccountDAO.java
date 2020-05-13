package com.dealer.dao;

import java.sql.SQLException;
import java.util.List;

import com.dealer.beans.Account;
import com.dealer.beans.Customer;

public interface AccountDAO {
	
	public void insertNewAccount(int cID, String username, int balance, int terms , double monthlyDue)throws SQLException;
	
//	public List<Account> getCustomerAccount(Customer customer)throws SQLException;
	public List<Account>getAccount() throws SQLException;
	
	public void getCustomerAccount (Customer customer) throws SQLException;
}

