package model;

public class Transcript {
	
	static int multiplier = 3;
	
	private String studentName;
	private Registration[] registrations;
	private String studentId;
	private int nof = 60;
	
	public Transcript(String name) {
		this.studentName = name;
		this.studentId = name + Transcript.multiplier;
		this.registrations = new Registration[0];
		multiplier += 3;	
	}
	
	public String getStudentID() {
		return this.studentId;
	}
	
	public Registration[] getReport() {
		return this.registrations;
	}
	
	public int getMarks(String course) {
		int marks = -1;
		for(int i = 0; i < this.registrations.length; i++) {
			if (course.equals(this.registrations[i].getCourseName())) {
				marks = this.registrations[i].getMarks();
			}
		}
		return marks;
	}
	
	public double getWeightedGPA() {
		double gpa = 0;
		double sum = 0;
		for (int i = 0; i < this.registrations.length; i++) {
			sum += this.registrations[i].getWeightedGradePoint();
		}
		gpa = sum/this.registrations.length;
		return gpa;
	}
	
	
	
	public void setMarks(String course, int marks) {
		for(int i = 0; i < this.registrations.length; i++) {
			if (course.equals(this.registrations[i].getCourseName())) {
				this.registrations[i].setMarks(marks);
			}
		}
	}
	
	
	public void addRegistration(Registration r) {
		Registration[] temp = new Registration[this.registrations.length + 1];
		for(int i = 0; i < this.registrations.length; i++) {
			temp[i] = this.registrations[i];
		}
		temp[this.registrations.length] = r;
		
		this.registrations = temp;
	}
	
	public void addRegistration(String course, int credits) {
		Registration[] temp = new Registration[this.registrations.length + 1];
		for(int i = 0; i < this.registrations.length; i++) {
			temp[i] = this.registrations[i];
		}
		temp[this.registrations.length] = new Registration(course, credits);
		
		this.registrations = temp;
	}
	
	public void addRegistrations(Registration[] registrations) {
		Registration[] temp = new Registration[this.registrations.length + registrations.length];
		int index = 0;
		for(int i = 0; i < this.registrations.length; i++) {
			temp[i] = this.registrations[i];
			index++;
		}
		for(int j = 0; j < registrations.length; j++) {
			temp[index] = registrations[j];
			index++;
		}
		
		this.registrations = temp;
	}
	
	
	
	
	
	
	
	
	
	
}
