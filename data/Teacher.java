package data;

import java.util.ArrayList;

public class Teacher extends User {

	/**
	 * 
	 */
	private static Teacher instance = new Teacher();
	private ArrayList<String> courseList;
	private String name;

	private Teacher() {

	}

	private Teacher(String id, String password, String name) {
		super(id, password);
		this.name = name;
		this.courseList = new ArrayList<String>();
	}

	public static synchronized Teacher getInstance() {
		if (instance == null) {
			instance = new Teacher();
		}
		return instance;
	}

	public ArrayList<String> getCourseList() {
		return courseList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		String fullStr = "";
		String temp = "";
		fullStr = fullStr + this.name + ", " + this.userId + ", ";
		for (String s : courseList) {
			temp = temp + s + " ";
		}
		fullStr = fullStr + temp;
		return fullStr;
	}
}
