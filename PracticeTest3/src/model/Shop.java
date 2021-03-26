package model;

public class Shop {
	// Attributes
	Customer[] customers = new Customer[0];
	
	// constructor
	public Shop() {
		// default constructor
	}
	
	// Accessor
	public Customer[] getCustomers() {
		return this.customers;
	}
	
	// Mutators
	public void addCustomer(Customer c) {
		int len = this.customers.length + 1;
		Customer[] temp = new Customer[len];
		
		for (int i = 0; i < this.customers.length; i++) {
			temp[i] = this.customers[i];
		}
		temp[this.customers.length] = c;
		
		this.customers = temp;
	}
	
	public void pay(String name) {
		for (int i = 0; i < this.customers.length; i++) {
			if (this.customers[i].getName().equals(name)) {
				double ammount =  - this.customers[i].getAmountDue();
				this.customers[i].deposit(ammount);
				this.customers[i].setRecords();
			}
		}
	}
	
}
