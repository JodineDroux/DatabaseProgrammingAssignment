/**
 * @author Jodine Droux
 * Student ID : 0226704
 * Class : ADEV-1001 Programming (Java 2)
 */
package Code;

public class TestData {
/**
 * Calls the methods from the Accounts, AccountType, Transaction and TransactionType classes
 * Runs the code for the program
 * @param args
 */
	public static void main(String[] args) {
		System.out.print("programassigment Database\n--------------------\n");
		/**
		 * TransactionType
		 * Creates a new instance of TransactionType and calls the methods from the class
		 */
		TransactionType data = new TransactionType();
		data.InsertData();
		data.PrintTable();
		data.DeleteData();
		data.UpdateData();
		data.PrintTable();
		System.out.println("********************");
		/**
		 * AccountType
		 * Creates a new instance of AccountType and calls the methods from the class
		 */
		AccountType data1 = new AccountType();
		data1.InsertData();
		data1.PrintTable();
		data1.DeleteData();
		data1.UpdateData();
		data1.PrintTable();
		System.out.println("********************");
		/**
		 * Accounts
		 * Creates a new instance of Accounts and calls the methods from the class
		 */
		Accounts data2 = new Accounts();
		data2.InsertData();
		data2.PrintTable();
		data2.DeleteData();
		data2.UpdateData();
		data2.PrintTable();
		System.out.println("********************");
		/**
		 * Transaction
		 * Creates a new instance of Transactions and calls the methods from the class
		 */
		Transaction data3 = new Transaction();
		data3.InsertData();
		data3.PrintTable();
		data3.DeleteData();
		data3.UpdateData();
		data3.PrintTable();
		System.out.println("********************");
		System.out.println("\nEnd of program");
	}
	
}
