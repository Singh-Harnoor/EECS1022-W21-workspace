package model;

public class Member {
	/*
	 * Attributes (class-level variable; all methods can access them)
	 */
	// private variables are only accessible within the current class.
	// for other classes to access these private variables, call a public accessor methods (encapsulation)
	private int id; // e.g., 123456
	private int type; // e.g., 's' for silver, 'b' for bronze (10% discount rate on facilities), 'g' for golden (15%)
	private double balance;
	
	private String name;
	
	private double weight;
	private double height;
	/*
	 * Constructors (create instances of the current class)
	 */
	// without declaring any constructor explicitly, a default constructor is available
	
	public Member() { // an explicitly-declared default constructor
		// Do nothing
	}
		
	public Member(int id, char type, double balance) {
		this.id = id;// LHS 'this.id' denotes the attribute 'id', whereas RHS 'id' denotes the parameter 'id'.
		this.type = type;
		this.balance = balance;
	}
	
	public Member(String name, int id, char type, double balance) {
		this(id, type, balance); // calling another constructor Member(int, char, double) [Helper constructor]
		this.name = name;
	}
	
	// Assumptions: weight in kg, height in centimeters
	public Member(double weight, double height) {
		this.weight = weight;
		this.height = height;
	}
	/*
	 * Accessor methods (return some useful method)
	 */
	
	public double getWeight() {
		return this.weight;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public String getBMIreport() {
		String result = "";
		double heightInMeters = this.height/100;
		double bmi = this.weight/(heightInMeters*heightInMeters);
		
		String interpretation = "";
		if (bmi < 18.5) {
			interpretation = "Underweight";
		}
		else if(bmi < 25.0) {
			interpretation = "Normal";
		}
		else if(bmi < 30.0) {
			interpretation = "Overweight";
		}
		else {
			interpretation = "Obese";
		}
		
		result = interpretation + " (" + String.format("%.1f", bmi) + ")";
		return result;
	}
	/*
	 *  Mutator Methods (not returning anything; modifying attributes)
	 */
	
	public void changeWeightBy(double units) {
		this.weight += units;
	}
	
}
