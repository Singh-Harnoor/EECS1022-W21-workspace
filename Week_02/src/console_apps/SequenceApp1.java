package console_apps;

import java.util.Scanner;

import model.Sequence;


public class SequenceApp1 {
	/*
	 * This application will prompt the user for the first number of the sequence
	 * It will also prompt for the common difference
	 * It will output the sequence separated by commas and the sum of the sequence
	 * Sequence will have only five values
	 */

	public static void main(String[] args) {
		// main program starts here
		
		// Scanner for the application
		Scanner input = new Scanner(System.in);
		
		// Stage1: Prompt the user and read inputs
		System.out.println("Enter the first term (FT) of an airthmetic seq. of size 5:");
		int ft = input.nextInt();
		
		System.out.println("Enter the common difference (d)");
		int d = input.nextInt();
		
		// Stage2: Compute the sequence and sum
//		int term1 = ft;
//		int term2 = ft + d;
//		int term3 = ft + 2 * d ;
//		int term4 = ft + 3 * d;
//		int term5 = ft + 4 * d;
//		
//		String sequence = "< " + term1 + ", " + term2 + ", " + term3+ ", " + term4+ ", " + term5 + " >";
//		int sum = term1 + term2 + term3 + term4 +term5;
		
		String sequence = Sequence.getSequence1(ft, d);
		int sum = Sequence.getSum1(ft, d);
		
		// Stage3: Output the result on console
		
		System.out.println("Sequence " + sequence + " has sum " + sum);
				
		
		
		
		
		
		input.close();
		
	}

}
