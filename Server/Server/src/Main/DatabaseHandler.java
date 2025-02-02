package Main;

import java.sql.*;

public class DatabaseHandler {
	private static String url;
	private static String user;
	private static String password;
	
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement pstm;

	public void SetUpConnection(String urlInput, String userInput, String passwordInput) {
		url = urlInput;
		user = userInput;
		password = passwordInput;
	}
	
	public Boolean ConnectDatabase() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	public void InsertNewAccount(Account a) {
		String query = "Insert into Accounts (fName, lName, email, password) values (?,?,?,?)";
		try {
			pstm = connection.prepareStatement(query);
			pstm.setString(1, a.GetFName());
			pstm.setString(2, a.GetLName());
			pstm.setString(3, a.GetEmail());
			pstm.setString(4, a.GetPassword());
			
			int rowInserted = pstm.executeUpdate();
			if(rowInserted > 0) {
				System.out.println("Inserted successfully");
			}
		}
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
	
	public Boolean AuthenticateLogin(String email, String password) {
		String query = "Select count(*) from Accounts where email = ? and password = ?";
		try {
			pstm = connection.prepareStatement(query);
			pstm.setString(1, email);
			pstm.setString(2, password);
			
			resultSet = pstm.executeQuery();
			resultSet.next();
			int rowReturned = resultSet.getInt(1);
			if(rowReturned > 0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return false;
	}
	
}
