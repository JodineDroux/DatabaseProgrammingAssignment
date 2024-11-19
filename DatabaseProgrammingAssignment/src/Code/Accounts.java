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

public class Accounts {
	/**
	 * Inserts, deletes and updates the accounts table in the table
	 * Contains variable for the username, password and database connection
	 */
	private static final String USER_NAME = "user";
	private static final String PASSWORD = "password";
	private static final String CONNECTION_STR = "jdbc:mysql://localhost/programassignment";
	/**
	 * InsertData Method inserts data into the Accounts table
	 * Uses the RETURN_GENERATED_KEYS to retrieve foreign key information referenced in the AccountType table
	 * Uses Connection to connect to the database in MySQL
	 */
	public void InsertData() {
		/**
		 * Try catch block with resources
		 * SQLException is used in the catch 
		 */
		try {
			Connection conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASSWORD);
			PreparedStatement insertData = conn.prepareStatement("INSERT INTO accounts VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
			/**
			 * Data to be entered in the Accounts table
			 * 1 represents the AccountId(Integer)
			 * 2 represents the AcctTypeId(Integer reference to AccountType table)
			 * 3 represents the Balance(Integer)
			 */
			insertData.setInt(1, 100);
			insertData.setInt(2, 10);
			insertData.setInt(3, 3000);
			insertData.execute();
			
			insertData.setInt(1, 200);
			insertData.setInt(2, 20);
			insertData.setInt(3, 1000);
			insertData.execute();
			
			insertData.setInt(1, 300);
			insertData.setInt(2, 30);
			insertData.setInt(3, 5000);
			insertData.execute();
			
			insertData.setInt(1, 400);
			insertData.setInt(2, 10);
			insertData.setInt(3, 3500);
			insertData.execute();
			
			insertData.setInt(1, 500);
			insertData.setInt(2, 10);
			insertData.setInt(3, 4500);
			insertData.execute();		
		}catch(SQLException e) {
			System.err.println(e);
		}
	}
	/**
	 * DeleteData Method deletes data from the Accounts Table
	 * Uses Connection to connect to the database in MySQL
	 */
	public void DeleteData() {
		
		try {Connection conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASSWORD);
		PreparedStatement deleteData = conn.prepareStatement("DELETE FROM accounts WHERE accountid = ?");
		/**
		 * Tells the database to delete the row with an AccountId of 500
		 */
		deleteData.setInt(1,500);
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
		PreparedStatement updateData = conn.prepareStatement("UPDATE accounts SET balance = ? WHERE accountid = ? ");
		/**
		 * Tells the database to update the balance to 400 in the row that has 400 for an accountid 		
		 */
		updateData.setInt(1, 3000);
		updateData.setInt(2, 400);
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
		String query = "SELECT * FROM accounts";
		ResultSet rs = stmt.executeQuery(query);
		System.out.println("Accounts\nAccountid AcctTypeId Balance\n");
		/**
		 * While loop that prints the rows in the table
		 */
		while (rs.next()) {
			String id = rs.getString("accountid");
			String desc = rs.getString("accttypeid");
			String balance = rs.getString("balance");
			System.out.println(id + "       " + desc + "         " + balance);
		}
	}catch(SQLException e) {
		System.err.println(e);
	}
}
}

