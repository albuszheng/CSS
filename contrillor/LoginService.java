package contrillor;

import data.LoginUser;
import data.Student;
import data.Teacher;
import dataBaseLink.Courses;
import dataBaseLink.Students;
import dataBaseLink.Teachers;

public class LoginService {
	data.Admin admin = data.Admin.getInstance();
	Student student = Student.getInstance();
	Teacher teacher = Teacher.getInstance();
	dataBaseLink.Admin adminDB = new dataBaseLink.Admin();
	dataBaseLink.Students studentsDB = new Students();
	dataBaseLink.Teachers teachersDB = new Teachers();
	dataBaseLink.Courses courseDB = new Courses();

	public LoginUser login(String id, String password) {
		@SuppressWarnings("unused")
		boolean isLogin = false;
		LoginUser newLoginUser = null;
		if (id.charAt(0) == 'a') {
			if (adminDB.getPassword().equals(password)) {
				isLogin = true;
				newLoginUser = LoginUser.teacher;
				admin.setLoginStatus(true);
			}
		}

		return newLoginUser;
	}

	public LoginUser login(String tarUser, int id, String password) {
		@SuppressWarnings("unused")
		LoginUser newLoginUser = null;
		char tempChar = tarUser.charAt(0);
		switch (tempChar) {
		case 't': {
			if (teachersDB.getPassword(id).equals(password)) {
				newLoginUser = LoginUser.teacher;
				teachersDB.setInstance(id);
				teacher.setLoginStatus(true);
			}
			break;
		}
		case 's': {
			if (studentsDB.getPassword(id).equals(password)) {
				newLoginUser = LoginUser.student;
				studentsDB.setInstance(id);
				student.setLoginStatus(true);
			}
			break;
		}
		}
		return null;
	}

	public boolean regester(String tarUser, String id, String password) {
		boolean isSucceed = false;
		char tempChar = tarUser.charAt(0);
		switch (tempChar) {
		case 't': {
			teachersDB.registerNewTeacher(Integer.parseInt(id), null, password);
			isSucceed = true;
			break;
		}
		case 's': {
			studentsDB.registerNewStudents(Integer.parseInt(id), null,
					password, null);
			isSucceed = true;
			break;
		}
		}
		return isSucceed;
	}

	public boolean regester(String tarUser, String id, String password,
			String name, String grade) {
		boolean isSucceed = false;
		char tempChar = tarUser.charAt(0);
		switch (tempChar) {
		case 't': {
			teachersDB.registerNewTeacher(Integer.parseInt(id), name, password);
			isSucceed = true;
			break;
		}
		case 's': {
			studentsDB.registerNewStudents(Integer.parseInt(id), name,
					password, grade);
			isSucceed = true;
			break;
		}
		}
		return isSucceed;
	}
}
