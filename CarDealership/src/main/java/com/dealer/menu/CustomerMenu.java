package com.dealer.menu;

import java.awt.Menu;
import java.sql.SQLException;
import java.util.Scanner;

import com.dealer.beans.Customer;
import com.dealer.daoimpl.AccountDAOImpl;
import com.dealer.daoimpl.CustomerDAOImpl;
import com.dealer.daoimpl.OfferDAOImpl;

public class CustomerMenu {
//	public static String customer;
	static Scanner scan = new Scanner(System.in);
	static OfferDAOImpl odi = new OfferDAOImpl();
	static CustomerDAOImpl cdi = new CustomerDAOImpl();
	static AccountDAOImpl adi = new AccountDAOImpl();
	public static Customer customer;

	
	public static void customerAccounts() {
		System.out.println("What Would You Like To Do Today?");
		System.out.println("[S]ee List of All Accounts \n" + "[M]ake A Paymemt \n" + "[O]pen Account");
	}
	
	
	public static void newCustomerReg() {
		System.out.println("Please Complete The Below To Open An Account");
		System.out.println("FIRST NAME:");
		String customerFname = scan.nextLine();
		System.out.println("LAST NAME:");
		String customerLname = scan.nextLine();
		System.out.println("USERNAME:");
		String customerUsername = scan.nextLine();
		System.out.println("PASSWORD:");
		String customerPassword = scan.nextLine();
		try {
			cdi.insertCustomer(customerFname, customerLname, customerUsername, customerPassword);
			System.out.println(cdi.getcustomerList());
			System.out.println("Registration Completed");
			MainMenu.mainStartMenu();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void customerOfferMenu() {
		System.out.println("What Would You Like To Do Today?");
		System.out.println("[C]urrent Offers \n" + "[M]ake Offer");
	}


	public static void account() {
		System.out.println("What Would You Like To Do Today?");
		System.out.println("[S]ee List of All Accounts \n" + "[O]pen Account");
	}

	public static void makeOffer() {
		System.out.println("Please Compelete The Below");
		System.out.println("Car ID#:");
		int id = Integer.parseInt(scan.nextLine());
		System.out.println("Your Username");
		String user = scan.nextLine();
		System.out.println("Offer Amount");
		int offer = Integer.parseInt(scan.nextLine());
		String status = "pending";

		try {
			odi.insertNewOffer(id, user, offer, status);
			System.out.println(cdi.getcustomerList());
			System.out.println("Registration Completed");
			MainMenu.mainStartMenu();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Offer has been sent");
	}

	public static void loanAccount() {
		double interest = .035 / 12;
		System.out.println("Please Complete Below for Loan");
		System.out.println("Car ID:");
		int id = Integer.parseInt(scan.nextLine());
		System.out.println("Username");
		String user = scan.nextLine();
		System.out.println("Loan Amount:");
		int loan = Integer.parseInt(scan.nextLine());
		System.out.println("Select Payment Terms:36, 60, or 72 months");
		int terms = Integer.parseInt(scan.nextLine());
		double totalInterest = loan * interest * terms;
		double monthly = (totalInterest + loan) / terms;
		System.out.println("Your Monthly Payments are " + monthly);
		
		try {
			adi.insertNewAccount(id, user, loan, terms, monthly);
			System.out.println("Account Created");
			MainMenu.customerMenu1();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}


//public static void payLoans() {
//	System.out.println("Enter Account#");
//	int account = Integer.parseInt(scan.nextLine());
//	System.out.println("Payment Amount");
//	double payment = Integer.parseInt(scan.nextLine());
////	balance = 
//}
//}


//	public static void makePayment(NewCustomer customer, Account acc) {
//		
//		System.out.println("Hi would you like to make a payment?");
//		System.out.println("Please answer below");
//		System.out.println("Please Enter Account#");
//		int account = Integer.parseInt(scan.nextLine());
//		System.out.println("Enter Payment amount");
//		int newBalance = Account.balance  
//		int payment = Integer.parseInt(scan.nextLine());
//		try {
//			newBalance=cdi 
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
