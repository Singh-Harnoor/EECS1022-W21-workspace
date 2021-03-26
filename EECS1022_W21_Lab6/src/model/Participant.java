package model;

public class Participant {
	private String name;
	private Registration[] registrations;
	

	// Constructors
	public Participant() {
		
	}
	
	public Participant(String name) {
		this.name = name;
		this.registrations = new Registration[0];
	}
	
	public Participant(String name, Registration[] registrations) {
		this.name = name;
		if (registrations.length <= 5) {
			this.registrations = registrations;
		}
		else {
			this.registrations = new Registration[5];
			for (int i = 0; i < registrations.length; i++) {
				this.registrations[i] = registrations[i];
			}	
			
		}
		
	}
	
	// Accessor 
	
	public Registration[] getRegistrations() {
		return this.registrations;
	}
	
	public String getGPAReport() {
		String report = "";
		if (this.registrations.length == 0) {
			report = "No GPA available yet for "+ this.name ;
		}
		else {
			report = this.name + "'s GPA of {";
			for (int i = 0; i < this.registrations.length; i++) {
				report += (int) (this.registrations[i].getMarks()/10);
				report += " (";
				report += this.registrations[i].getGradeReport()[0];
				report += ")";
				if ( i < this.registrations.length - 1) {
					report += ", ";
				}	
			
			}
			
			report += "}: ";
			
			double sum = 0.0;
			
			for (int i = 0; i < this.registrations.length; i++) {
				sum += (int) (this.registrations[i].getMarks() /10.0);
			}
			double gpa;
			if (this.registrations.length != 0) {
				gpa = sum/(this.registrations.length);
			}
			else {
				gpa = 0.0;
			}
			
			report += String.format("%.1f", gpa);
		}
		
		return report;
	
		}
	
	
	public int marksOf(String course) {
		int marks = -1;
		for (int i = 0; i < this.registrations.length; i++) {
			if (this.registrations[i].getTitle() == course){
				if (this.registrations[i] == null) {
					marks = -1;
				}
				else {
					marks = this.registrations[i].getMarks();
				}
				
			}
		}
		return marks;
		
		
	}
	
	// Mutators 
	
	public void addRegistration(Registration r1) {
		if (this.registrations.length < 5) { 
			Registration[] temp = new Registration[this.registrations.length + 1];
			
			for (int i = 0; i < this.registrations.length; i++) {
				temp[i] = this.registrations[i];
			}
			temp [this.registrations.length] = r1;
			this.registrations = temp;
		}
	}
	
	public void addRegistration(String title) {
		Registration reg = new Registration(title);
		
		
		if (this.registrations.length < 5) { 
			Registration[] temp = new Registration[this.registrations.length + 1];
			
			for (int i = 0; i < this.registrations.length; i++) {
				temp[i] = this.registrations[i];
			}
			temp [this.registrations.length] = reg;
			this.registrations = temp;
		}	
	}
	
	
	public void updateMarks(String title, int marks) {
		
		for (int i = 0; i < this.registrations.length; i++) {
			boolean eq = this.registrations[i].getTitle().equals(title);
			if (eq) {
				this.registrations[i].setMarks(marks);
			}
		}	
		
	}
	
	
	public void clearRegistrations() {
		this.registrations = new Registration[0];
	}
	
	
	

	
	
	
	
	
	
}
