package model;

public class Grade {
	
	public static String getGradeReport(int marks) {
		String report = "";
		/*Stage 1: Get the letter grade for the 'marks'*/
		// Calling getLetterGrade1 as a helper method
		String lg = getLetterGrade1(marks);
		
		/*Stage 2: Determine if the letter grade corresponds to a good performance (C or above)*/
		boolean didwell = lg.equals("A+") || lg.equals("A") || lg.equals("B+")|| lg.equals("B")|| lg.equals("C+") || lg.equals("C");
		
		report += "Grade " + lg + ": ";
		
		if (didwell) {
			report += "Well Done!";
		}
		else { 
			report += "You Can Do Better Next Time!";
		}
		
		return report;
	}
	
	// Version 1: Correct
	public static String getLetterGrade1(int marks) {
		String lg = "";
		
		if (marks >= 90) {
			lg = "A+";
		}
		else if (marks >= 80) {
			lg = "A";
		}
		else if (marks >= 75) {
			lg = "B+";
		}
		else if (marks >= 70) {
			lg = "B";
		}
		else if (marks >= 65) {
			lg = "C+";
		}
		else if (marks >= 60) {
			lg = "C";
		}
		else if (marks >= 55) {
			lg = "D+";
		}
		else if (marks >= 50) {
			lg = "D";
		}
		else {
			lg = "F";
		}
		
		return lg;
	}
	
	public static String getLetterGrade2(int marks) {
		String lg = "";
		
		// Version 2: Incorrect version: multiple if-statements with overlapping
		
//		if (marks >= 90) {
//			lg = "A+";
//		}
//		if (marks >= 80) {
//			lg = "A";
//		}
//		if (marks >= 75) {
//			lg = "B+";
//		}
//		if (marks >= 70) {
//			lg = "B";
//		}
//		if (marks >= 65) {
//			lg = "C+";
//		}
//		if (marks >= 60) {
//			lg = "C";
//		}
//		if (marks >= 55) {
//			lg = "D+";
//		}
//		if (marks >= 50) {
//			lg = "D";
//		}
//		if (marks < 50) {
//			lg = "F";
//		}
		
		// Version 3: correct version: multiple if-statements without overlapping
		
		if (90 <= marks && marks <= 100) {
			lg = "A+";
		}
		if (80 <= marks && marks < 90) {
			lg = "A";
		}
		if (75 <= marks && marks < 80) {
			lg = "B+";
		}
		if (70 <= marks && marks < 75) {
			lg = "B";
		}
		if (65 <= marks && marks < 70) {
			lg = "C+";
		}
		if (60 <= marks && marks < 65) {
			lg = "C";
		}
		if (55 <= marks && marks < 60) {
			lg = "D+";
		}
		if (50 <= marks && marks < 55) {
			lg = "D";
		}
		if (0 <= marks && marks < 50) {
			lg = "F";
		}
		
		// Version 4: Replacing all the && with ||
//		if (90 <= marks || marks <= 100) {
//			lg = "A+";
//		}
//		if (80 <= marks || marks < 90) {
//			lg = "A";
//		}
//		if (75 <= marks || marks < 80) {
//			lg = "B+";
//		}
//		if (70 <= marks || marks < 75) {
//			lg = "B";
//		}
//		if (65 <= marks || marks < 70) {
//			lg = "C+";
//		}
//		if (60 <= marks || marks < 65) {
//			lg = "C";
//		}
//		if (55 <= marks || marks < 60) {
//			lg = "D+";
//		}
//		if (50 <= marks || marks < 55) {
//			lg = "D";
//		}
//		if (0 <= marks || marks < 50) {
//			lg = "F";
//		}
		
		
		return lg;
	}
	
	
	public static String getLetterGrade3(int marks) {
		// Version 5: Nested if-statements
		String lg = "";
		
		
		if (marks >= 80) {
			if (marks >= 90) {
				lg = "A+";
			}
			else {
				lg = "A";
			}
		}
		else if (marks >= 75) {
			lg = "B+";
		}

		else if (marks >= 55) {
			if (marks >= 70) {
				lg = "B";
			}
			else if (marks >= 65) {
				lg = "C+";
			}
			else if (marks >= 60) {
				lg = "C";
			}
			else {
				lg = "D+";
			}
		}
		else if (marks >= 50) {
			lg = "D";
		}
		else {
			lg = "F";
		}
		
		return lg;
	}

}
