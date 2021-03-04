package model;

public class Utilities {
	/* 
	 * 	Requirements:
	 * 	- It is strictly forbidden for you to use: 
	 * 		+ Any Java library class (e.g., ArrayList, Arrays)
	 * 		  (That is, there must not be an import statement in the beginning of this class.)
	 * 	- You will receive an immediate zero for this task if the requirement is violated. 
	 * 	- You can define helper methods if you wish.
	 * 
	 * Only write lines of code within the methods given to you. 
	 * Do not declare any variables OUTSIDE the given methods.
	 * You can only declare local variables within each method.
	 * 
	 * Your submission will only be graded against:
	 * 	- JUnit tests given to you in TestUtilities
	 * 	- additional JUnit tests  
	 */

	/*	 
	 * Input Parameters:
	 *	- `seq`: a non-empty array of integers
	 *	- `n`: a non-negative integer 
	 *
	 * Assumptions:
	 * 	- Input array `seq` is not empty.
	 * 	- Input integer `n` is non-negative (>= 0).
	 *  
	 * What to return?
	 *  - Given an array `seq` of integers and an integer `n`, 
	 *  	return a new array whose elements correspond to those of `seq` by 
	 *  	shifting every element in `seq` to the left by `n` positions. 
	 *  - The shifts are ***circular***: 
	 *  	any elements that would "go off the boundary" are 
	 *  	wrapped around back from the beginning of the array.
	 *   
	 * See the JUnit tests related to this method.
	 */
	public static int[] task1(int[] seq, int n) {
        int[] result = null;
		
		/* Your task is to implement this method,
		 * so that running TestUtilities.java will pass all JUnit tests.
		 *  
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.
		 * 3. Do not re-assign any of the parameter/input variables. 
		 */
		
		// Your implementation of this method starts here. 
		
        int [] temp = new int[seq.length];
        int index = 0;
        while (n > seq.length) {
        	n = n - seq.length;
        }
        for (int i = n; i < seq.length; i++) {
        	temp[index] = seq[i];
        	index++;
        }
        for (int j = 0; j < n && j < seq.length; j++) {
        	temp[index] = seq[j];
        	index++;
        }
        
        result = temp;

		// Do not modify this return statement. 
        return result;
    }
	
	/*	 
	 * Input Parameters:
	 *	- `seq`: an array of integers
	 *	- `indices`: an array of integers (each of which may or may not be a valid index for `seq`) 
	 *
	 * Assumptions:
	 * 	- `seq` may be empty.
	 * 	- `indices` may be empty. 
	 * 	- `indices` may contain duplicates.
	 *  
	 * What to return?
	 *  - For each integer value in `indices`, if it is a valid index for input array `seq`, 
	 *  	then use it to index into `seq` and include the result in the output array.
	 *  
	 *  For example: Say `seq` is {23, 46, 69} and `indices` is {2, -1, 0, 3, 0, 2}
	 *  	(where indices -1 and 3 are invalid, so only indices 2, 0, 0, 2 are used)
	 *   	Then the method should return {69, 23, 23, 69} 
	 *   
	 *  Note: Order of elements in the output array corresponds to the order in which
	 *  		valid indices in the `indices` array are arranged. 
	 *  
	 *  That is, the output array may be empty if the input array `seq` is empty,
	 *  	or if the input array `indices` does not contain any valid indices.
	 *   
	 * See the JUnit tests related to this method.
	 */
	public static int[] task2(int[] seq, int[] indices) {
		int[] result = null;
		
		/* Your task is to implement this method,
		 * so that running TestUtilities.java will pass all JUnit tests.
		 *  
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.
		 * 3. Do not re-assign any of the parameter/input variables. 
		 */
		
		// Your implementation of this method starts here. 
		int counter = 0;
		for (int i = 0; i < indices.length; i++) {
			if (indices[i] >= 0 && indices[i] < seq.length) {
				counter++;
			}
		}
		int [] indArray = new int[counter];
		int index = 0;
		for (int i = 0; i < indices.length; i++) {
			if (indices[i] >= 0 && indices[i] < seq.length) {
				indArray[index] = seq[indices[i]];
				index++;
			}		
		}
		result = indArray;
		// Do not modify this return statement. 
        return result;
    }
	
