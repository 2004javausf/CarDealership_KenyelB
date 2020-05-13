package com.dealer.dao;

import java.sql.SQLException;
import java.util.List;

import com.dealer.beans.Customer;

public interface CustomerDAO {
	

		
		public List<Customer>getcustomerList() throws SQLException;
		
		public Customer login(String user, String password) throws SQLException;

}