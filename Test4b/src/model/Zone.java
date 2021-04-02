package model;

public class Zone {
	private int nodvd;
	private String zoneId;
	static int lastNum = 23;
	private MovieRecord[] movieRecords;
	private String status;
	private boolean error;
	private String Error;
	
	
	public Zone(int dvd) {
		this.nodvd = dvd;
		this.zoneId = "Zone-" + Zone.lastNum;
		Zone.lastNum += 11;
		this.movieRecords = new MovieRecord[0];
		this.error = false;
	}
	
	
	public String getID() {
		return this.zoneId;
	}
	public int getRemainigDvd() {
		return this.nodvd - this.getNumberOfMovieDVDs();
	}
	
	public int getNumberOfMovieRecords() {
		return this.movieRecords.length;
	}
	
	public MovieRecord[] getMovieRecords() {
		return this.movieRecords;
	}
	public int getNumberOfMovieDVDs() {
		int num = 0;
		if(this.movieRecords.length > 0) {
			for (int i = 0; i < this.movieRecords.length; i++){
				num += this.movieRecords[i].getNumberOfDVDs();
			}
		}
		return num;
	}
	
	public String getStatus() {
		if(!this.error) {
			status = this.getNumberOfMovieRecords() + " records and "+ this.getNumberOfMovieDVDs()+ " DVDs: {";
			for (int i = 0; i < this.movieRecords.length; i++) {
				status += this.movieRecords[i].getName() + " (" + this.movieRecords[i].getNumberOfDVDs() + ")";
				if (i < this.movieRecords.length - 1) {
					status += ", ";
				}
			}
			status += "}";
		}
		else {
			status = Error;
		}	
		return this.status;
	}
	
	public void addMovieRecord(MovieRecord r) {
		int sum = 0;
		for (int i = 0; i < this.movieRecords.length; i++) {
			sum += this.movieRecords[i].getNumberOfDVDs();
		}
		if (sum + r.getNumberOfDVDs() <= this.nodvd) {
			boolean present = false;
			int index = -1;
			MovieRecord[] temp = new MovieRecord[this.movieRecords.length + 1];
			for (int i = 0; i < this.movieRecords.length; i++) {
				temp[i] = this.movieRecords[i];
				if (this.movieRecords[i].getName().equals(r.getName())) {
					present = true;
					index = i;
				}
			}
			if (!present) {
				temp[this.movieRecords.length] = r;
				this.movieRecords = temp;
			}
			else {
				this.movieRecords[index].changeNumberofDVDs(r.getNumberOfDVDs());
			}
			
			
		}
		else if(sum == this.nodvd) {
			this.error = true;
			this.Error = "Error: maximum number of movie DVDs ("+this.nodvd+") reached";
		}
		else if (sum + r.getNumberOfDVDs() > this.nodvd) {
			this.error = true;
			this.Error = "Error: insufficient space left in the zone ("+ (sum + r.getNumberOfDVDs() - this.nodvd)+" DVDs short)";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
