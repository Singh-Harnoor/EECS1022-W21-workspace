package model;

/*
 * Requirements:
 * - Any use of Java library classes or methods (e.g., ArrayList) is forbidden.
 * 	 (That is, there must not be an import statement in the beginning of this class.)
 * Violation of this requirement will result in a 50% penalty of your marks.
 *  
 * - Use only if-statements and/or loops to manipulate primitive arrays (e.g., int[], String[]).
 */

public class Utilities {
	/*
	 * Input parameters:
	 * 	- `numbers` : an array of integers
	 *  
	 * Refer to you lab instructions for what the method should return. 
	 */
	public static int[] getMultiplesOf3(int[] numbers) {
		int[] result = null;
		
		/* Your implementation of this method starts here. 
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
		int arraylength = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i]%3 == 0) {
				arraylength += 1;
			}
		}
		
		int[] multiples = new int[arraylength];
		int index = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i]%3 == 0) {
				multiples[index] = numbers[i];
				index += 1;
			}
		}
		
		result = multiples;
		
		/* Your implementation ends here. */
		
		return result;
	}	
	
	/*
	 * Input parameters:
	 * 	- `numbers` : an array of integers
	 * 	- `n`		: an integer (which may or may not exist in `numbers`)
	 *  
	 * Refer to you lab instructions for what the method should return. 
	 */
	public static int[] getFilteredSeq(int[] numbers, int n) {
		int[] result = null;
		
		/* Your implementation of this method starts here. 
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
		int commonNum = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == n) {
				commonNum += 1;
			}
		}
		int arrayLength = numbers.length - commonNum;
		int[] filteredArray = new int[arrayLength];
		int position = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] != n) {
				filteredArray[position] = numbers[i];
				position += 1;
			}
		}
		
		result = filteredArray;
		
		/* Your implementation ends here. */
		
		return result;
	}
	
	/*
	 * Input parameters:
	 * 	- `numbers` : an array of integers
	 * 
	 * Assumptions:
	 * 	- numbers.length >= 1
	 *  
	 * Refer to you lab instructions for what the method should return. 
	 */
	public static String[] getAllPrefixes(int[] numbers) {
		String[] result = null;
		
		/* Your implementation of this method starts here. 
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
		String[] array = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			
			array[i] = "[";
			for (int j = 0; j <= i; j++) {
				array[i] += numbers[j];
				if (i != j) {
					array[i] += ", ";
				}
			}
			array[i] += "]";
			
		}
		result = array;
		
		/* Your implementation ends here. */
		
		return result;
	}
	
	/*
	 * Input parameters:
	 * 	- `numbers` : an array of integers
	 *  
	 * Refer to you lab instructions for what the method should return. 
	 */
	public static int[] getGroupedNumbers(int[] numbers) {
		int[] result = null;
		
		/* Your implementation of this method starts here. 
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
		
		int[] groups = new int[numbers.length];
		int index = 0;
		for (int i = 0; i < numbers.length; i++) {
			
		if (numbers[i]%3 == 0) {
			groups[index] = numbers[i];
			index ++;
			}
		}
		for (int i = 0; i < numbers.length; i++) {
			
			if (numbers[i]%3 == 1) {
				groups[index] = numbers[i];
				index ++;
			}
		}
		for (int i = 0; i < numbers.length; i++) {
			
			if (numbers[i]%3 == 2) {
				groups[index] = numbers[i];
				index ++;
			}
		}
		
		result = groups;	
		/* Your implementation ends here. */
		
		return result;
	}
}