	/*	 
	 * Input Parameters:
	 *	- `seq`: an array of integers that stores the following encoding:
	 *  	Element at each odd index (e.g., at index 1, at index 3, and so on) specifies 
	 *  	how many times the element at the previous even index (e.g., at index 0, at index 2, and so on) 
	 *  	should repeat.
	 *    For example, input sequence {2, 4, 1, 3} encodes that 
	 *  	value 2 (at even index 0) should repeat 4 times (as specified at odd index 1), 
	 *  	and similarly, value 1 should repeat 3 times.
	 *
	 * Assumptions:
	 * 	- Input array `seq` is not empty and contains at least one element.
	 *  
	 * What to return?
	 *  - Return an array that decodes the input array.
	 *  	e.g., Say `seq` is {2, 4, 1, 3}. 
	 *  		Then the method should return an array {2, 2, 2, 2, 1, 1, 1}.
	 *   
	 * See the JUnit tests related to this method.
	 */
	public static int[] task3(int[] seq) {
    	int[] result = null;
		
		/* Your task is to implement this method,
		 * so that running TestUtilities.java will pass all JUnit tests.
		 *  
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.
		 * 3. Do not re-assign any of the parameter/input variables. 
		 */
		
		// Your implementation of this method starts here.
    	int arrayLength;
    	int [] arr = null;
    	if (seq.length >= 2) {
    		arrayLength = 0;
    		for (int i = 1; i < seq.length; i = i + 2 ) {
    			arrayLength += seq[i];
    		}
    		arr = new int[arrayLength];
    		int index = 0;
    		for (int i = 0; i < seq.length; i = i + 2 ) {
        		for (int j = 0; j < seq[i+1]; j ++ ) {
        			arr[index] = seq[i];
        			index++;
        		}
        		
        	}
    	}
    	else {
    		arrayLength = 1;
    		arr[0] = seq[0];
    	}
    	result = arr;
//    	
		// Do not modify this return statement. 
        return result;
    }	
	
	/*	 
	 * Input Parameters:
	 *	- `seq`: a non-empty array of integers 
	 *
	 * Assumptions:
	 * 	- Input array `seq` is not empty. 
	 *  
	 * What to return?
	 *  -  Return another array of strings, each of which denoting a non-empty suffix of the input array.
	 *     
	 *     A suffix of array `seq` contains its last n elements (where 1 <= n <= seq.length). 
	 *     
	 *  	For example, if the input array is:
	 *   
	 *  		<3, 1, 4>
	 *  
	 *  	Then the output or returned array of string values is:
	 *  		
	 *  		<"[3, 1, 4]", "[1, 4]", "[4]">
	 *  	
	 *  	where each suffix is structured as a comma-separated list surrounded by square brackets.	
	 *  
	 *  	Note that the length of the output array is equal to the length of the input array. 
	 *  	
	 *  	Also, elements in the output array are ``sorted'' by the lengths of the suffixes. 
	 *  		(e.g,. the last element is the suffix of length 1, the second last element is the suffix of length 2).
	 *   
	 * See the JUnit tests related to this method.
	 */
	public static String[] task4(int[] seq) {
		String[] result = null;
		
		/* Your task is to implement this method,
		 * so that running TestUtilities.java will pass all JUnit tests.
		 *  
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.
		 * 3. Do not re-assign any of the parameter/input variables. 
		 */
		
		// Your implementation of this method starts here. 
		String [] stringArray = new String[seq.length];
		int index = 0;
		for (int i = 0; i < seq.length; i++ ) {
			String sub = "[";
			for (int j = i; j < seq.length; j++) {
				sub += seq[j];
				if (j < seq.length - 1 ) {
					sub += ", ";
				}
			}
			sub += "]";
			stringArray[index] = sub; 
			index++;
		}
		result = stringArray;
		// Do not modify this return statement. 
        return result;
    }
}

