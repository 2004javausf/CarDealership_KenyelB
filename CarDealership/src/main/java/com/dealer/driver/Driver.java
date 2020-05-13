package com.dealer.driver;

import java.sql.SQLException;

import com.dealer.daoimpl.AccountDAOImpl;
import com.dealer.daoimpl.CustomerDAOImpl;
import com.dealer.menu.CustomerLogin;
import com.dealer.menu.CustomerMenu;
import com.dealer.menu.EmployeeMenu;
import com.dealer.menu.MainMenu;

public class Driver {



		public static void main(String[] args) {
			
			CustomerDAOImpl cdi = new CustomerDAOImpl();
			
			AccountDAOImpl adi = new AccountDAOImpl();
	//
//			OfferDAOImpl odi = new OfferDAOImpl();
//			String water;
//			try {
////				odi.viewofferList();
////				adi.getCustomerAccount("water");
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			 try {
//						 adi.getAccount();
////						 System.out.println(adi.getAccount());
//				cdi.getcustomerList();
////				System.out.println(cdi.getcustomerList());
//				CustomerLogin.customerLogin2();
////				System.out.println(cdi.getcustomerList());
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

			MainMenu.mainStartMenu(); 
		}

	}


