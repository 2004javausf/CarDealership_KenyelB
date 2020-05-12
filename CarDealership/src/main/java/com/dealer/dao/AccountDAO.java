package com.dealer.dao;

import java.sql.SQLException;
import java.util.List;

import com.dealer.beans.Account;
import com.dealer.beans.NewCustomer;


public interface AccountDAO {
	
	public void insertNewAccount(int cID, String username, int balance, int terms , double monthlyDue)throws SQLException;
	
	public List<Account>getaccountList()throws SQLException;

	public List<Account> getaccountList(String C_UNAME) throws SQLException;
	
	public List<Account> getCustomerAccount(String customer)throws SQLException;
	public List<Account> getCustomerAccount2()throws SQLException;
}
