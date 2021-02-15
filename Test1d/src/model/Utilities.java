package model;

public class Utilities
{
	/* 
	 * 	Requirements:
	 * 	- It is strictly forbidden for you to use: 
	 * 		+ Any Java library method (e.g., Arrays.sort)
	 * 		  (That is, there must not be an import statement in the beginning of this class.)
	 * 		+ arrays
	 * 	- You will receive an immediate zero for this task if the requirement is violated. 
	 * 
	 * Only write lines of code within the methods given to you.
	 * Do not add any new helper methods. 
	 * Do not declare any variables OUTSIDE the given methods.
	 * You can only declare local variables within each method.
	 * 
	 * Your submission will only be graded against:
	 * 	- JUnit tests given to you in TestUtilities
	 * 	- additional JUnit tests 
	 * 	  (therefore it is important that you test your own methods
	 *     by either the console application class App or your own JUnit tests) 
	 */

	/*	Task 1.
	 * 	
	 * 	Input Parameters:
	 *	- `unitOfWeight`	: either "pound" or "kilogram"
	 *	- `valueOfWeight`	: the weight value
	 *	- `unitOfHeight`	: either "foot" or "inch"
	 *	- `valueOfHeight`	: the height value
	 *
	 *	Error conditions (in order of priority):
	 *	1. When the `unitOfWeight` is neither "pound" nor "kilogram" (case sensitive).
	 *	2. When the `unitOfHeight` is neither "foot" nor "inch" (case sensitive).
	 *	3. When not both weight value and height value are positive.
	 *	If multiple error conditions hold, return a message related to the error with the highest priority.
	 *	e.g., invoking getBMIReport("Pounds", -154.3, "Inches", -66.92) has all inputs invalid,
	 *			but only an error message about weight unit is returned.
	 *
	 *  What to return?
	 *  - Return an error message if there is any error.
	 *  - Otherwise, calculate the Body Mass Index (BMI) by: weight (in kilogram) divided by the square of height (in meters).
	 *  	+ Use the following conversion rates (when needed):
	 *  		1 inch is 0.0254 meter 			(use it when `unitOfHeight` is "inch")
	 *  		1 foot is 0.3048 meter
	 *  		1 pound is 0.453592 kilogram
	 *  	+ The calculation result must be formatted with 2 digits after the decimal:
	 *  		Use String.format("%.2f", someNumber)
	 *  	+ Also, include an interpretation message (case sensitive) according to the following scheme:
	 *  		BMI < 18.5 			means "Underweight"
	 * 			18.5 <= BMI < 25.0 	means "Normal"
	 * 			25.0 <= BMI < 30.0 	means "Overweight"
	 * 			30.0 <= BMI 		means "Obese"
	 * 
	 * See the JUnit tests related to this method for the precise format of the string return value.
	 */
	public static String getBMIReport(String unitOfWeight, double valueOfWeight, String unitOfHeight, double valueOfHeight) {
		String result = "";
		
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
		
		// To check the units of weight
		double bmi = 0.0;
		if (unitOfWeight.equals("pound") || unitOfWeight.equals("kilogram")){
			// To check the units of height
			if (unitOfHeight.equals("foot") || unitOfHeight.equals("inch")) {
				if (valueOfWeight > 0 && valueOfHeight > 0) {
					double inch = 0.0254;
					double foot = 0.3048;
					double pound = 0.453592;
					
					if (unitOfHeight.equals("foot")) {
						if(unitOfWeight.equals("pound")) {
							 bmi = (valueOfWeight * pound) / (valueOfHeight * valueOfHeight * foot * foot);
						}
						else {
							 bmi = (valueOfWeight) / (valueOfHeight * valueOfHeight * foot * foot);
						}
						 
					}
					else if (unitOfHeight.equals("inch")) {
						if(unitOfWeight.equals("pound")) {
							 bmi = (valueOfWeight * pound) / (valueOfHeight * valueOfHeight * inch * inch);
						}
						else {
							 bmi = (valueOfWeight) / (valueOfHeight * valueOfHeight * inch * inch);
						}
					}
					if (bmi < 18.5 ) {
						result = String.format("BMI is: %.2f (Underweight)", bmi);
					}
					else if(18.5 <= bmi && bmi < 25.0) {
						result = String.format("BMI is: %.2f (Normal)", bmi);
					}
					else if(25.0 <= bmi && bmi < 30.0) {
						result = String.format("BMI is: %.2f (Overweight)", bmi);
					}
					else if(30.0 <= bmi) {
						result = String.format("BMI is: %.2f (Obese)", bmi);
					}
				}
				else {
					result = "Error: both weight and height must be positive";
				}
			}
			else {
				result = "Error: " + unitOfHeight + " is not a valid height unit";
			}
		}
		else {
			result = "Error: " + unitOfWeight + " is not a valid weight unit";
		}
		
		// Do not modify this return statement. 
		return result;
	}
	
