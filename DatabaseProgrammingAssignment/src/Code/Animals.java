package Code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Animals {
	public static void main(String args[]) {
		
	final String USER_NAME = "username";
	final String PASSWORD = "password";
	final String CONNECTION_STR = "jdbc:mysql://localhost/Animals";	
	try {Connection conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASSWORD);
	
	Statement stmt = conn.createStatement();
	String query = "SELECT * FROM Animals";
	ResultSet rs = stmt.executeQuery(query);
	while(rs.next()) {
		System.out.print(rs.getString("Animal" + " "));
	
		
		}
	}catch(SQLException e) {
	System.err.println(e);
	}
}
}
