package model;

public class OnlineSchool {

	private Participant[] participants; 
	
	// Constructor
	public OnlineSchool() {
		this.participants = new Participant[0];
	}
	
	// Accessor
	public Participant[] getParticipants(String course) {
		
		Participant[] participants;
		int counter = 0;
		
		for (int i = 0; i < this.participants.length; i++) {
			Registration[] reg = this.participants[i].getRegistrations();
			
			for (int j = 0; j < reg.length; j++) {
				if (reg[j].getTitle().equals(course)) {
					counter += 1;
				}
			}
			
		
			
		}
		
		participants = new Participant[counter];
		int count = 0;
		for (int i = 0; i < this.participants.length; i++) {
			Registration[] reg = this.participants[i].getRegistrations();
			
			for (int j = 0; j < reg.length; j++) {
				if (reg[j].getTitle().equals(course)) {
					participants[count] = this.participants[i];
					count++;
				}
			}
			
		}
		
		
		return participants;
	}
	
	
	// Mutator
	
	public void addParticipant(Participant p) {
		if (this.participants.length < 100) { 
			Participant[] temp = new Participant[this.participants.length + 1];
			
			for (int i = 0; i < this.participants.length; i++) {
				temp[i] = this.participants[i];
			}
			temp [this.participants.length] = p;
			this.participants = temp;
		}
	}
	
	
	
	
	
	
}
