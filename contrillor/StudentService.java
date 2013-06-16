package contrillor;

import java.util.ArrayList;

import data.Student;
import dataBaseLink.Courses;
import dataBaseLink.Students;
import dataBaseLink.Teachers;

public class StudentService {
	Student student = Student.getInstance();
	dataBaseLink.Admin adminDB = new dataBaseLink.Admin();
	dataBaseLink.Students studentsDB = new Students();
	dataBaseLink.Teachers teachersDB = new Teachers();
	dataBaseLink.Courses courseDB = new Courses();

	public ArrayList<String> showMycourses() {
		if (student.getLoginStatus()) {
			ArrayList<String> myCourse = courseDB.searchCourse(Integer
					.parseInt(student.getUserId()));
			return myCourse;
		}
		return null;
	}

	public boolean selectCourse(String courseName) {
		if (student.getLoginStatus()) {
			boolean result = courseDB.enrollToCourse(courseName,
					student.getName(), student.getUserId(), "N");
			return result;
		} else {
			return false;
		}
	}
//	
//	public boolean selectCourse(){
//		if (student.getLoginStatus()){
//			boolean result =courseDB.enrollToCourse(courseName, sname, sid, isTA)
//		}
//	}

	public void unenrollCourse(String courseName) {
		if (student.getLoginStatus()){
			courseDB.unEnrollCourse(student.getUserId(), courseName);
		}
	}

	public ArrayList<String> showMyscore() {
		if (student.getLoginStatus()){
			ArrayList<String> result=courseDB.searchCourse(Integer.parseInt(student.getUserId()));
			if (result!=null){
				return null;
			}else{
				return result;
			}
		}else{
			return null;
		}
	}

}
