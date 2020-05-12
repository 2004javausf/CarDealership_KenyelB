package com.dealer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnDatabase {
	
	private static ConnDatabase cd = new ConnDatabase();
	
	private ConnDatabase() {
		super();
	}

	public static synchronized ConnDatabase getInstance() {
		if (cd==null) {
			cd = new ConnDatabase();
		}
		return cd;
	}
	
	public Connection getConnection() {
		String url ="jdbc:oracle:thin:@java2020training.cmkeid7ox09u.us-east-2.rds.amazonaws.com:1521:ORCL";
		String user= "lab92459";
		String password="mynevergo";
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return conn;	
	}
}
