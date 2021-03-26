package model;

public class Warehouse {
	// Attributes
	private int capacity;
	private Equipment[] equipments;
	
	// Constructors
	public Warehouse(int maxCapacity) {
		this.capacity = maxCapacity;
		this.equipments = new Equipment[0];
	}
	
	// Accessor
	
	public Equipment[] getEquipments() {
		return this.equipments;
	}
	
	
	public Equipment[] getEquipments(String[] names) {
		int size = 0;
		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < this.equipments.length; j++ ) {
				if (this.equipments[j] != null) {
					String eqname = this.equipments[j].getName();
					if (names[i].equals(eqname)) {
						size++;
					}
				}
			}
		}
		Equipment[] equi = new Equipment[size];
		int index = 0;
		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < this.equipments.length; j++ ) {
				if (this.equipments[j] != null) {
					if (names[i].equals(this.equipments[j].getName())) {
						equi[index] = this.equipments[j];
						index++;
					}
				}
			}
		}
		
		
		return equi;
	}
	
	
	public Equipment[] getEquipmentsWithinRange(int l, int u) {
		Equipment[] equi;
		int index = 0;
		int count = 0;
		if (this.equipments.length >= 1) {
			for (int i = 0; i < this.equipments.length; i++) {
				if (this.equipments[i].getStock() >= l && this.equipments[i].getStock() <= u) {
					count++;
				}
			}
			equi = new Equipment[count];
			for (int i = 0; i < this.equipments.length; i++) {
				if (this.equipments[i].getStock() >= l && this.equipments[i].getStock() <= u) {
					equi[index] = this.equipments[i];
					index++;
				}
			}
		}
		else {
			equi = new Equipment[0];
		}
		return equi;
		
	}
	
	public Equipment getEquipment(String name) {
		Equipment e = null;
		for (int i = 0; i < this.equipments.length; i++) {
			if(name.equals(equipments[i].getName())) {
				e = equipments[i];
			}
		}
		return e;
	}
	
	
	// Mutators
	public void addEquipment(Equipment e) {
		boolean b = true;
		for (int i = 0; i < this.equipments.length; i++) {
			if (e.getName().equals(this.equipments[i].getName())) {
				this.equipments[i].addStock(e.getStock());
				b = false;
			}
		}
			if (this.equipments.length < this.capacity && b) {
				int len = this.equipments.length + 1;
				Equipment[] temp = new Equipment[len];
				
				for (int i = 0; i < this.equipments.length; i++) {
					temp[i] = this.equipments[i];
				}
				temp[this.equipments.length] = e;
			
				this.equipments = temp;
			}
		}
		
		
		
	
	public void addStock(String name, int n) {
		for (int i = 0; i < this.equipments.length; i++) {
			if(name.equals(this.equipments[i].getName())) {
				this.equipments[i].addStock(n);
			}
		}
	}
	
	
	
	
	
}