	/*	Task 2.
	 * 
	 * 	Requirements:
	 * 	- It is strictly forbidden for you to use: 
	 * 		+ Any Java library method (e.g., Arrays.sort)
	 * 		  (That is, there must not be an import statement in the beginning of this class.)
	 * 		+ arrays
	 * 	- You will receive an immediate zero for this task if the requirement is violated.
	 * 	
	 * 	Input Parameters:
	 *	- `n1`: first number
	 *	- `n2`: second number
	 *	- `n3`: third number
	 *	- `n4`: fourth number  
	 *	Note. These four input numbers are not necessarily unique. They might contain duplicates.
	 *
	 *	Error conditions (in order of priority):
	 *	- None. No error message is needed.
	 *
	 *  What to return?
	 *  - Return a report of the smallest number and the second smallest number.
	 *  
	 * See the JUnit tests related to this method for the precise format of the string return value.
	 */
	public static String getSmallestTwoNumbers(int n1, int n2, int n3, int n4) {
		String result = "";
		
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
	
//		if (n1 <= n2) {
//			if (n3 <= n4) {
//				if (n3 <= n1) {
//					if (n1 <= n4) {
//						result = "smallest is " + n1 + " and second smallest is "+ n1;
//					}
//					else {
//						result = "smallest is " + n3 + " and second smallest is "+ n4;
//					}
//				}
//				else {
//					if (n1 <= n4) {
//						result = "smallest is " + n1 + " and second smallest is "+ n3;
//					}
//					else {
//						result = "smallest is " + n4 + " and second smallest is "+ n3;
//					}
//					result = "smallest is " + n1 + " and second smallest is "+ n3;
//				}
//			}
//			else {
//				if (n4 <= n1) {
//					result = "smallest is " + n4 + " and second smallest is "+ n1;
//				}
//				else {
//					result = "smallest is " + n1 + " and second smallest is "+ n4;
//				}
//			}
//		}
//		else {
//			if (n3 <= n4) {
//				if (n3 <= n2) {
//					result = "smallest is " + n3 + " and second smallest is "+ n2;
//				}
//				else {
//					result = "smallest is " + n2 + " and second smallest is "+ n3;
//				}
//			}
//			else {
//				if (n3 <= n2) {
//					result = "smallest is " + n3 + " and second smallest is "+ n2;
//				}
//				else if (n4 <= n2) {
//					result = "smallest is " + n4 + " and second smallest is "+ n2;
//				}
//				else {
//					result = "smallest is " + n2 + " and second smallest is "+ n4;
//				}
//		}
//		}
		int smallest = 0;
		int ssmallest = 0;
		if (n1 <= n2 && n1 <= n3 && n1 <= n4) {
			smallest = n1;
			if (n2 <= n3 && n2 <= n4) {
				ssmallest = n2;
			}
			else if (n3 <= n2 && n3 <= n4 ) {
				ssmallest = n3;
			}
			else if (n4 <= n2 && n4 <= n3) {
				ssmallest = n4;
			}
		}
		else if (n2 <= n1 && n2 <= n3 && n2 <= n4) {
			smallest = n2;
			if (n1 <= n3 && n1 <= n4) {
				ssmallest = n1;
			}
			else if (n3 <= n1 && n3 <= n4 ) {
				ssmallest = n3;
			}
			else if (n4 <= n1 && n4 <= n3) {
				ssmallest = n4;
			}
		}
		else if (n3 <= n1 && n3 <= n2 && n3 <= n4) {
			smallest = n3;
			if (n1 <= n2 && n1 <= n4) {
				ssmallest = n1;
			}
			else if (n2 <= n1 && n2 <= n4 ) {
				ssmallest = n2;
			}
			else if (n4 <= n1 && n4 <= n2) {
				ssmallest = n4;
			}
		}
		else if (n4 <= n1 && n4 <= n2 && n4 <= n3) {
			smallest = n4;
			if (n1 <= n2 && n1 <= n3) {
				ssmallest = n1;
			}
			else if (n2 <= n1 && n2 <= n3 ) {
				ssmallest = n2;
			}
			else if (n3 <= n1 && n3 <= n2) {
				ssmallest = n3;
		}
		}
		result = "smallest is " + smallest + " and second smallest is "+ ssmallest;
		
		// Do not modify this return statement. 
		return result;
	}
	
	/*	Task 3.
	 * 	
	 * 	Input Parameters:
	 *	- `p1`			: name of player 1
	 *	- `p1Option`	: what player 1 plays, either 'r' (rock), 'p' (paper), or 's' (scissors)
	 *	- `p2`			: name of player 2
	 *	- `p2Option`	: what player 2 plays, either 'r' (rock), 'p' (paper), or 's' (scissors)
	 *	
	 *	Error conditions (in order of priority):
	 *	- None. No error message is needed. You can assume that `p1Option` and `p2Option` are always valid.
	 *
	 *  What to return?
	 *  - Return the name of player who loses. Or return "tie" when no one loses.
	 *  
	 * See the JUnit tests related to this method for the precise format of the string return value.
	 */
	public static String getLoserOfRPS(String p1, char p1Option, String p2, char p2Option) {
    	String result = "";
    	
    	/* Your task is to implement this method,
		 * so that running UtilitiesTester.java will output the expected value to console.
		 * 
		 * Do not write any System.out.print(...) or System.out.println(...).
		 * Do not declare any Scanner. 
		 * Do not re-assign any of the parameter/input variables. 
		 */

		/* Your code starts after this line: */
    	if (p1Option == 'r') {
			if (p2Option == 's') {
				result = p2;
			}
			else if (p2Option == 'p') {
				result = p1;
			}
			else {
				result = "tie";
			}
		
    	}
    	else if (p1Option == 's') {
			if (p2Option == 's') {
				result = "tie";
			}
			else if (p2Option == 'p') {
				result = p2;
			}
			else {
				result = p1;
			}
    	}
       	else if (p1Option == 'p') {
    			if (p2Option == 's') {
    				result = p1;
    			}
    			else if (p2Option == 'p') {
    				result = "tie";
    			}
    			else {
    				result = p2;
    			}
        	}
        
        // Do not modify this return statement.
        return result;
    }
}

