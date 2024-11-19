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

public class Transaction {
	/**
	 * Inserts, deletes and updates the Transaction table in the table
	 * Contains variable for the username, password and database connection
	 */
	private static final String USER_NAME = "user";
	private static final String PASSWORD = "password";
	private static final String CONNECTION_STR = "jdbc:mysql://localhost/programassignment";
	/**
	 * InsertData Method inserts data into the Transaction table
	 * Uses the RETURN_GENERATED_KEYS to retrieve foreign key information referenced in the AccountType table
	 * Uses Connection to connect to the database in MySQL
	 */	
	public void InsertData() {
		/**
		 * Try catch block with resources
		 * SQLException is used in the catch 
		 */
		try {Connection conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASSWORD);
			PreparedStatement insertData = conn.prepareStatement("INSERT INTO transaction VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			/**
			 * Data to be entered in the Accounts table
			 * 1 represents the TransId(Integer)
			 * 2 represents the TranTypeId(String references TransactionType table)
			 * 3 represents the AcctIdFrom (Integer references Accounts table)
			 * 4 represents the AcctIdTo (Integer references Accounts table)
			 * 5 represents the Amount (Integer)
			 */		
			insertData.setInt(1,1);
			insertData.setString(2, "A");
			insertData.setInt(3, 100);
			insertData.setInt(4, 200);
			insertData.setInt(5, 100);			
			insertData.execute();
			
			insertData.setInt(1,2);
			insertData.setString(2, "C");
			insertData.setInt(3, 300);
			insertData.setInt(4, 200);
			insertData.setInt(5, 1000);			
			insertData.execute();
			
			insertData.setInt(1,3);
			insertData.setString(2, "A");
			insertData.setInt(3, 400);
			insertData.setInt(4, 200);
			insertData.setInt(5, 1500);			
			insertData.execute();
			
			insertData.setInt(1,4);
			insertData.setString(2, "P");
			insertData.setInt(3, 300);
			insertData.setInt(4, 400);
			insertData.setInt(5, 100);			
			insertData.execute();
		}catch(SQLException e) {
			System.err.println(e);
		}
	}
	/**
	 * DeleteData Method deletes data from the Transaction Table
	 * Uses Connection to connect to the database in MySQL
	 */
	public void DeleteData() {
		
		try {Connection conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASSWORD);
		PreparedStatement deleteData = conn.prepareStatement("DELETE FROM transaction WHERE trantypeid = ?");
		/**
		 * Tells the database to delete the row with an TranTypeId of P
		 */
		deleteData.setString(1,"P");
		
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
	 * Update Method updates data in the Transaction Table
	 * Uses Connection to connect to the database in MySQL
	 */
	public void UpdateData() {		
	
		try {Connection conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASSWORD);
		PreparedStatement updateData = conn.prepareStatement("UPDATE transaction SET amount = ? WHERE acctidfrom = ? ");
		/**
		 * Tells the database to update the amount to 100 in the row that has 400 for an AcctIdFrom 		
		 */
		updateData.setInt(1, 100);
		updateData.setInt(2, 400);
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
			String query = "SELECT * FROM transaction";
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("Tansaction Table\nTransId TranTypeId AcctIdFrom AcctIdTo Amount");
			/**
			 * While loop that prints the rows in the table
			 */
			while (rs.next()) {
				String transId = rs.getString("transid");
				String typeId = rs.getString("trantypeid");
				String acctIdFrom = rs.getString("acctidfrom");
				String acctIdTo = rs.getString("acctidto");
				String amount = rs.getString("amount");
				System.out.println(transId + "       " + typeId + "          " + acctIdFrom + "        " + acctIdTo + "      " + amount);
			}
		}catch(SQLException e) {
			System.err.println(e);
		}
	}
}
	
		



