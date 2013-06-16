package dataBaseLink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin implements Link {
	Connection cnn = null;
	private String url = "jdbc:mysql://localhost:3306/css?";
	private String user = "user=root&password=19940325harry@";
	
	public Admin(){
		linkToDataBase();
	}

	@Override
	public boolean linkToDataBase() {
		try {
			cnn = DriverManager.getConnection(url + user);
			return true;
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			return false;
		}
	}

	@Override
	public void closeLink() {
		try {
			if (cnn.isClosed() == false) {
				cnn.close();
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
	}
	
	public boolean changePassword(String id, String newPassword) {
		boolean res = false;
		try {
			Statement sta = cnn.createStatement();
			sta.executeUpdate("update admin" + " set password = "
					+ newPassword + "where admin.Id= " + id);
			System.out.println("Change succeeded.");
		} catch (SQLException e) {
			System.out.println("Update failed.");
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
		return res;
	}

	public String getPassword() {
		String password = null;
		try {
			Statement sta = cnn.createStatement();
			ResultSet rSet = sta.executeQuery("select admin.password "
					+ "from admin " + "where admin.id=admin" );
			if (sta.execute("select admin.password " + "from admin "
					+ "where admin.id=admin")) {
				rSet = sta.getResultSet();
				password = rSet.getString(1);
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return password;
	}


	public void saveBack() {

	}

	public void setInstance() {

	}
	
}
