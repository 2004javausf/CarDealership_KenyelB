package com.dealer.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dealer.beans.NewCustomer;
import com.dealer.dao.NewCustomerDAO;
import com.dealer.menu.CustomerMenu;
import com.dealer.util.ConnDatabase;

public class NewCustomerDAOImpl implements NewCustomerDAO {
	static Scanner scan = new Scanner(System.in);
	public static ConnDatabase cd = ConnDatabase.getInstance();

	public void insertNewCustomer(String C_FNAME, String C_LNAME, String C_UNAME, String C_PWORD) throws SQLException {
		Connection conn = cd.getConnection();
		Statement stmt = conn.createStatement();
		String cusSql = "INSERT INTO NEW_CUSTOMER VALUES('" + C_FNAME + "','" + C_LNAME + "','" + C_UNAME + "','"
				+ C_PWORD + "')";
		stmt.executeUpdate(cusSql);

	};

	
	public static void payment(NewCustomer customer, int c_uname, int amount )throws SQLException{
		Connection conn = cd.getConnection();
		Statement stmt = conn.createStatement();
		String cusSql = "UPDATE NEW_ACCOUNT SET('" + amount +"') WHERE C_UNAME ('"+ customer +"') AND (";
		stmt.executeUpdate(cusSql);
		
	}
	
	public String login() throws SQLException{
		System.out.println("Please Log Into Your Account");
		System.out.println("Username:");
		String customer = scan.nextLine();
		System.out.println("Password:");
		String password = scan.nextLine();
		Connection conn = cd.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM NEW_CUSTOMER WHERE C_UNAME ='" + customer
		+ "' AND C_PWORD = '" + password+ "'");
		
		if(rs.next()==true) {
			System.out.println("WELCOME BACK " + rs.getString(1)+ " !");
			
		}else {
			System.out.println("Incorrect Username/Password.");
				}
		return customer;

	}
	
//	public static String login(String customer, String pWord) throws SQLException {
// String cus = customer;
//		Connection conn = cd.getConnection();
//		Statement stmt = conn.createStatement();
//		ResultSet rs = stmt.executeQuery("SELECT * FROM NEW_CUSTOMER WHERE C_UNAME ='" + customer
//				+ "' AND C_PWORD = '" + pWord+ "'");
//					
//		if (!rs.next()) {
//			System.out.println("Incorrect Username/Password.");
//			CustomerMenu.customerLogin2();
//				
//			}else {
//				System.out.println("WELCOME BACK " + rs.getString(1)+ " !");
//	}				CustomerMenu.customer= cus;
//		return customer;
//	}
	
	@Override
	public List<NewCustomer> getcustomerList() throws SQLException {
		List<NewCustomer> customerList = new ArrayList<NewCustomer>();

		Connection conn = cd.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM A");
		NewCustomer cus = null;
		while (rs.next()) {
			cus = new NewCustomer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			customerList.add(cus);
		}
//		
		return customerList;

	}




	@Override
	public List<NewCustomer> getUser(String C_UNAME, String C_PWORD) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}




}
