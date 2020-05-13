	package com.dealer.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dealer.beans.Cars;
import com.dealer.dao.CarDAO;
import com.dealer.menu.EmployeeMenu;
import com.dealer.util.ConnDatabase;

public class CarDAOImpl implements CarDAO {

	public static ConnDatabase cd = ConnDatabase.getInstance();

	
	public void insertCar(String CAR_TYPE_MAKE, String CAR_TYPE_MODEL, String CAR_TYPE_COLOR,
			int CAR_TYPE_YEAR, int CAR_TYPE_MILEAGE, String CAR_TYPE_TRANSMISSION, String CAR_TYPE_DOOR,
			double CAR_TYPE_COST, String CAR_TYPE_OWNED) throws SQLException {
		Connection conn = cd.getConnection();
		String sql= "INSERT INTO OFFER VALUES (IDSEQ.NEXTVAL,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, CAR_TYPE_MAKE);
		ps.setString(2, CAR_TYPE_MODEL);
		ps.setString(3, CAR_TYPE_COLOR);
		ps.setInt(4, CAR_TYPE_YEAR);
		ps.setInt(5, CAR_TYPE_MILEAGE);
		ps.setString(6, CAR_TYPE_TRANSMISSION);
		ps.setString(7, CAR_TYPE_DOOR);
		ps.setDouble(8, CAR_TYPE_COST);
		ps.setString(9, CAR_TYPE_OWNED);
		ps.executeUpdate();
	};
	
	
	public void deleteCar(int CAR_TYPE_ID) throws SQLException {
		Connection conn = cd.getConnection();
		Statement stmt = conn.createStatement();
		String carSql = "DELETE FROM CAR_TYPE WHERE CAR_TYPE_ID = (" + CAR_TYPE_ID +")";
		stmt.executeUpdate(carSql);
	}
	
	
	
	

	public List<Cars> getcarList() throws SQLException{
		List<Cars> carList = new ArrayList<Cars>();
		Connection conn = cd.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CAR_TYPE");
		Cars c= null;
		while(rs.next()) {
			c= new Cars (rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(8),rs.getString(7),rs.getDouble(9), rs.getString(10));
			carList.add(c);
		};
		
//		
		return carList;
		
	}
	
			
	public List<Cars> seecarList() throws SQLException{
		List<Cars> scarList = new ArrayList<Cars>();
		Connection conn = cd.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CAR_TYPE");
			while(rs.next()) {			
			System.out.printf("%-8s%-10s%-11s%-11s%-11s%-11s%-11s%-11s%-10s\n", rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7),rs.getString(8),rs.getDouble(9));
		}
//		
		return scarList;
		
	}


	@Override
	public void insertCar(int id, String make, String model, String color, int year, int mileage, String door,
			String transmission, double cost, String owned) throws SQLException {
		// TODO Auto-generated method stub
		
	}




}
