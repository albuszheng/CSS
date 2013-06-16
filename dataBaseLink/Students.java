package dataBaseLink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Student;

public class Students implements Link {
	protected Connection cnn = null;
	private String url = "jdbc:mysql://localhost:3306/css?";
	private String user = "user=root&password=19940325harry@";
	protected Student student=Student.getInstance();

	public Students() {
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
			sta.executeUpdate("update students" + " set password = "
					+ newPassword + "where students.sId= " +Integer.toString(id));
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
			ResultSet rSet = sta.executeQuery("select students.password "
					+ "from students " + "where students.sid=" + Integer.toString(userID));
			if (sta.execute("select students.password " + "from students "
					+ "where students.sid=" +Integer.toString(userID))) {
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

	public void setInstance(int sid) {
		try {
			Statement sta=cnn.createStatement();
			ResultSet rSet=sta.executeQuery("select * from students where students.sid="+Integer.toString(sid));
			student.setName(rSet.getString(2));
			student.setUserId(rSet.getString(1));
			student.setPassword(rSet.getString(4));
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
		
	}

	public void registerNewStudents(int sid, String sname, String spassword,
			String sGrate) {
		String values = "values( '" + sid + "','" + sname + "','" + sGrate
				+ "','" + spassword + "')";
		try {
			Statement sta = cnn.createStatement();
			sta.executeQuery("insert into students("+Integer.toString(sid)+",'"+sname+"','"+sGrate+"',бо"+spassword+"')'" 
					+ values+"'");
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
			ResultSet rSet = sta.executeQuery("select * from students");
			while (rSet.next()) {
				String record = rSet.getString(1) + rSet.getString(2)
						+ rSet.getString(3);
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

	public void delete(int sid) {
		try {
			Statement sta = cnn.createStatement();
			sta.executeUpdate("delete from students where sid="+Integer.toString(sid));
		} catch (SQLException e) {
			System.out.println("Operation failed.");
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}

	}

}
