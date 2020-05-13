package com.dealer.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dealer.beans.Customer;
import com.dealer.dao.CustomerDAO;
import com.dealer.menu.MainMenu;
import com.dealer.util.ConnDatabase;

	public class CustomerDAOImpl implements CustomerDAO {
		
		static Scanner scan = new Scanner(System.in);
		public static ConnDatabase cd = ConnDatabase.getInstance();
		
		public void insertCustomer(String C_FNAME, String C_LNAME, String C_UNAME, String C_PWORD) throws SQLException {
			Connection conn = cd.getConnection();
			Statement stmt = conn.createStatement();
			String cusSql = "INSERT INTO NEW_CUSTOMER VALUES('" + C_FNAME + "','" + C_LNAME + "','" + C_UNAME + "','"
					+ C_PWORD + "')";
			stmt.executeUpdate(cusSql);

		};
		
		public Customer login(String user, String password) throws SQLException{
			Customer customer =new Customer();
			try {
				Connection conn = cd.getConnection();
				String sql= "SELECT * FROM NEW_CUSTOMER WHERE C_UNAME = ? AND C_PWORD = ?";
				PreparedStatement ps=conn.prepareStatement(sql);;
				ps.setString(1, user);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()==true) {
					customer.setFname(rs.getString(1));
					customer.setLname(rs.getString(2));
					customer.setUsername(rs.getString(3));
					System.out.println("WELCOME BACK " + rs.getString(1)+ " !");
					MainMenu.customerMenu1();
				}else {
					System.out.println("Incorrect Username/Password.");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			return customer;
		}

		public Customer  login2 (String user, String pass) throws SQLException {
//			Customer customer =new Customer();
			CustomerDAOImpl custdi = new CustomerDAOImpl();
			List<Customer> getcustomerList = custdi.getcustomerList();
			Boolean login = true;
			Customer c= new Customer();
			for (int i = 0; i < getcustomerList.size(); i++) {
				String customer = getcustomerList.get(i).getUsername(); 
				String password = getcustomerList.get(i).getPassword();
				if (user.equals(customer) && pass.equals(password)) {
			    	c= getcustomerList.get(i);
			    	login=true;
				}
				if(login==true) {
				}else {
					System.out.println("Incorrect Username/Password.");
				}
		
				
			}
//			if (loginsucess==true) {
//				System.out.println("Logged in");
//				
//			}else {
//				System.out.println("Username/Password incorrect");
//			}
			return c;
		}
		
		
		@Override
		public List<Customer> getcustomerList () throws SQLException {
//			Customer customer =new Customer();
			List<Customer> getcustomerList = new ArrayList<Customer>();
			Connection conn = cd.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM NEW_CUSTOMER");
	        Customer s= null;
	        while(rs.next()) {
	        	s= new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
	        	getcustomerList.add(s);	
	        
	        }
			return getcustomerList;

		}
		
		




//	public static void payment(NewCustomer customer, int c_uname, int amount )throws SQLException{
//		Connection conn = cd.getConnection();
//		Statement stmt = conn.createStatement();
//		String cusSql = "UPDATE NEW_ACCOUNT SET('" + amount +"') WHERE C_UNAME ('"+ customer +"') AND (";
//		stmt.executeUpdate(cusSql);
//		
//	}
	

}
