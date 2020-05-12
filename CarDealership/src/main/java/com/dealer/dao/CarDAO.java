package com.dealer.dao;

import java.sql.SQLException;
import java.util.List;
import com.dealer.beans.Cars;


public interface CarDAO {
	
	public void insertCar(int id, String make, String model, String color, int year, int mileage, String door, String transmission, 
			double cost, String owned) throws SQLException;
	
	public List<Cars>getcarList()throws SQLException;
	
	public List<Cars>seecarList()throws SQLException;}
