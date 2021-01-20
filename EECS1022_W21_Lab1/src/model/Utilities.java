package model;

public class Utilities {
	
	/*
	 * Assumption: the return geometric sequence is of a fixed size 5. 
	 * Therefore, it is not necessary to solve this problem using a loop,
	 * or to use methods from a library class (e.g., Math).\
	 * 
	 * Input parameters:
	 * 	- `ft` is the first term in the sequence
	 *  - `ratio` is the common rations among terms in the sequence
	 *  
	 * Refer to you lab instructions for what the method should return.
	 */
	public static String getGeometricSequence(int ft, int ratio) {
		String result = "";
		
		/* Your implementation of this method starts here. 
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
		// Each term of the sequence:
		int term1 = ft;
		int term2 = ratio * ft;
		int term3 = ratio * ratio * ft;
		int term4 = ratio * ratio * ratio * ft;
		int term5 = ratio * ratio * ratio * ratio * ft;
		// Sequence as a string
		String seq = "[" + term1 + "]" + "[" + term2 + "]" + "[" + term3 + "]"+ "[" + term4 + "]"+ "[" + term5 + "]";
		
		double average = (double)(term1 + term2 + term3 + term4 + term5)/5; 
		
		result = seq + " has average " + average;
		
		/* Your implementation ends here. */
		
		return result;
	}
	
	/*
	 * Input parameters:
	 *   - `weight` is the user's weight in pounds
	 *   - `height` is the user's height in inches
	 *   
	 * Refer to you lab instructions for what the method should return. 
	 */
	public static double getBMI(double weight, double height) {
		double result = 0.0;
		
		/* Your implementation of this method starts here. 
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
		// 1 pond is equivalent to 0.4536 kilograms
		double pound = 0.4536;
		// 1 inch is equal to 0.0254 meters
		double inch = 0.0254;
		
		// conversion of weight from pounds to kilograms
		double weightInKg = pound * weight;
		// conversion of height from inches to meters
		double heightInMeters = inch * height;
		// BMI = weight/ height^2
		double bmi = weightInKg/(heightInMeters * heightInMeters);
		
		result = bmi;
		
		/* Your implementation ends here. */
		
		return result;
	}
	
	/*
	 * Assumption: input value `seconds` is non-negative (i.e., >= 0).
	 * 
	 * Input parameters:
	 *   - `seconds` is the number of seconds to be converted
	 *   
	 * Refer to you lab instructions for what the method should return.
	 */
	public static String getTimeConversion(int seconds) {
		String result = "";
		
		/* Your implementation of this method starts here. 
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
		// Number of seconds in the given seconds
		int secs = seconds % 60;
		// Number of minutes in the given seconds
		int mins = (seconds / 60) % 60;
		// Number of hours in the given seconds
		int hours = (seconds / 3600) % 24; 
		// Number of days in the given seconds 
		int days = seconds / (3600 * 24);
		
		result = days + " days " + hours +" hours " + mins + " minutes " + secs + " seconds";
				
				
		/* Your implementation ends here. */
		
		return result;
	}
}
