package com.dealer.dao;

import java.sql.SQLException;
import java.util.List;
import com.dealer.beans.NewCustomer;

public interface NewCustomerDAO {
	
	public void insertNewCustomer(String fname, String lname, String username, String password) throws SQLException;
	

	public List<NewCustomer>getcustomerList() throws SQLException;
 public List<NewCustomer>getUser(String C_UNAME, String C_PWORD)throws SQLException;
}
