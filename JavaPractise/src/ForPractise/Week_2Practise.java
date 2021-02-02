package ForPractise;

import java.util.Scanner;

public class Week_2Practise {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("AGE: ");
		int age = input.nextInt();
		
		if (age >= 0) {
			System.out.println("Hello, human!");
				
		}
		else {
			System.out.println("How can someone be of age " + age + " ?" );
		}
		
		System.out.println("Give me a number: ");
		int number = input.nextInt();
		
		if (number <= 0) {
			System.out.println("Error: number should be a natural negative");
		}
		else {
			number = number * number ;
			System.out.println( "Sqaure is "+ number);
		}
		
		input.close();

	}

}
