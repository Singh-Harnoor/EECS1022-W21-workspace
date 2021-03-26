package model;

public class Customer {
	// Attributes 
	private String name;
	private Record[] records;
	private int nor;
	private double balance;
	private double pay;
	
	// Constructors 
	public Customer() {
		this.records = new Record[0];
	}
	
	public Customer(String name) {
		this();
		this.name = name;
		this.balance = 0;
	}
	
	public Customer(String name, double balance) {
		this();
		this.name = name;
		this.balance = balance;
	}
	
	// Accessor
	
	public String getName() {
		return this.name;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public Record[] getRecords() {
		return this.records;
	}
	
	public double getAmountDue() {
		for (int i=0; i < this.records.length; i++) {
			this.pay += (this.records[i].getPrice()) * (this.records[i].getQuantity()) ;
		}
		if (this.records.length == 0) {
			 this.pay = 0;
		}
		return this.pay;
		
	}
	
	public Record[] getRecordsLargerThan(int n) {
		int k = 0;
		for (int i = 0; i < this.records.length; i++) {
			if (this.records[i].getPrice() * this.records[i].getQuantity() >= n) {
				k++;
			}
		}
		Record[] rec = new Record[k];
		int m = 0;
		for (int i = 0; i < this.records.length; i++) {
			if (this.records[i].getPrice() * this.records[i].getQuantity() > n) {
				rec[m] = this.records[i];
				m++;
			}
		}
		return rec;
	}
	
	// Mutators 
	
	public void deposit(double dep) {
		this.balance += dep;
	}
	
	public void addRecord(Record r) {
		int len = this.records.length + 1;
		Record[] temp = new Record[len];
		
		for (int i = 0; i < this.records.length; i++) {
			temp[i] = this.records[i];
		}
		temp[this.records.length] = r;
		
		this.records = temp;
		
	}
	
	public void addRecord(String item, double unitPrice, int quantity) {
		Record r = new Record(item, unitPrice, quantity);
		int len = this.records.length + 1;
		Record[] temp = new Record[len];
		
		for (int i = 0; i < this.records.length; i++) {
			temp[i] = this.records[i];
		}
		temp[this.records.length] = r;
		
		this.records = temp;
		
	}
	
	public void addRecords(Record[] records) {
		int len = records.length + this.records.length;
		Record[] temp = new Record[len];
		int j = 0;
		for (int i = 0; i < this.records.length; i++) {
			temp[i] = this.records[i];
			j++;
		}
		for (int i = 0; i < records.length; i++) {
			temp[j] = records[i];
			j++;
		}
		
		this.records = temp;
	}
	
	public void setRecords() {
		this.records = new Record[0];
	}
	
	
	
	
	
	
}
