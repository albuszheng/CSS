package contrillor;

import java.util.ArrayList;

import data.Teacher;
import dataBaseLink.Courses;
import dataBaseLink.Students;
import dataBaseLink.Teachers;

public class TeacherService {
	Teacher teacher = Teacher.getInstance();
	dataBaseLink.Admin adminDB = new dataBaseLink.Admin();
	dataBaseLink.Students studentsDB = new Students();
	dataBaseLink.Teachers teachersDB = new Teachers();
	dataBaseLink.Courses courseDB = new Courses();

	public void announceCourse(String name, String credit, String classroom,
			String hours, String time, String optional) {
		if (teacher.getLoginStatus()) {
			courseDB.createNewCourse(name, credit, classroom, hours, time,
					optional, Integer.parseInt(teacher.getUserId()));
		}
	}

	public ArrayList<String> showCourse(int tid) {
		if (teacher.getLoginStatus()){
			ArrayList<String> results=courseDB.show(tid);
			return results;
		}else{
			return null;
		}
	}
	
	public String showCourse(int tid,int cid){
		if (teacher.getLoginStatus()){
			return courseDB.show(tid, cid);
		}else{
			return null;
		}
	}

	public ArrayList<String> showStudents(int cid) {
		if (teacher.getLoginStatus()){
			return courseDB.showStudents(cid);
		}else{
			return null;
		}
	}

	public void updateCourse() {
		if (teacher.getLoginStatus()){
			
		}
	}

	public void recordScore(String sid,String courseName,String score) {
		if (teacher.getLoginStatus()){
			courseDB.enterGrades(sid, courseName, score);
		}
	}

	public void announceTA(String sid,String courseName) {
		if (teacher.getLoginStatus()){
			courseDB.appointTA(sid, courseName);
		}
	}
}
