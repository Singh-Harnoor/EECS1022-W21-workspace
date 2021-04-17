package model;

public class BirthdayBookEntry {
	
	/*
	 * This class is only used for V1: Array list
	 */
	private String name;
	private Birthday birthday;
	
	public BirthdayBookEntry(String name, Birthday birthday) {
		this.name = name;
		this.birthday = birthday;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Birthday getBirthday() {
		return this.birthday;
	}
	
}
