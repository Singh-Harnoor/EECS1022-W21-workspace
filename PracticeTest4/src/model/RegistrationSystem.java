package model;

public class RegistrationSystem {
	private Transcript[] transcripts;
	
	public RegistrationSystem() {
		this.transcripts = new Transcript[0];
	}
	
	public Transcript[] getReport() {
		return this.transcripts;
	}
	
	public int getMarks(String studentId, String course) {
		int marks =-1;
		
		for (int i = 0 ; i < this.transcripts.length; i++) {
			if (this.transcripts[i].getStudentID().equals(studentId)) {
				marks = this.transcripts[i].getMarks(course);
			}
		}
		return marks;
	}
	
	
	public void addTranscript(Transcript t) {
		Transcript[] temp = new Transcript[this.transcripts.length + 1];
		for(int i = 0; i < this.transcripts.length; i++) {
			temp[i] = this.transcripts[i];
		}
		temp[this.transcripts.length] = t;
		
		this.transcripts = temp;
	}
	
	
	
	
}
