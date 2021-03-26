package model;

public class Record {
	
	private String item;
	private double unitPrice;
	private int quantity;
	
	// Constructor
	public Record(String item, double unitPrice, int quantity) {
		this.item = item;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
	public Record() {
		// default constructor
	}
	
	public Record(String item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}
	
	public Record(String item) {
		this.item = item;
	}
	
	public Record(String item, double unitPrice) {
		this.item = item;
		this.unitPrice = unitPrice;
	}
	
	
	// Accessor
	public String getItem() {
		return this.item;
	}
	
	public double getPrice() {
		return this.unitPrice;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	// Mutators
	public void setItem(String item) {
		this.item = item;
	}
	
	public void setPrice(double price) {
		this.unitPrice = price;
	}
	
	public void setQuantity(int quant) {
		this.quantity = quant;
	}
	
}
