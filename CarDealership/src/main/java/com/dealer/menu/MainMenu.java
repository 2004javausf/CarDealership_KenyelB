package com.dealer.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.dealer.daoimpl.CarDAOImpl;

public class MainMenu {
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
		banner();
		System.out.println("[C]ustomer Login \n" + "[E]mployee Login \n" + "[N]ew Customer Registration");
		String mainStart = scan.nextLine();
		switch (mainStart.toLowerCase()) {
		case "c":
			try {
				CustomerLogin.customerLogin2();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			break;
		case "e":
			EmployeeMenu.employeeLogin();
			

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
	
	public static void customerMenu1() {
		System.out.println("Please Make A Selection From The Below");
		System.out.println("1.View Available Cars \n" + "2. Make/View Offers \n" + "3. Current Car Collection  \n"
				+ "4. Review Payment Balance(s) \n"  + "5.Quit");
		
		
		
	}


	// MAIN EMPLOYEE MENU
	public static void employeeMenu() {

		System.out.println("Please Make A Selection From The Below.");
		EmployeeMenu.employeeOptions();
	}

	public static void viewAllCars() {
		
		System.out.println("ID      MAKE      MODEL      COLOR      YEAR      MILEAGE      DOOR      TRANS      COST");
			try {
			sdi.seecarList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
