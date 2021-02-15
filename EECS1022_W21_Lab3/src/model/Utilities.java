package model;

public class Utilities {
	/*
	 * Input parameters:
	 * 	- `lower` is the lower bound
	 *  - `upper` is the upper bound
	 *  
	 * Use of arrays or any Java library class (e.g., ArrayList) is strictly forbidden.
	 * Violation of this will result in a 50% penalty on your marks.
	 * Try to solve this problem using loops only.   
	 *  
	 * Refer to you lab instructions for what the method should return. 
	 */
	public static String getNumbers(int lower, int upper) {
		String result = "";
		
		/* Your implementation of this method starts here. 
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */

		if (lower >=0 && upper >=0) {
			if (lower <= upper) {
				if (lower == upper) {
					if (lower % 3 == 0) {
						result = "1 number between " + lower + " and " + upper + ": <(" + lower + ")>";
					}
					else if (lower % 3 == 1) {
						result = "1 number between " + lower + " and " + upper + ": <[" + lower + "]>";
					}
					else if (lower % 3 == 2) {
						result = "1 number between " + lower + " and " + upper + ": <{" + lower + "}>";
					}

				}
				else {
					int numbers = upper - lower; 
					result = (numbers + 1) + " numbers between " + lower + " and " + upper + ": <";
					int smaller = lower;
					for (; smaller <= upper;) {
						if (smaller < upper) {
							if (smaller % 3 == 0) {
								result += "(" + smaller + "), ";
							}
							else if (smaller % 3 == 1) {
								result += "[" + smaller + "], ";
							}
							else if (smaller % 3 == 2) {
								result += "{" + smaller + "}, ";
							}
						}
						else {
							if (smaller % 3 == 0) {
								result += "(" + smaller + ")>";
							}
							else if (smaller % 3 == 1) {
								result += "[" + smaller + "]>";
							}
							else if (smaller % 3 == 2) {
								result += "{" + smaller + "}>";
							}
						}
						smaller++;
					
					}
				}
			}
			else {
				result = "Error: lower bound " + lower + " is not less than or equal to upper bound " + upper;
			}
			
		}
		else {
			result = "Error: both bounds must be non-negative";
		}
		
		
		/* Your implementation ends here. */
		
		return result;
	}
	
	/*
	 * Input parameters:
	 * 	- `ft`, `d`, `n` are the first term, common difference, and size of an arithmetic sequence.
	 * 
	 * Use of arrays or any Java library class (e.g., ArrayList) is strictly forbidden.
	 * Violation of this will result in a 50% penalty on your marks.
	 * Try to solve this problem using loops only. 
	 *  
	 * Refer to you lab instructions for what the method should return. 
	 */
	public static String getIntermediateStats(int ft, int d, int n) {
		String result = "";
		
		/* Your implementation of this method starts here. 
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
		result += "{";
		String terms = "";
		int term = ft;
		int sum = 0;
		double avg = 0.0;
		for (int i=1; i<=n; i++) {
			sum += term;
			terms += term;
			avg = ((double)sum)/i;
			
			result += "[sum of <" + terms + ">: " + sum + " ; avg of <" + terms + ">: " + String.format("%.2f]", avg);
			
			term += d;
			if (i < n) {
				result += ", ";
				terms += ", ";
			}
		}
		result += "}";
		
		/* Your implementation ends here. */
		return result;
	}
	
	/*
	 * Input parameters:
	 * 	- `ft1`, `d1`, `n1` are the first term, common difference, and size of the first arithmetic sequence.
	 *  - `ft2`, `d2`, `n2` are the second term, common difference, and size of the second arithmetic sequence.
	 *  
	 * Use of arrays or any Java library class (e.g., ArrayList) is strictly forbidden.
	 * Violation of this will result in a 50% penalty on your marks.
	 * Try to solve this problem using loops only.  
	 *  
	 * Refer to you lab instructions for what the method should return. 
	 */
	public static String getInterlevaings(int ft1, int d1, int n1, int ft2, int d2, int n2) {
		String result = "";
		
		/* Your implementation of this method starts here. 
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
		result += "<";
		int term1 = ft1;
		int term2 = ft2;
		int num1 = n1;
		int num2 = n2;
		for (int i = 1; i <= (n1+ n2); i++ ) {
			// For first sequence
			if ((i % 2 == 1|| num2 <=0) && num1 > 0) {
				result += "(" + term1 +")";
				if (i < (n1+ n2) ){
					result += ", ";
				}
				num1--;
				term1 += d1;
			}
			// For the second sequence
			else if ( (i%2 == 0 || num1 <=0) && num2 >0){
				result += "[" + term2 + "]";
				if (i < (n1+ n2)) {
					result += ", ";
				}
				num2--;
				term2 += d2;
			}
			
		}
		result += ">";
		
		
		
		/* Your implementation ends here. */
		return result;
	}	
}
