package com.dealer.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dealer.beans.Cars;
import com.dealer.daoimpl.AccountDAOImpl;
import com.dealer.daoimpl.CarDAOImpl;
import com.dealer.daoimpl.OfferDAOImpl;
import com.dealer.util.LogThis;

public class EmployeeMenu {
	static Scanner scan = new Scanner(System.in);
	static CarDAOImpl sdi = new CarDAOImpl();
	static OfferDAOImpl odi = new OfferDAOImpl();
	static AccountDAOImpl adi = new AccountDAOImpl();
	
	
	public static void employeeLogin() {

		String userEmploy = "JackJill";
		String passEmploy = "uphill";
		System.out.println("Welcome to Employee Portal");
		System.out.println("Please Enter Username and Password");
		System.out.println("Username:");
		String employUsername = scan.nextLine();
		System.out.println("Password:");
		String employPassword = scan.nextLine();
		if (userEmploy.equals(employUsername) && passEmploy.equals(employPassword)) {
			System.out.println("Welcome " + userEmploy);
			MainMenu.employeeMenu();
			LogThis.LogIt("info", userEmploy + "logged-in");
			// WILL DIRECT TO EMPLOYEE PORTAL
		} else {
			System.out.println("Wrong Username/Password, Please try again");
			employeeLogin();
		}
	}
	
	public static void employeeOptions() {
		System.out.println("[V]iew Cars On Lot \n" + "[A]DD CARS TO LOT \n" + "[R]EMOVE CARS FROM LOT \n"+ "[C]USTOMER ACCOUNTS \n" + "[O]FFERS \n" + "[Q]uit");
		String selection = scan.nextLine();
		switch (selection.toLowerCase()) {
		case "v":
			MainMenu.viewAllCars();
			employeeOptions();
			break;
		case "a":
			addCarToLot();
			employeeOptions();
			break;

		case "r":
			removeCar();
			employeeOptions();
			break;
		case "c":
			viewCustomerAccount();
			employeeOptions();
			break;
		case "o":
			viewofferList();
			System.out.println("Would You Like to [A]pprove or [D] Offer");
			String select= scan.nextLine();
			switch (select.toLowerCase()) {
			case "a":
				approveDenyOffer();
				break;
			case "d":
				denyoffer();
				break;
				}
			employeeOptions();
			break;
			case "q":
			System.out.println("Logged Out");
			MainMenu.mainStartMenu();
			break;
		default:
			employeeOptions();
			break;
		}
	}

	
	public static void addCarToLot() {
		System.out.println("Please Complete Below To Add Car");
		System.out.println("Make:");
		String make = scan.nextLine();
		System.out.println("Model:");
		String model = scan.nextLine();
		System.out.println("Color:");
		String color = scan.nextLine();
		System.out.println("Year:");
		int year = Integer.parseInt(scan.nextLine());
		System.out.println("Mileage:");
		int mileage = Integer.parseInt(scan.nextLine());
		System.out.println("Door:");
		String door = scan.nextLine();
		System.out.println("Transmission:");
		String trans = scan.nextLine();
		System.out.println("Cost:");
		double cost = Double.parseDouble(scan.nextLine());
		System.out.println("Owned:");
		String owned = scan.nextLine();
			try {
			sdi.insertCar(make, model, color, year, mileage,door, trans, cost, owned);
			System.out.println(sdi.getcarList());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void removeCar() {
		MainMenu.viewAllCars();
		System.out.println("Please Select ID # Car You Wish To Remove");
		System.out.println("Car ID");
		int id = Integer.parseInt(scan.nextLine());
		try {
			sdi.deleteCar(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Updated Car List.");
		MainMenu.viewAllCars();
		
	}

	public static void viewofferList() {
		
		System.out.println("OFFER ID    CAR ID    USERNAME    OFFER AMOUNT      MAKE      MODEL      COLOR      STATUS");
		System.out.println("*******************************************************************************************");
		try {
		odi.viewofferList();
	} catch (SQLException e) {
		e.printStackTrace();
	}	
	
}
	public static void approveDenyOffer() {
		viewofferList();
		System.out.println("Enter Offer ID");
		int id = Integer.parseInt(scan.nextLine());
		String status = "Approved";
		try {
			odi.appOffer(id, status);
			denyoffer();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		employeeOptions();
	}
	
	public static void denyoffer() {
		System.out.println("Please Enter Car For Denied Offers");
		int carID = Integer.parseInt(scan.nextLine());
		try {
			odi.deleteoffer(carID);;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		employeeOptions();
	}
	
	public static void  viewCustomerAccount() {
		
		System.out.println("Enter Customer UserName");
		String user = scan.nextLine();
		try {
			adi.customerAccount(user);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	}


