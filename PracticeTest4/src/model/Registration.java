package model;

public class Registration {
	
	private String courseName;
	private int courseCredits;
	private int courseRawMarks;
	
	
	public Registration(String name, int c) {
		this.courseCredits = c;
		this.courseName = name;
		this.courseRawMarks = 0;
	}
	
	public Registration(String name, int c, int marks){
		this(name, c);
		this.courseRawMarks = marks;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
	
	public int getNumberOfCredits() {
		return this.courseCredits;
	}
	
	public int getMarks() {
		return this.courseRawMarks;
	}
	
	public String getLetterGrade() {
		String letter = "";
		if (this.courseRawMarks >= 90) {
			letter = "A+";
		}
		else if (this.courseRawMarks >= 80) {
			letter = "A";
		}
		else if (this.courseRawMarks >= 70) {
			letter = "B";
		}
		else if (this.courseRawMarks >= 60) {
			letter = "C";
		}
		else if (this.courseRawMarks >= 50) {
			letter = "D";
		}
		else if (this.courseRawMarks < 50) {
			letter = "F";
		}
		return letter;
	}
	
	
	public int getWeightedGradePoint() {
		int gpa = 0;
		
		if (this.courseRawMarks >= 90) {
			gpa = 9;
		}
		else if (this.courseRawMarks >= 80) {
			gpa = 8;
		}
		else if (this.courseRawMarks >= 70) {
			gpa = 7;
		}
		else if (this.courseRawMarks >= 60) {
			gpa = 6;
		}
		else if (this.courseRawMarks >= 50) {
			gpa = 5;
		}
		else if (this.courseRawMarks < 50) {
			gpa = 0;
		}
		
		gpa = gpa * this.courseCredits;
		
		return gpa;
	}
	
	
	public void setMarks(int m) {
		this.courseRawMarks = m;
	}
	
	
	
	
	
}
