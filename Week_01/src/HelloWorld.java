import java.util.Scanner;
public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		System.out.println("My name is Harnoor Singh!");
		System.out.println("What's your name?");
		Scanner input = new Scanner(System.in);
		String name = input.next();
		System.out.println( "Hello "+ name);
	}

}
