package model;

public class Instructor {
	// Attributes
	private String name;
	private int campusPhoneExtention;
	private String email;
	
	// Constructor
	public Instructor(String name, int cpe, String email) {
		this.name = name;
		this.campusPhoneExtention = cpe;
		this.email = email;
		
	}
	
	// Accessor 
	public String getName() {
		return this.name;
	}
	
	public int getPhoneExtension() {
		return this.campusPhoneExtention;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getInformation() {
		
		String info = "Instructor " + this.name + " has campus phone extension " + this.campusPhoneExtention + " and contact email " + this.email;	
		return info;
	}
	
	// Mutators 
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhoneExtension(int cpe) {
		this.campusPhoneExtention = cpe;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}	
	
}
