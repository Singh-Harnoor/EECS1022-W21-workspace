package model;

public class Sequence {
	
	// These two methods are called by Sequence App 1 
	
	
	/*
	 * Method for the string sequence 
	 * This method returns a string that is, different terms in the bracket and are separated by commas.
	 */
	public static String getSequence1(int ft, int d) {
		
		String seq = "";
		
		// different sequence terms 
		int term1 = ft;
		int term2 = ft + d;
		int term3 = ft + 2 * d ;
		int term4 = ft + 3 * d;
		int term5 = ft + 4 * d;
		
		// Sequence of terms in the string form 
		seq = "< " + term1 + ", " + term2 + ", " + term3+ ", " + term4+ ", " + term5 + " >";
		
		return seq;
	}

	/*
	 * Method for sum of the sequence 
	 */
	public static int getSum1(int ft, int d) {
		int sum = 0;
		
		// Terms
		int term1 = ft;
		int term2 = ft + d;
		int term3 = ft + 2 * d ;
		int term4 = ft + 3 * d;
		int term5 = ft + 4 * d;
		
		// Sum evaluation	
		sum = term1 + term2 + term3 + term4 +term5;
		
		return sum;
	}
	
	
	// These two methods are called by Sequence App 2
	
	/*
	 * Method for the string sequence 
	 * This method returns a string that is, different terms in the bracket and are separated by commas.
	 */
	public static String getSequence2(int ft, int d) {
		
		String seq = "";
		
		seq = "< " + ft + ", " + (ft + d) + ", " + (ft + 2 * d) + ", " + (ft + 3 * d) + ", " + (ft + 4 * d) + " >";
		
		return seq;
		
	}
	
	
	/*
	 * Method for sum of the sequence 
	 */
	public static int getSum2(int ft, int d) {
		
		int sum = 0;
		
		sum = 5 * ft + 10*d ;
		
		return sum;
		
	}
	
	
}
