package model;

public class MovieRecord {
	private int nodvd;
	private String movieName;
	private Zone zone;
	private String movieID;
	static int integer = 1;
	
	public MovieRecord(String name, int numdvd, Zone z) {
		this.movieName = name;
		this.nodvd = numdvd;
		this.zone = z;
		this.movieID = this.zone.getID()  + "-"+  this.movieName + "-" +MovieRecord.integer;
		MovieRecord.integer += 1;
	}
	
	public String getName() {
		return this.movieName;
	}
	
	public int getNumberOfDVDs() {
		return this.nodvd;
	}
	
	public Zone getZone() {
		return this.zone;
	}
	
	public String getID() {
		return this.movieID;
	}
	
	public void changeNumberofDVDs(int n) {
		this.nodvd += n;
	}
	
	
}
