package data;

import java.util.ArrayList;


public class Student extends User{


	/**
	 * 
	 */
	private static Student instance=new Student();
	private ArrayList<Grade> gradeList;
	private String name;
	private boolean TA;
	private String TAlesson;
	
	private Student (){
		
	}
	
	private Student(String name,String id, String password,boolean Ta,String Talesson) {
		super(id, password);
		this.name=name;
		this.TA=Ta;
		this.TAlesson=Talesson;
	}
	
	public static synchronized Student getInstance(){
		if (instance==null){
			instance=new Student();
		}
		return instance;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isTA() {
		return TA;
	}
	public void setTA(boolean tA) {
		TA = tA;
	}
	
	public double getScore(String CourseID){
		for (Grade g:gradeList){
			if (CourseID.equals(g.CourseID)){
				return g.score;
			}
		}
		return -1;
	}
	
	
	public void setScore(String CourseID,double score){
		for (Grade g:gradeList){
			if (CourseID.equals(g.CourseID)){
				g.score=score;
			}
		}
	}
	
	public String getTAlesson() {
		return TAlesson;
	}

	public void setTAlesson(String tAlesson) {
		TAlesson = tAlesson;
	}

	public String toString(){
		String fullStr="";
		fullStr=fullStr+name+", "+userId;
		if (TA){
			fullStr=fullStr+", "+TAlesson+"  ";
		}else{
			fullStr=fullStr+"  ";
		}
		for (Grade g:gradeList){
			fullStr=fullStr+g.toString()+"  ";
		}
		return fullStr;
	}
	
}

class Grade{
	String CourseID;
	double score;
	public Grade(String CourseId,double sco){
		this.CourseID=CourseId;
		this.score=sco;
	}
	
	public String toString(){
		String temp=CourseID+":"+score;
		return temp;
	}
}