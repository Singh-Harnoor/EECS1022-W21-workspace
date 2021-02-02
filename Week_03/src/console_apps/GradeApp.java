package console_apps;

import java.util.Scanner;

import model.Grade;

public class GradeApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a raw mark (from 0 to 100):");
		int marks = input.nextInt();
		
		String report = Grade.getGradeReport(marks);
		
		System.out.println("It is letter grade " + report);
		
		input.close();

	}

}
