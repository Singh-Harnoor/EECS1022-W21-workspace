import java.util.Scanner;

/*
 * This is the version one of a console application
 * We will prompt the user of radius values of two circles.
 * The application will output the areas of the two circles.
 */

public class CircleApp1 {
	// main method: entry point of execution
	public static void main(String[] args) {
		// starting the execution of the application.
		// System.in denotes the standard input (that is, Keyboard).
		Scanner input = new Scanner(System.in);
		
		// Start the actual application code here
		
		/*
		 *  Calculation for the first circle.
		 */
		// Step 1: Prompt the user for the radius of the first circle.
		System.out.println("Enter the radius of the first circle:");
		// Declare a variable to store the user input.
		// Step 2: Read a floating-point number from the user.
		double radius1 = input.nextDouble();
		// Step 3: Compute the area of the input circle accordingly.
		double area1 = 3.14 * radius1 * radius1;
		String area1s = String.format("%.2f", area1);
		// Step 4: Output the result back to the user.
		System.out.println("Area of the circle is: " + area1s);
		
		
		/*
		 *  Calculation for the second circle.
		 */
		// Step 1: Prompt the user for the radius of the second circle.
		System.out.println("Enter the radius of the second circle:");
		// Declare a variable to store the user input.
		// Step 2: Read a floating-point number from the user.
		double radius2 = input.nextDouble();
		// Step 3: Compute the area of the input circle accordingly.
		double area2 = 3.14 * radius2 * radius2;
		String area2s = String.format("%.2f", area2);
		// Step 4: Output the result back to the user.
		System.out.println("Area of the circle is: " + area2s);
		
		
		
		// end of the application code
		
		
		
		input.close();
		

	}

}
