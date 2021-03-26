package model;

public class Registration {
	// Attributes 
	private String title;
	private int marks;
	private Instructor instructor;
	
	
	// Constructors
	public Registration() {
		
	}
	
	public Registration(String title) {
		this.title = title;
	}
	
	public Registration(String title, int marks) {
		this.title = title;
		this.marks = marks;
	}
	
	public Registration(String title, int marks, Instructor instructor) {
		this.title = title;
		this.marks = marks;
		this.instructor = instructor;
	}
	
	public Registration(String title, Instructor instructor) {
		this.title = title;
		this.instructor = instructor;
	}
	
	// Accessor
	public String getTitle() {	
		return this.title;
	}
	
	public int getMarks() {
		return this.marks;
	}
	
	public Instructor getInstructor() {
		return this.instructor;
	}
	
	public String[] getGradeReport() {
		String[] report = new String[2];  
		
		if (marks >= 90) {
			report[0] = "A+";
			report[1] = "Exceptional";
		}
		else if (marks >= 80) {
			report[0] = "A";
			report[1] = "Excellent";
		}
		else if (marks >= 70) {
			report[0] = "B";
			report[1] = "Good";
		}
		else if (marks >= 60) {
			report[0] = "C";
			report[1] = "Competent";
		}
		else if (marks >= 50) {
			report[0] = "D";
			report[1] = "Passing";
		}
		else {
			report[0] = "F";
			report[1] = "Failing";
		}
		
		return report;
	}
	
	
	public String getInformation() {
		String info = "";
		
		if (this.instructor == null) {
			info =  this.title + " has not yet been assigned an instructor";
		}
		else {
			info = this.title + ", taught by "+ this.instructor.getName() +", is completed with raw marks "+ this.marks+ " ("+ this.getGradeReport()[0] +" ; "+ this.getGradeReport()[1]+")";                             
		}
		
		return info;
	}
	
	// Mutators
	
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
}
