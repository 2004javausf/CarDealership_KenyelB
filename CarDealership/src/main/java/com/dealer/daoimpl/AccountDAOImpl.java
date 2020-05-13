package com.dealer.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dealer.beans.Account;
import com.dealer.beans.Customer;
import com.dealer.dao.AccountDAO;
import com.dealer.util.ConnDatabase;

public class AccountDAOImpl implements AccountDAO {
	
	public static ConnDatabase cd = ConnDatabase.getInstance();
	
	public void insertNewAccount(int cID, String customer,  int balance, int terms, double monthlyDue)
			throws SQLException {
		Connection conn = cd.getConnection();
		String sql= "INSERT INTO NEW_ACCOUNT VALUES (ACCTSEQ.NEXTVAL,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, cID);
		ps.setString(2, customer);
		ps.setLong(3, balance);
		ps.setDouble(4, monthlyDue);
		ps.setInt(5, terms);
		ps.executeUpdate();
		
	}
	
	public List<Account>getAccount() throws SQLException{
		List<Account>getAccount= new ArrayList<Account>();
		Connection conn = cd.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM NEW_ACCOUNT");
		Account a = null;
		while (rs.next()) {
			a = new Account(rs.getInt(2),rs.getInt(1), rs.getString(3),rs.getInt(4),rs.getInt(5), rs.getDouble(6));
			getAccount.add(a);
			
		}
		return getAccount;
		
	}
	
	
	public void getCustomerAccount(Customer customer) throws SQLException {
		AccountDAOImpl acctdi = new AccountDAOImpl();
		String cus = customer.getUsername(); 
		List<Account> getAccount = acctdi.getAccount();
		Connection conn = cd.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM New_Account Where C_uname= '" + cus+"'");
	Account a;
		while(rs.next()) {	
			a = new Account(rs.getInt(2), 0, rs.getString(3),rs.getInt(4),rs.getInt(5), rs.getDouble(6));
			getAccount.add(a);
			System.out.printf("%-10s%-11s%-11s%-11s%-10s\n", "Accout #", "Car ID", "Loan Balance", "Loan Terms", "Monthly Payment");
			System.out.printf("%-11s%-11s%-11s%-11s%-10s\n", rs.getInt(1), rs.getInt(2),rs.getInt(4), rs.getInt(5), rs.getDouble(6));
		}
		return;
		
	}



}