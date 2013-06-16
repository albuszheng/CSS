package dataBaseLink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Courses implements Link {
	Connection cnn = null;
	private String url = "jdbc:mysql://localhost:3306/css?";
	private String user = "user=root&password=19940325harry@";

	public Courses() {
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

	public void createNewCourse(String name, String credit, String classroom,
			String hours, String time, String optional, int teacherid) {
		try {
			Statement sta = cnn.createStatement();
			sta.execute("insert into courses values(," + name + ","
					+ Integer.toString(teacherid) + "," + credit + ","
					+ optional + "," + classroom + "," + hours + "," + time
					+ ");");
			sta.execute("create table "
					+ "'"
					+ name
					+ "'"
					+ "('sid' INT NOT NULL,'sname' VARCHAR(45) NULL,'isTA' VARCHAR(1) NULL,'Score' VARCHAR(10) NULL,PRIMARY KEY ('sid'));");
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}

	}

	public boolean enrollToCourse(String courseName, String sname, String sid,
			String isTA) {
		try {
			Statement sta = cnn.createStatement();
			Statement sta1 = cnn.createStatement();
			ResultSet rSet = sta1
					.executeQuery("select cname from courses where course.cname="
							+ courseName + ";");
			if (rSet.getArray(1).equals(courseName)) {
				return sta.execute("insert into " + courseName + " values("
						+ sid + "," + sname + "," + isTA + ",);");
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			return false;
		}
	}

	public void modifyCourse() {
		try {
			Statement sta = cnn.createStatement();
			sta.executeUpdate("update courses set ");
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}

	}

	public void modifyCourse(String time) {

	}

	public void unEnrollCourse(String sid, String courseName) {
		try {
			Statement sta = cnn.createStatement();
			sta.executeUpdate("delete from " + courseName + " where "
					+ courseName + ".sid=" + sid);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}

	}

	public void appointTA(String sid, String courseName) {
		try {
			Statement sta = cnn.createStatement();
			ResultSet rSet = sta.executeQuery("select sid from css."
					+ courseName + " where " + courseName + "+.sid=+" + sid);
			if (rSet.getString(1).equals(null)) {
				Statement staTemp = cnn.createStatement();
				staTemp.executeUpdate("insert into css."
						+ courseName
						+ " valuse(sid,(select sname from students where students.sid="
						+ sid + "),'Y')");
			} else {
				Statement staTemp = cnn.createStatement();
				staTemp.executeUpdate("update " + courseName
						+ " set isTA='Y' where " + courseName + ".sid=" + sid);
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}

	}

	public ArrayList<String> showGrades(String courseName) {
		ArrayList<String> grades = new ArrayList<String>();
		try {
			Statement sta = cnn.createStatement();
			ResultSet rSet = sta.executeQuery("select sid,sname,score from "
					+ courseName);
			while (rSet.next()) {
				grades.add(rSet.getString(1) + "	" + rSet.getString(2) + "	"
						+ rSet.getString(3));
			}
		} catch (SQLException e) {
			grades = null;
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
		return grades;
	}

	public String showGrades(String sid, String courseName) {
		String grade = null;
		try {
			Statement sta = cnn.createStatement();
			ResultSet rSet = sta.executeQuery("select sid,sname,score from "
					+ courseName + " where " + courseName + ".sid=" + sid);
			grade = rSet.getString(3);
		} catch (SQLException e) {
			grade = null;
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
		return grade;
	}

	public void enterGrades(String sid, String courseName, String score) {
		try {
			Statement sta = cnn.createStatement();
			sta.executeUpdate("update " + courseName
					+ " set score=score where +" + courseName + ".sid=" + sid);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
	}

	public ArrayList<String> show() {
		ArrayList<String> courses = new ArrayList<String>();
		try {
			Statement sta = cnn.createStatement();
			ResultSet rSet = sta.executeQuery("select * from course");
			while (rSet.next()) {
				if (rSet.getString(5).equals("Y")) {
					courses.add(rSet.getString(1)
							+ "  "
							+ rSet.getString(2)
							+ "  "
							+ sta.executeQuery(
									"select tname from teachers where teachers.tid="
											+ rSet.getString(3) + ";")
									.getString(1) + "  Optional" + "  "
							+ rSet.getString(6) + "  " + rSet.getString(8)
							+ "  " + rSet.getString(7) + "hours  "
							+ rSet.getShort(4) + "points");
				} else {
					courses.add(rSet.getString(1)
							+ "  "
							+ rSet.getString(2)
							+ "  "
							+ sta.executeQuery(
									"select tname from teachers where teachers.tid="
											+ rSet.getString(3) + ";")
									.getString(1) + "  Compulsory" + "  "
							+ rSet.getString(6) + "  " + rSet.getString(8)
							+ "  " + rSet.getString(7) + "hours  "
							+ rSet.getShort(4) + "points");
				}
			}
		} catch (SQLException e) {
			courses = null;
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
		return courses;
	}

	public void delete(int cid) {
		try {
			Statement sta = cnn.createStatement();
			sta.execute("delete from courses where courses.cid="
					+ Integer.toString(cid));
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
	}

	public void courseInfo() {

	}

	public ArrayList<String> searchCourse(int sid) {
		ArrayList<String> courseName = new ArrayList<String>();
		try {
			Statement sta = cnn.createStatement();
			ResultSet rSetTemp = sta.executeQuery("select cName from course");
			while (rSetTemp.next()) {
				Statement staTemp = cnn.createStatement();
				ResultSet rSet = staTemp.executeQuery("select sid from "
						+ rSetTemp.getString("cName") + "where "
						+ rSetTemp.getString("cName") + ".sid="
						+ Integer.toString(sid) + ";");
				if (rSet.next()) {
					courseName.add(rSetTemp.getString("cName"));
				}
			}
			return courseName;
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			if (courseName.isEmpty()) {
				return null;
			} else {
				return courseName;
			}
		}
	}

	public ArrayList<String> searchScore(int sid) {
		ArrayList<String> result = new ArrayList<String>();
		try {
			Statement sta = cnn.createStatement();
			ResultSet rSet = sta.executeQuery("select cName from course");
			while (rSet.next()) {
				Statement staTemp = cnn.createStatement();
				ResultSet rSetTemp = staTemp.executeQuery("select score from "
						+ rSet.getString("cName") + "where "
						+ rSet.getString("cName") + ".sid="
						+ Integer.toString(sid) + ";");
				result.add(rSet.getString("cName")
						+ rSetTemp.getString("score"));
			}
			return result;
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			if (result.isEmpty()) {
				return null;
			} else {
				return result;
			}
		}
	}

	public ArrayList<String> show(int id) {
		ArrayList<String> results = new ArrayList<String>();
		try {
			Statement sta = cnn.createStatement();
			ResultSet rSet = sta
					.executeQuery("select * from courses where courses.cTeacherId="
							+ Integer.toString(id) + ";");
			while (rSet.next()) {
				if (rSet.getString(5).equals("Y")) {
					results.add(rSet.getString(1)
							+ "  "
							+ rSet.getString(2)
							+ "  "
							+ sta.executeQuery(
									"select tname from teachers where teachers.tid="
											+ Integer.toString(id) + ";")
									.getString(1) + "  Optional" + "  "
							+ rSet.getString(6) + "  " + rSet.getString(8)
							+ "  " + rSet.getString(7) + "hours  "
							+ rSet.getShort(4) + "points");
				} else {
					results.add(rSet.getString(1)
							+ "  "
							+ rSet.getString(2)
							+ "  "
							+ sta.executeQuery(
									"select tname from teachers where teachers.tid="
											+ Integer.toString(id) + ";")
									.getString(1) + "  Compulsory" + "  "
							+ rSet.getString(6) + "  " + rSet.getString(8)
							+ "  " + rSet.getString(7) + "hours  "
							+ rSet.getShort(4) + "points");
				}
			}
			return results;
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			if (results.isEmpty()) {
				return null;
			} else {
				return results;
			}
		}
	}

	public String show(int tid, int cid) {
		ArrayList<String> results = new ArrayList<String>();
		try {
			Statement sta = cnn.createStatement();
			ResultSet rSet = sta
					.executeQuery("select * from courses where course.cTeacherId="
							+ Integer.toString(tid)
							+ "and course.cid="
							+ Integer.toString(cid) + ";");
			while (rSet.next()) {
				if (rSet.getString(5).equals("Y")) {
					results.add(rSet.getString(1)
							+ "  "
							+ rSet.getString(2)
							+ "  "
							+ sta.executeQuery(
									"select tname from teachers where teachers.tid="
											+ Integer.toString(tid) + ";")
									.getString(1) + "  Optional" + "  "
							+ rSet.getString(6) + "  " + rSet.getString(8)
							+ "  " + rSet.getString(7) + "hours  "
							+ rSet.getShort(4) + "points");
				} else {
					results.add(rSet.getString(1)
							+ "  "
							+ rSet.getString(2)
							+ "  "
							+ sta.executeQuery(
									"select tname from teachers where teachers.tid="
											+ Integer.toString(tid) + ";")
									.getString(1) + "  Compulsory" + "  "
							+ rSet.getString(6) + "  " + rSet.getString(8)
							+ "  " + rSet.getString(7) + "hours  "
							+ rSet.getShort(4) + "points");
				}
			}
			if (results.isEmpty()) {
				return null;
			} else {
				return results.get(0);
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			if (results.isEmpty()) {
				return null;
			} else {
				return results.get(0);
			}
		}
	}
	
	public ArrayList<String> showStudents(int cid){
		ArrayList<String> result=new ArrayList<String>();
		try {
			Statement sta=cnn.createStatement();
			ResultSet rSetTemp=sta.executeQuery("select cName from course where course.cid="+Integer.toString(cid)+";");
			String courseName=rSetTemp.getString(1);
			ResultSet rSet=sta.executeQuery("select sid,sName from "+courseName+";");
			while(rSet.next()){
				result.add(rSet.getString(1)+"  "+rSet.getString(2));
			}
			return result;
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			if (result.isEmpty()){
				return null;
			}else{
				return result;
			}
		}
	}
}
