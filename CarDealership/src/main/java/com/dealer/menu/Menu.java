package com.dealer.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.dealer.beans.NewCustomer;
import com.dealer.daoimpl.CarDAOImpl;

public class Menu {
	static CarDAOImpl sdi = new CarDAOImpl();
	static Scanner scan = new Scanner(System.in);
	static String username = null;

	public static void banner() {
		System.out.println("======================================");
		System.out.println("======================================");
		System.out.println("  WELCOME TO SPEND-IT CAR DEALERSHIP  ");
		System.out.println("======================================");
		System.out.println("======================================");
		System.out.println("Please select from the below");

	}

	public static void banner2() {
		System.out.println("======================================");
		System.out.println("======================================");
		System.out.println("  WELCOME TO SPEND-IT CAR DEALERSHIP  ");
		System.out.println("======================================");
		System.out.println("======================================");

	}

	// Main Menu
	public static void mainStartMenu() {
	
		System.out.println("[C]ustomer Login \n" + "[E]mployee Login \n" + "[N]ew Customer Registration");
		String mainStart = scan.nextLine();
		switch (mainStart.toLowerCase()) {
		case "c":
//			try {
//				cdi.newAccount();
//			} catch (SQLException e) {
//				System.out.println("Account already exists.");
//				System.exit(0);
//			}
			
			break;
		case "e":
			employeeMenu();

			break;
		case "n":
			CustomerMenu.newCustomerReg();
			break;

		default:
			System.out.println("Not an option!");
			System.out.println("Please Select From List Provided!");
			System.out.println("-------------------------------------");
			mainStartMenu();
			break;
		}
	}

	// MAIN EMPLOYEE MENU
	public static void employeeMenu() {

		System.out.println("Please Make A Selection From The Below.");
		System.out.println("[A]dd Car To Lot \n" + "[R]emove Car From Lot \n" + "[P]ending Offers \n"
				+ "[V]iew Customer Payments \n" + "[C]urrent Cars On Lot");
		String menu = scan.nextLine();
		switch (menu.toLowerCase()) {
		case "a":
			EmployeeMenu.addCarToLot();
			break;
		case "r":
			EmployeeMenu.removeCar();
			break;
		case "p":

			break;
		case "v":

			break;
		case "c":
			viewAllCars();
			break;
		default:
			System.out.println("Not an option!");
			System.out.println("Please Select From List Provided!");
			System.out.println("-------------------------------------");
			employeeMenu();
		}
	}

	public static void customerMenu1() {
		System.out.println("Please Make A Selection From The Below");
		System.out.println("[V]iew Available Cars \n" + "[M]ake/View Offers \n" + "[C]urrent Car Collection  \n"
				+ "[R]eview Payment Balance(s) \n"  + "[Q]uit");
		
	}
	
	
	public static void viewAllCars() {
		
		System.out.println("ID      MAKE      MODEL      COLOR      YEAR      MILEAGE      DOOR      TRANS      COST");
			try {
			sdi.seecarList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void customerAccounts() {
		System.out.println("What Would You Like To Do Today?");
		System.out.println("[S]ee List of All Accounts \n" + "[M]ake A Paymemt \n" + "[O]pen Account");
		String account = scan.nextLine();
		switch (account.toLowerCase()) {
		case "s":
			CustomerMenu.account();
			break;

		case "m":

			break;
			
		case "o":
			CustomerMenu.loanAccount();

			break;

		default:
			System.out.println("Not an option!");
			System.out.println("Please Select From List Provided!");
			System.out.println("-------------------------------------");
			customerAccounts();
			break;
		}
	}
	
	
}
