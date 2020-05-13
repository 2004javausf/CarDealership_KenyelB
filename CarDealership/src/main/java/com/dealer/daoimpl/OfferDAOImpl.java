package com.dealer.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dealer.beans.Customer;
import com.dealer.beans.Offer;
import com.dealer.dao.OfferDAO;
import com.dealer.util.ConnDatabase;

public class OfferDAOImpl implements OfferDAO {
	
	public static ConnDatabase cd = ConnDatabase.getInstance();
	@Override
	public void insertNewOffer(int carID, String userName, int offerAmount, String offerStatus) throws SQLException {
		// Prepared Statement - precompiled- compiled in Java, where as Statement is compiled in sql
		Connection conn = cd.getConnection();
		String sql= "INSERT INTO OFFER VALUES (IDSEQ.NEXTVAL,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, carID);
		ps.setString(2, userName);
		ps.setInt(3, offerAmount);
		ps.setString(4, offerStatus);
		ps.executeUpdate();
	}
	@Override
	public List<Offer> getofferList() throws SQLException {
		List<Offer> getofferList = new ArrayList<Offer>();
		Connection conn = cd.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM OFFER");
		while(rs.next()) {			
			System.out.printf("%-8s%-10s%-11s%-11s%-11s%-11s%-10s\n", rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getInt(4), rs.getString(5));
		}
		return getofferList;
	}
	
	public List<Offer> viewofferList() throws SQLException {
		List<Offer> viewofferList = new ArrayList<Offer>();
		Connection conn = cd.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT OFFER.*, CAR_TYPE.CAR_TYPE_MAKE, CAR_TYPE.CAR_TYPE_MODEL, CAR_TYPE.CAR_TYPE_COLOR\r\n" + 
				"FROM OFFER\r\n" + 
				"FULL OUTER JOIN CAR_TYPE\r\n" + 
				"ON OFFER.O_CAR_ID= CAR_TYPE.CAR_TYPE_ID\r\n" + 
				"ORDER BY OFFER.O_ID");
		while(rs.next()) {
			System.out.printf("%-4s%-11s%-9s%-11s%-1s%-16s%-10s%-11s%-11s%-10s\n","", rs.getInt(1),  rs.getInt(2), rs.getString(3), "$" ,rs.getInt(4), rs.getString(8), rs.getString(6), rs.getString(7), rs.getString(5));
		}
		return viewofferList;
	}
	
	public void customerOfferList(Customer customer) throws SQLException{
		List<Offer> customerOfferList = new ArrayList<Offer>();
		OfferDAOImpl offdi = new OfferDAOImpl();
		String cus = customer.getUsername();
		Connection conn = cd.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT OFFER.*, CAR_TYPE.CAR_TYPE_MAKE, CAR_TYPE.CAR_TYPE_MODEL, CAR_TYPE.CAR_TYPE_COLOR\r\n" + 
				"FROM OFFER\r\n" + 
				"inner JOIN CAR_TYPE\r\n" + 
				"ON OFFER.O_UNAME = '" +cus+"' AND OFFER.O_CAR_ID= CAR_TYPE.CAR_TYPE_ID\r\n");
//		Offer o;
		while(rs.next()) {
//			o = new Offer(rs.getInt(1),  rs.getInt(2), rs.getString(3), "$" ,rs.getInt(4), rs.getString(8), rs.getString(6), rs.getString(7), rs.getString(5));
			
			System.out.printf("%-4s%-10s%-10s%-1s%-12s%-12s%-10s\n","", rs.getInt(1),  rs.getInt(2), "$" ,rs.getInt(4), rs.getString(5),  rs.getString(6), rs.getString(7));
		}
		return;
		
	}
	
	public void appOffer(int id, String status) throws SQLException {
		
		Connection conn = cd.getConnection();
		Statement stmt = conn.createStatement();
		String sql ="UPDATE OFFER \r\n" + 
				"SET O_STATUS =('"+ status +"') \r\n" + 
				"WHERE  o_id = ('" + id +"')";
		stmt.executeUpdate(sql);
	}
	
	public void deleteoffer(int carID) throws SQLException {
		String status = "pending";
		Connection conn = cd.getConnection();
		Statement stmt = conn.createStatement();
		String sql ="DELETE FROM OFFER \r\n" + 
				"WHERE  O_CAR_ID = ('" + carID +"') AND O_STATUS= ('"+ status +"'";
	}
		


		
	}


