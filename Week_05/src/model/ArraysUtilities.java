package model;

public class ArraysUtilities {
	/*
	 * e.g., Given <2, 3, 4>, return the sums for sub-arrays: <2, 5, 9>
	 */
	public static int[] getIntermediateSums(int[] ns) {
		int [] result = null;
		
		int sum =0;
		int[] sums = new int[ns.length];
		for (int i = 0; i < ns.length; i++) {
			sum += ns[i];
			sums[i] = sum;
		}
		result = sums;
		
		return result;
	}
	
	
}
