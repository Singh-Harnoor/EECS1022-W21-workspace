package model;

public class Equipment {
	// Attributes
	private String name;
	private int stock;
	private String status;
	
	// Constructor
	
	public Equipment(String name) {
		this.name = name;
		this.status = "Equipment: " + this.name + " (" + this.stock  +")";
	}
	
	// Accessor
	
	public String getName() {
		return this.name;
	}
	
	public int getStock() {
		return this.stock;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	// Mutators
	
	public void addStock(int n) {
		if (n > 0) {
			this.stock += n;
			this.status = "Equipment: " + this.name + " (" + this.stock  +")";
		}
		else {
			this.status = "Error: non-positive quantity " + n;
		}
	}
	
	public void removeStock(int n) {
		if (n > 0) {
			if (n <= this.stock) {
				this.stock -= n;
				this.status = "Equipment: " + this.name + " (" + this.stock  +")";
			}
			else {
				this.status = "Error: quantity is short of " + (n - this.stock);
			}
		}
		else {
			this.status = "Error: non-positive quantity " + n;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
