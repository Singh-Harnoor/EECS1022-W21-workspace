package model;



public class Utilities {
	
	public static String getPrintOutRowbyRow(int[][] a) {
		String result = "";
		result = "{";
		for(int r = 0; r< a.length; r++) {
			result += "{";
			for (int c = 0; c<a[r].length; c++) {
				result += a[r][c];
				if( c < a[r].length -1){
					result += ", ";
				}
			}
			result += "}";
			if ( r < a.length - 1) {
				result += ", ";
			}
		}
		result += "}";
		
		return result;
	}
	
	/*
	 * Assumption: Given array is rectangular
	 */
	
	public static String getPrintOutColbyCol(int[][] a) {
		String result = "";
		result = "{";
		/*Since array 'a' is rectangular, it's not empty.*/
		for(int c = 0; c< a[0].length; c++) {
			result += "{";
			for (int r = 0; r<a.length; r++) {
				result += a[r][c];
				if( r < a.length -1){
					result += ", ";
				}
			}
			result += "}";
			if ( c < a[0].length - 1) {
				result += ", ";
			}
		}
		
		
		return result;
	}
	
	public static double getAverage(int[][] a) {
		double sum  = 0;
		int count = 0;
		
		for(int r = 0; r < a.length; r++) {
			for(int c = 0; c < a[r].length; c++) {
				sum += a[r][c];
				count++;
			}
		}
		
		
		return sum/count;
	}
	
	public static double[] getRowAverages(int[][] a) {
		double[] result = new double[a.length]; 
		double sum  = 0;
		int count = 0;
		
		for(int r = 0; r < a.length; r++) {
			// Start of a new row
			sum = 0;
			count = 0;
			for(int c = 0; c < a[r].length; c++) {
				sum += a[r][c];
				count++;
			}
			result[r] = sum/count;	
		}	
		return result;
	}
	
	/*
	 * Assumption: the input array 'a' is non-empty
	 */
	public static int[] getMAxMin(int[][] a) {
		/* initial max and min are set to the top-left corner*/
		int max = a[0][0];
		int min = a[0][0];
		for(int r = 0; r < a.length; r++) {
			for (int i = 0; i < a[r].length; i++) {
				if(a[r][i] > max) {
					max = a[r][i];
				}
				if(a[r][i] < min) {
					min = a[r][i];
				}
				
			}
		}
		int[] result = {max, min};
		return result;
	}
	/*
	 * Assumption:
	 * -there is at least one row in the array 'a'
	 * -the sums of rows are unique.
	 */
	public static int[] getRowMaxSum(int[][] a ) {
		int rowSum = 0;
		for(int c = 0; c < a[0].length; c++) {
			rowSum += a[0][c];
		}
		int maxRowSum = rowSum;
		int rowIndex = 0; /* index of the row with maximum sum*/
	
	
	/* start the row with 1 since rowSum has been initialized to the sum of row 0.*/
	for(int r = 1; r<a.length; r++) {
		rowSum = 0;
		for(int c = 0; c < a[r].length; c++) {
			rowSum += a[r][c];
		}
		if(rowSum > maxRowSum) {
			maxRowSum = rowSum;
			rowIndex = r;
		}
		
	}
	
	 return a[rowIndex];
	
	}
	
	public static boolean allPositive(int[][] a) {
		boolean allPositive = true;
		for(int r =0; r < a.length && allPositive; r++) {
			for(int c = 0; c < a[r].length && allPositive; c++) {
				allPositive = a[r][c] > 0;
			}
		}
		return allPositive;
	}
	/*
	 * Assumption: the input array is not empty
	 * Special case: a single-row input is also considered as a rectangle.
	 */
	public static boolean isRectangle(int[][] a) {
		int numberOfCol = a[0].length;
		boolean allRemainingRowsEquallyLong = true;
		for(int r = 1; r < a.length && allRemainingRowsEquallyLong; r++) {
			allRemainingRowsEquallyLong = a[r].length == a[0].length;
		}
		return allRemainingRowsEquallyLong;
	}
	
}
