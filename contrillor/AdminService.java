package contrillor;

import java.util.ArrayList;

import dataBaseLink.Admin;
import dataBaseLink.Courses;
import dataBaseLink.Students;
import dataBaseLink.Teachers;

public class AdminService {
	Admin adminDB=new Admin();
	Courses coursesDB=new Courses();
	Students studentsDB=new Students();
	Teachers teachersDB=new Teachers();
	
	public void show(String table){
		char firstone=table.toUpperCase().charAt(0);
		switch (firstone){
		case 'C':{
			showList(coursesDB.show());
			break;
		}
		case 'S':{
			showList(studentsDB.show());
			break;
		}
		case 'T':{
			showList(teachersDB.show());
			break;
		}
		default:{
			
		}
		}
	}
	
	public void delete(String table,int Id){
		char firstone=table.toUpperCase().charAt(0);
		switch (firstone){
		case 'C':{
			coursesDB.delete(Id);
			break;
		}
		case 'S':{
			studentsDB.delete(Id);
			break;
		}
		case 'T':{
			teachersDB.delete(Id);
			break;
		}
		default:{
			
		}
		}
	}
	
	public void changePassword(String newPassword){
		adminDB.changePassword("admin", newPassword);
	}
	
	private void showList(ArrayList<String> lists){
		for (String s:lists){
			System.out.println(s);
		}
	}
	
	
}
