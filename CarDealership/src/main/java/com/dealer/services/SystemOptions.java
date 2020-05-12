package com.dealer.services;

import java.util.Scanner;

public class SystemOptions {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void monthlyPayments(String customer) {
	double interest = .035/12;
	
		System.out.println("Please Complete Below for Loan");
		System.out.println("Loan Amount:");
		long loan = Integer.parseInt(scan.nextLine());
		System.out.println("Select Payment Terms:36, 60, or 72 months");
		int terms = Integer.parseInt(scan.nextLine());
		double totalInterest = loan * interest*terms;
		System.out.println(totalInterest );
		System.out.println(interest );
		double monthly = (totalInterest + loan) /terms;
		System.out.println("Your Monthly Payments are " + monthly);
		
		
	}
	
//	public static double makePayment() {
//		System.out.println("Your monthly Payments are ");
//		System.out.println("Enter Amount to pay");
//		double paymemt = Double.parseDouble(scan.nextLine());
//
//				
//	}

}
