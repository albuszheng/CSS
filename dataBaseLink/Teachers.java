package dataBaseLink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Teacher;

public class Teachers implements Link {
	Connection cnn = null;
	private String url = "jdbc:mysql://localhost:3306/css?";
	private String user = "user=root&password=19940325harry@";
	protected Teacher teacher = Teacher.getInstance();

	public Teachers() {
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

	public boolean changePassword(int id, String newPassword) {
		boolean res = false;
		try {
			Statement sta = cnn.createStatement();
			sta.executeUpdate("update teachers" + " set password = "
					+ newPassword + "where teachers.tId= " + Integer.toString(id));
			System.out.println("Change succeeded.");
		} catch (SQLException e) {
			System.out.println("Update failed.");
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
		return res;
	}

	public String getPassword(int userID) {
		String password = null;
		try {
			Statement sta = cnn.createStatement();
			ResultSet rSet = sta.executeQuery("select teachers.password "
					+ "from teachers " + "where teachers.tid=" + Integer.toString(userID));
			if (sta.execute("select teachers.password " + "from teachers "
					+ "where teachers.tid=" + Integer.toString(userID))) {
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

	public void setInstance(int tid) {
		try {
			Statement sta = cnn.createStatement();
			ResultSet rSet = sta
					.executeQuery("select * from students where teachers.tid="
							+ Integer.toString(tid));
			teacher.setName(rSet.getString(2));
			teacher.setUserId(rSet.getString(1));
			teacher.setPassword(rSet.getString(4));
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
	}

	public void registerNewTeacher(int tid, String tname, String tpassword) {
		String values = "values( " + Integer.toString(tid) + ",'" + tname + "','" + tpassword
				+ "')";
		try {
			Statement sta = cnn.createStatement();
			sta.executeQuery("insert into teachers("+Integer.toString(tid)+",'"+tname+"','"+tpassword+"')" 
					+ values);
		} catch (SQLException e) {
			System.out.println("database failure.");
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
	}

	public ArrayList<String> show() {
		ArrayList<String> result = new ArrayList<String>();
		try {
			Statement sta = cnn.createStatement();
			ResultSet rSet = sta.executeQuery("select * from teachers");
			while (rSet.next()) {
				String record = rSet.getString(1) + rSet.getString(2);
				result.add(record);
			}
		} catch (SQLException e) {
			System.out.println("database failure.");
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
		return result;

	}

	public void delete(int tid) {
		try {
			Statement sta = cnn.createStatement();
			sta.executeUpdate("delete from teachers where sid=" + Integer.toString(tid));
		} catch (SQLException e) {
			System.out.println("Operation failed.");
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}

	}

}
