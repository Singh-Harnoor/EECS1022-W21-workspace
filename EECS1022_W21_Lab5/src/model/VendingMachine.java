package model;

public class VendingMachine {
	// Attributes
	private int coke;
	private int orangeJuice;
	private int kitkatChukyBar;
	private int laysClassicChips;
	
	private String status;
	
	// Constructor
	public VendingMachine() {
		this.status = "Empty VM Started";
		this.coke = 0;
		this.orangeJuice = 0;
		this.kitkatChukyBar = 0;
		this.laysClassicChips = 0;
	}
	
	// Accessors
	public String checkStock() {
		String result = "";
		result += "Stock: Coke ("+ this.coke + "), Orange Juice ("+ this.orangeJuice + "), Kitkat Chunky Bar ("+ this.kitkatChukyBar + "), Lay's Classic Chips ("+ this.laysClassicChips +")";
		return result;
	}
	
	public String checkStock(String product) {
		String result = "";
		if (product == "Coke") {
			result += product + " (" + this.coke + ")";
		}
		else if (product == "Orange Juice") {
			result += product + " (" + this.orangeJuice + ")";
		}
		else if (product == "Kitkat Chunky Bar") {
			result += product + " (" + this.kitkatChukyBar + ")";
		}
		else if (product == "Lay's Classic Chips") {
			result += product + " (" + this.laysClassicChips + ")";
		}
		else {
			result += "Invalid product: " + product;
		}
		
		
		return result;
	}
	
	public String checkStatus() {		
		return this.status;
	}
	
	// Mutators
	public void add(String product, int numItems) {
		if (product == "Coke") {
			this.coke += numItems;
			this.status = "Product added: "+ product +" ("+ numItems +")";
		
		}
		else if (product == "Orange Juice") {
			this.orangeJuice += numItems;
			this.status = "Product added: "+ product +" ("+ numItems +")";
		}
		else if (product == "Kitkat Chunky Bar") {
			this.kitkatChukyBar += numItems;
			this.status = "Product added: "+ product +" ("+ numItems +")";
		}
		else if (product == "Lay's Classic Chips") {
			this.laysClassicChips += numItems;
			this.status = "Product added: "+ product +" ("+ numItems +")";
		}
		else {
			this.status = "Invalid product: " + product;
		}
	}
	
	public void dispense(String product, int numItems) {
		if (product == "Coke") {
			this.coke -= numItems;
			if (this.coke < 0){
				this.coke = 0;
			}
			this.status = "Product removed: "+ product +" ("+ numItems +")";
		
		}
		else if (product == "Orange Juice") {
			this.orangeJuice -= numItems;
			if (this.orangeJuice < 0){
				this.orangeJuice = 0;
			}
			this.status = "Product removed: "+ product +" ("+ numItems +")";
		}
		else if (product == "Kitkat Chunky Bar") {
			this.kitkatChukyBar -= numItems;
			if (this.kitkatChukyBar < 0){
				this.kitkatChukyBar = 0;
			}
			this.status = "Product removed: "+ product +" ("+ numItems +")";
		}
		else if (product == "Lay's Classic Chips") {
			this.laysClassicChips -= numItems;
			if (this.laysClassicChips < 0){
				this.laysClassicChips = 0;
			}
			this.status = "Product removed: "+ product +" ("+ numItems +")";
		}
		else {
			this.status = "Invalid product: " + product;
		}
	}
	
	
}
