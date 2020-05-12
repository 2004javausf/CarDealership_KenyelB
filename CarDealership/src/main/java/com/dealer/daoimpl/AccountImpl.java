package com.dealer.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dealer.beans.Account;
import com.dealer.beans.NewCustomer;
import com.dealer.dao.AccountDAO;
import com.dealer.util.ConnDatabase;

public class AccountImpl implements AccountDAO {
	static 	NewCustomerDAOImpl cdi = new NewCustomerDAOImpl();


	
	public static ConnDatabase cd = ConnDatabase.getInstance();

	@Override
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

//	public static void getCustomerAccount() {
//		
//		Connection conn = cd.getConnection();
//		Statement stmt = conn.createStatement();
//		ResultSet rs = stmt.executeQuery("SELECT * FROM OFFER");
//		
//		
//	}
	
	public void getCustomerAccount2(String customer) throws SQLException {
		List<Account> getCustomerAccount2 = new ArrayList<Account>();
		Connection conn = cd.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * "
				+ "FROM NEW_ACCOUNT "
				+ "INNER JOIN CAR_TYPE "
				+ "ON C_UNAME = '" + customer +"' AND CAR_TYPE_ID = C_ID");
		
		Account a = null;
		while(rs.next()) {	
			a= new Account (rs.getInt(3), rs.getInt(4), rs.getInt(5),rs.getInt(6), rs.getString(8),rs.getString(9), rs.getString(10));
			getCustomerAccount2.add(a);
			System.out.println(getCustomerAccount2);
		}		
		
	}
	
//	public List<Account> getCustomerAccount(String customer) throws SQLException{
//		List<Account> getCustomerAccount = new ArrayList<Account>();
//		Connection conn = cd.getConnection();
//		Statement stmt = conn.createStatement();
//		ResultSet rs = stmt.executeQuery("SELECT * "
//				+ "FROM NEW_ACCOUNT "
//				+ "INNER JOIN CAR_TYPE "
//				+ "ON C_UNAME = '" + customer +"' AND CAR_TYPE_ID = C_ID");	
//		while(rs.next()) {			
//			System.out.printf("%-8s%-10s%-11s%-11s%-11s%-11s%-10s\n", rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getInt(4), rs.getString(5));
//		}
//		return customer;
//	}



	@Override
	public List<Account> getaccountList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getaccountList(String C_UNAME) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getCustomerAccount(String customer) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getCustomerAccount2() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
//	@Override
//	public List<Account> getaccountList(String C_UNAME) throws SQLException {
//		 List<Account> getaccountList = new  ArrayList<Account>;
//		Connection conn = cd.getConnection();
//		Statement stmt = conn.createStatement();
//		ResultSet rs = stmt.executeQuery("SELECT * FROM OFFER");
//		while(rs.next()) {			
//			System.out.printf("%-8s%-10s%-11s%-11s%-11s%-11s%-10s\n", rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getInt(4), rs.getString(5));
//		}
//		return getofferList;
//		return null;
//	}



	
	
	

}
