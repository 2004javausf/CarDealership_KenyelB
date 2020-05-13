package com.dealer.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.dealer.beans.Customer;
import com.dealer.daoimpl.AccountDAOImpl;
import com.dealer.daoimpl.CustomerDAOImpl;
import com.dealer.daoimpl.OfferDAOImpl;
import com.dealer.util.LogThis;

public class CustomerLogin {
		static Scanner scan = new Scanner(System.in);
		static CustomerDAOImpl cdi = new CustomerDAOImpl();
		static AccountDAOImpl adi = new AccountDAOImpl();
		static OfferDAOImpl odi = new OfferDAOImpl();

		public static void customerLogin2() throws SQLException {
			MainMenu.banner2();
			String user;
			String password;
		
		System.out.println("Please Log Into Your Account");
		System.out.println("Username:");
		user = scan.nextLine();
		System.out.println("Password:");
		password = scan.nextLine();
		Customer customer = cdi.login2(user, password);
		LogThis.LogIt("info", customer.getUsername()+"logged-in");
		System.out.println("Welcome Back " + customer.getFname());
		MainMenu.customerMenu1();
		int selection1 = 0;
		do{ 
			int selection11 = Integer.parseInt(scan.nextLine());
			switch (selection11) {
			case 1:
//				Menu.viewAllCars();
				break;

			case 2:
				CustomerMenu.customerOfferMenu();
				String offer = scan.nextLine();
				switch (offer.toLowerCase()) {
				case "c":
					System.out.printf("%-4s%-10s%-11s%-13s%-11s%-11s%-10s\n","", "OFFER ID", "CAR ID", "$ OFFER","STATUS", "MAKE", "MODEL");
					System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					try {
						
						odi.customerOfferList(customer);
						
						MainMenu.customerMenu1();
					} catch (SQLException e) {
						e.printStackTrace();
					}

					break;
				case "m":
					CustomerMenu.makeOffer();
					MainMenu.customerMenu1();

					break;

				default:
					System.out.println("Not an option!");
					System.out.println("Please Select From List Provided!");
					System.out.println("-------------------------------------");
					CustomerMenu.customerOfferMenu();
					break;
				}

				break;

			case 3:

				break;

			case 4:
				CustomerMenu.customerAccounts();
				String account = scan.nextLine();
				switch (account.toLowerCase()) {
				case "s":
					adi.getCustomerAccount(customer);
					break;
				case "m":

					break;
				case "o":
					odi.customerOfferList(customer);
					CustomerMenu.loanAccount();

					break;
				default:
					System.out.println("Not an option!");
					System.out.println("Please Select From List Provided!");
					System.out.println("-------------------------------------");
//					customerAccounts();
					break;
				}
				
				break;

			case 5:
				System.out.println("Not an option!");
				System.out.println("Please Select From List Provided!");
				System.out.println("-------------------------------------");
				MainMenu.customerMenu1();
				break;
			}
			
		} while (selection1!=6);
	}
}
		


