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
	
	/* Single-valued, reference-typed attribute*/
	
	private Trainer trainer; // stores a single Trainer object's address 
	
	/* Multi- valued, reference-typed attribute*/
	
	private final int MAX_NUMBER_OF_FACILITIES = 6; /* Assumption: each member can book for up to 6 facilities */
	private Facility[] facilities; // stores an array of Facility objects' addresses
	private int nof; // Number of facilities
	
	/*
	 * There are two purposes of 'nof' attribute;
	 * 1) Records how many facility objects have been stored in facilities array so far.
	 * 2) Indicates the index into 'facilities' array for storing the next Facility object's address.
	 */
	
	
	
	/*Exercise (after reading the written notes) */
	
	public double getPaymentDue() {
		// go over the facilities of the member, and add up the price * unit of each booked facility.
		double result = 0.0;
		for (int i = 0; i < this.nof; i++) {
			/*
			 * Alternatively: 
			 * Facility f = this.facilities[i]
			 * result += f.getPaymentDue();
			 */
			result += this.facilities[i].getPaymentDue();
		}
		return result;
	}
	/*
	 * Constructors (create instances of the current class)
	 */
	// without declaring any constructor explicitly, a default constructor is available
	
	public Member() { // an explicitly-declared default constructor
		// default actions applicable to all other versions of constructor
		this.facilities = new Facility[MAX_NUMBER_OF_FACILITIES];
		this.nof = 0;
	}
	
	public Member(String name) { // Variable shadowing 
		this(); // calling the constructor performing default actions
		this.name = name;
	}
	
	public Member(int id, char type, double balance) {
		this(); // calling the constructor performing default actions
		this.id = id;// LHS 'this.id' denotes the attribute 'id', whereas RHS 'id' denotes the parameter 'id'.
		this.type = type;
		this.balance = balance;
	}
	
	// You can only call a maximum one helper constructor as the first line.
	public Member(String name, int id, char type, double balance) {
		// Calling the helper constructor below will also in turn call the other helper constructor performing the default actions.
		this(id, type, balance); // calling another constructor Member(int, char, double) [Helper constructor]
		this.name = name;
	}
	
	// Assumptions: weight in kg, height in centimeters
	public Member(double weight, double height) {
		this(); // calling the constructor performing default actions
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
	
	public Trainer getTrainer() {
		return this.trainer;
	}
	
	public int getNumberOfFacilities() {
		return this.nof;
	}
	
	public int getFacilityUnits(String name) {// Assumption: facility names are unique
		Facility f = this.getFacility(name);
		int units = -1;
		if( f != null) {
			units = f.getUnits();
		}
		return units;
	}
	
	private Facility getFacility(String name) {
		Facility f = null;
		boolean hasFound = false;
		for (int i = 0; !hasFound && i < this.nof; i++) {
			if (this.facilities[i].getName().equals(name)) {
				f = this.facilities[i];
				hasFound = true;
			}
		}
		return f;
	}
	
	/*
	 *  Mutator Methods (not returning anything; modifying attributes)
	 */
	
	public void changeWeightBy(double units) {
		this.weight += units;
	}
	
	/*
	 * version where there is no clash between parameter 't' and attribute 'trainer'
	 * therefore, the 'this' keyword is not necessary 
	 */
	
//	public void registerTrainer(Trainer t) {
//		trainer = t;
//	}
	
	public void registerTrainer(Trainer trainer){// Variable shadowing 
		this.trainer = trainer;
	}
	
	public void referTrainer(Member m) {
		this.trainer = m.getTrainer();
	}
	
	/*
	 * Exercise: swap the trainers of two members 
	 */
	
	public void swapTrainer(Member m) {
		// this.trainer should become m.trainer 
		// m.trainer should become this.trainer
		// Write some tests for this!	
	}
	
	public void addFacility(Facility f) {
		this.facilities[this.nof] = f;
		this.nof++;
	}
	
	/*
	 * Overloaded methods: methods with the same name, 
	 * but distinguished by distinct lists of parameter types.
	 */
	
	public void addFacility(String name, double price, int units) {
		Facility f = new Facility(name, price, units);
		this.addFacility(f);
	}
	
	public void extendFacilityUnits(String name, int howMany) {
		Facility f = this.getFacility(name);
		if (f!= null) /*hasFound == true */{
			f.setUnits(f.getUnits() + howMany);
		}
	}
	
	
}
