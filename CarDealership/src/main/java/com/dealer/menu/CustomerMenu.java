package com.dealer.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.dealer.beans.Account;
import com.dealer.beans.NewCustomer;
import com.dealer.daoimpl.AccountImpl;
import com.dealer.daoimpl.NewCustomerDAOImpl;
import com.dealer.daoimpl.OfferDAOImpl;

public class CustomerMenu {
//	public static String customer;
	static Scanner scan = new Scanner(System.in);
	static NewCustomerDAOImpl cdi = new NewCustomerDAOImpl();
	static OfferDAOImpl odi = new OfferDAOImpl();
	static AccountImpl adi = new AccountImpl();
	public static String customer;

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
			cdi.insertNewCustomer(customerFname, customerLname, customerUsername, customerPassword);
			System.out.println(cdi.getcustomerList());
			System.out.println("Registration Completed");
			Menu.mainStartMenu();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void customerOfferMenu() {
		System.out.println("What Would You Like To Do Today?");
		System.out.println("[C]urrent Offers \n" + "[M]ake Offer");
		String offer = scan.nextLine();
		switch (offer.toLowerCase()) {
		case "c":
			System.out.println("Enter Username");
			String user = scan.nextLine();
			try {
				odi.viewCOfferList(user);
				Menu.mainStartMenu();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;
		case "m":
			makeOffer();
			Menu.customerMenu1();

			break;

		default:
			System.out.println("Not an option!");
			System.out.println("Please Select From List Provided!");
			System.out.println("-------------------------------------");
			customerOfferMenu();
			break;
		}

	}


	public static void account() {
		try {
			adi.getCustomerAccount2();
			System.out.println("......");
			Menu.customerMenu1();
			customerMenu2();

		} catch (SQLException e) {

			e.printStackTrace();
		}
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
			Menu.mainStartMenu();
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
			System.out.println(adi.getCustomerAccount2());
			System.out.println("Registration Completed");
			Menu.customerMenu1();
			customerMenu2();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
		
		
	

	public static void customerLogin2() {
		Menu.banner2();
		try {
			customer = cdi.login();
			customerMenu2();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


public static void customerMenu2() {
	String q = null;
	 String selection = q;
	 
	 String menu = scan.nextLine();
		switch (menu.toLowerCase()) {
		case "v":
			Menu.viewAllCars();
			break;

		case "m":
			customerOfferMenu();

			break;

		case "c":

			break;

		case "r":
			Menu.customerAccounts();
			break;

		case "q":
			System.out.println("Not an option!");
			System.out.println("Please Select From List Provided!");
			System.out.println("-------------------------------------");
			Menu.customerMenu1();
			break;
}
}

public static void payLoans() {
	System.out.println("Enter Account#");
	int account = Integer.parseInt(scan.nextLine());
	System.out.println("Payment Amount");
	double payment = Integer.parseInt(scan.nextLine());
//	balance = 
}
}


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
