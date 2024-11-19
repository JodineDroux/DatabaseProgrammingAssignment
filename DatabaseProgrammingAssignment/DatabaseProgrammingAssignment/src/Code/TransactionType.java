/**
 * @author Jodine Droux
 * Student ID : 0226704
 * Class : ADEV-1001 Programming (Java 2)
 */
package Code;
/**
 * java packages being used
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionType{
	/**
	 * Inserts, deletes and updates the TransactionType table in the table
	 * Contains variable for the username, password and database connection
	 */
	private static final String USER_NAME = "user";
	private static final String PASSWORD = "password";
	private static final String CONNECTION_STR = "jdbc:mysql://localhost/programassignment";
	/**
	 * InsertData Method inserts data into the TransactionType table
	 * Uses Connection to connect to the database in MySQL
	 */
		
	public void InsertData() {
		
		try {
			Connection conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASSWORD);
			PreparedStatement insertData = conn.prepareStatement("INSERT INTO transactiontype VALUES (?,?)");
			/**
			 * Data to be entered in the Accounts table
			 * 1 represents the TranTypeId (String)
			 * 2 represents the TransactionDesc (String)
			 */	
			insertData.setString(1, "A");
			insertData.setString(2, "Authentication");
			insertData.execute();
			
			insertData.setString(1, "C");
			insertData.setString(2, "Credit");
			insertData.execute();
			
			insertData.setString(1, "P");
			insertData.setString(2, "Payment");
			insertData.execute();
			
			insertData.setString(1, "D");
			insertData.setString(2, "Debit");
			insertData.execute();
			
		}catch(SQLException e) {
			System.err.println(e);
		}
	}
	/**
	 * DeleteData Method deletes data from the TransactionType Table
	 * Uses Connection to connect to the database in MySQL
	 */
	public void DeleteData() {
		
		try {Connection conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASSWORD);
		PreparedStatement deleteData = conn.prepareStatement("DELETE FROM transactiontype WHERE trantypeid = ?");
		/**
		 * Tells the database to delete the row with an TranTypeId of D
		 */
		deleteData.setString(1,"D");
		
		int result = deleteData.executeUpdate();
		/**
		 * if statement tells the user if the data has been successfully deleted
		 */
		if (result == 1)
			System.out.println("Row deleted with success");
		else
			System.out.println("No rows deleted");
		}catch (SQLException e) {
			System.err.println(e);
		}		
	}
	/**
	 * Update Method updates data in the TransactionType Table
	 * Uses Connection to connect to the database in MySQL
	 */
	public void UpdateData() {		
	
		try {Connection conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASSWORD);
		PreparedStatement updateData = conn.prepareStatement("UPDATE transactiontype SET transactiondesc = ? WHERE trantypeid = ? ");
		/**
		 * Tells the database to update the TransactionDesc to Authorization in the row that has A for an TranTypeId 		
		 */
		updateData.setString(1, "Authorization");
		updateData.setString(2, "A");
		updateData.executeUpdate();
		
		int result = updateData.executeUpdate();
		/**
		 * Lets the user know if the update has been successfully completed
		 */
		if (result == 1)
			System.out.println("Row updated with success");
		else
			System.out.println("No rows update");
		}catch(SQLException e) {
			System.err.println(e);
		}
	}
	/**
	 * PrintTable Method prints the table to the console
	 * Uses Connection to connect to the database in MySQL
	 */
	public void PrintTable() {
		
		try {Connection conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASSWORD);
		
		Statement stmt = conn.createStatement();
		String query = "SELECT * FROM transactiontype";
		ResultSet rs = stmt.executeQuery(query);
		System.out.println("TransactionType\nTranTypeId  TransactionDesc");
		/**
		 * While loop that prints the rows in the table
		 */
		while (rs.next()) {
			String id = rs.getString("trantypeid");
			String desc = rs.getString("transactiondesc");
			System.out.println(id + "           " + desc);
			}
		}catch(SQLException e) {
		System.err.println(e);
		}
	}
}
	
		

        	
		

		       
		        	
		        


		
	

	
