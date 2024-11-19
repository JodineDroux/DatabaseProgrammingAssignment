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

public class AccountType {
	/**
	 * Inserts, deletes and updates the AccountType table in the table
	 * Contains variable for the username, password and database connection
	 */
	private static final String USER_NAME = "user";
	private static final String PASSWORD = "password";
	private static final String CONNECTION_STR = "jdbc:mysql://localhost/programassignment";

		
	public void InsertData() {
		/**
		 * InsertData Method inserts data into the AccountType table
		 * Uses Connection to connect to the database in MySQL
		 */
		try {
			/**
			 * Try catch block with resources
			 * SQLException is used in the catch 
			 */
			Connection conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASSWORD);
			PreparedStatement insertData = conn.prepareStatement("INSERT INTO accounttype VALUES (?,?)");
			/**
			 * Data to be entered in the Accounts table
			 * 1 represents the AcctTypeId (Integer)
			 * 2 represents the AccountTypeDesc (String)
			 */
			insertData.setInt(1, 10);
			insertData.setString(2, "Single");
			insertData.execute();
			
			insertData.setInt(1, 20);
			insertData.setString(2, "Joint");
			insertData.execute();
			
			insertData.setInt(1,40);
			insertData.setString(2, "Minor");
			insertData.execute();
			
			insertData.setString(1, "50");
			insertData.setString(2, "Other");
			insertData.execute();
		}catch(SQLException e) {
			System.err.println(e);
		}
	}
	public void DeleteData() {
		/**
		 * DeleteData Method deletes data from the AccountType Table
		 * Uses Connection to connect to the database in MySQL
		 */	
		try {Connection conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASSWORD);
		PreparedStatement deleteData = conn.prepareStatement("DELETE FROM accounttype WHERE accounttypedesc = ?");
		/**
		 * Tells the database to delete the row with an AccountTypeId of Other
		 */
		deleteData.setString(1,"Other");
		/**
		 * if statement tells the user if the data has been successfully deleted
		 */
		int result = deleteData.executeUpdate();
		
		if (result == 1)
			System.out.println("Row deleted with success");
		else
			System.out.println("No rows deleted");
		}catch (SQLException e) {
			System.err.println(e);
		}		
	}
		/**
		 * Update Method updates data in the Accounts Table
		 * Uses Connection to connect to the database in MySQL
		 */	
	public void UpdateData() {
		
		try {Connection conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASSWORD);
		PreparedStatement updateData = conn.prepareStatement("UPDATE accounttype SET accttypeid = ? WHERE accounttypedesc = ? ");
		/**
		 * Tells the database to update the AcctTypeId to 30 in the row that has Minor for an AccoutTypeDesc		
		 */		
		updateData.setInt(1, 30);
		updateData.setString(2, "Minor");
		updateData.executeUpdate();
		/**
		 * Lets the user know if the update has been successfully completed
		 */
		int result = updateData.executeUpdate();
		
		if (result == 1)
			System.out.println("Row updated with success");
		else
			System.out.println("No rows update");
		}catch(SQLException e) {
			System.err.println(e);
		}
	}
	public void PrintTable() {
		/**
		 * PrintTable Method prints the table to the console
		 * Uses Connection to connect to the database in MySQL
		 */
		try {Connection conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASSWORD);
			
		Statement stmt = conn.createStatement();
		String query = "SELECT * FROM accounttype";
		ResultSet rs = stmt.executeQuery(query);
		System.out.println("AccountType\nAccountid AccountTypeDesc");
		/**
		 * While loop that prints the rows in the table
		 */
		while (rs.next()) {
			String id = rs.getString("accttypeid");
			String desc = rs.getString("accounttypedesc");
			System.out.println(id + "        " + desc );
			}
		}catch(SQLException e) {
			System.err.println(e);
		}
	
	}
}