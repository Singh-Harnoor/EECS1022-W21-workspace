package model;

public class Store {
	private Zone[] zones;
	
	public Store() {
		this.zones = new Zone[0];
	}
	
	public Zone[] getZones() {
		return this.zones;
	}
	
	public int[] getStats(String movie) {
		int[] stats = new int[2];
		int count = 0;
		int dvd = 0;
		for (int i = 0; i < this.zones.length; i++) {
			for (int j = 0; j < this.zones[i].getNumberOfMovieRecords(); j++) {
				if (this.zones[i].getMovieRecords()[j].getName().equals(movie)) {
					count++;
				}
			}
		}
		for (int i = 0; i < this.zones.length; i++) {
			for (int j = 0; j < this.zones[i].getNumberOfMovieRecords(); j++) {
				if (this.zones[i].getMovieRecords()[j].getName().equals(movie)) {
					dvd += this.zones[i].getMovieRecords()[j].getNumberOfDVDs();
				}
			}
		}
		
		stats[0] = count;
		stats[1] = dvd;
		return stats;
		
	}
	
	public Zone[] getZones(int remainig) {
		int count = 0;
		for (int i = 0; i < this.zones.length; i++) {
			if (this.zones[i].getRemainigDvd() <= remainig) {
				count++;
			}
		}
		Zone[] z  = new Zone[count];
		int index = 0;
		for (int j = 0; j < this.zones.length; j++) {
			if (this.zones[j].getRemainigDvd() <= remainig) {
				z[index]  = this.zones[j];
				index++;
			}
		}
		
		return z;
	}
	
	
	
	public void addZones(Zone[] zones) {
		Zone[] z = new Zone[this.zones.length +  zones.length];
		int index = 0;
		for (int i = 0; i < this.zones.length; i++) {
			z[i] = this.zones[i];
			index++;
		}
		for (int j = 0; j < zones.length; j++) {		
			z[index] = zones[j];
			index ++;
		}
		this.zones = z;
	}
	
	
	
	
}
