package com.hh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnecter {

	public Connection dbconnecter() throws Exception {
		
		String user = "scott";
		String password = "tiger";
		String url ="jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver =  "oracle.jdbc.driver.OracleDriver";
		
		
		Connection con = null;
		PreparedStatement st = null;
		
		
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
		
		return con;
	}
	
}
