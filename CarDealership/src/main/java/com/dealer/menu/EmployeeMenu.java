package com.dealer.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dealer.beans.Cars;
import com.dealer.daoimpl.CarDAOImpl;
import com.dealer.daoimpl.OfferDAOImpl;

public class EmployeeMenu {
	static Scanner scan = new Scanner(System.in);
	static CarDAOImpl sdi = new CarDAOImpl();
	static OfferDAOImpl odi = new OfferDAOImpl();
	
	public static void addCarToLot() {
		System.out.println("Please Complete Below To Add Car");
		System.out.println("Car ID");
		int id = Integer.parseInt(scan.nextLine());
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
			sdi.insertCar(id, make, model, color, year, mileage,door, trans, cost, owned);
			System.out.println(sdi.getcarList());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void removeCar() {
		Menu.viewAllCars();
		System.out.println("Please Select ID # Car You Wish To Remove");
		System.out.println("Car ID");
		int id = Integer.parseInt(scan.nextLine());
		try {
			sdi.deleteCar(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Updated Car List.");
		Menu.viewAllCars();
		
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
		
		
	}
	
	public static void denyoffer() {
		System.out.println("Please Enter Car For Denied Offers");
		int carID = Integer.parseInt(scan.nextLine());
		try {
			odi.deleteoffer(carID);;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	}


