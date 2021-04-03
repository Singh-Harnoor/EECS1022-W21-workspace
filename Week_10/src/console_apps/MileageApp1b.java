package console_apps;

import java.util.Scanner;

public class MileageApp1b {
	// Helper Method for returning the corresponding index of a city
	public static int indexOf(String city) {
		int index = -1;
		if (city.equals("Chicago")) {
			index = MileageApp1b.CHICAGO;
		}
		else if (city.equals("Boston")) {
			index = MileageApp1b.BOSTON;
		}
		else if (city.equals("New York")) {
			index = MileageApp1b.NEWYORK;
		}
		else if (city.equals("Atlanta")) {
			index = MileageApp1b.ATLANTA;
		}
		else if (city.equals("Miami")) {
			index = MileageApp1b.MIAMI;
		}
		else if (city.equals("Dallas")) {
			index = MileageApp1b.DALLAS;
		}
		else if (city.equals("Houston")) {
			index = MileageApp1b.HOUSTON;
		}	
		
		return index;
	}
	
	public static final int CHICAGO = 0;
	public static final int BOSTON  = 1;
	public static final int NEWYORK = 2;
	public static final int ATLANTA = 3;
	public static final int MIAMI   = 4;
	public static final int DALLAS  = 5;
	public static final int HOUSTON = 6;
	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		
		int[] fromChicago = {0		, 983	, 787	, 714	, 1375	, 967	, 1087	};
		int[] fromBoston  = {983	, 0		, 214	, 1102	, 1763	, 1723	, 1842	};
		int[] fromNewYork = {787	, 214	, 0		, 888	, 1549	, 1548	, 1627	};
		int[] fromAtlanta = {714	, 1102	, 888	, 0		, 661	, 781	, 810	};
		int[] fromMiami   = {1375	, 1763	, 1549	, 661	, 0		, 1426	, 1187	};
		int[] fromDallas  = {967	, 1723	, 1548	, 781	, 1426	, 0		, 239	};
		int[] fromHouston = {1087	, 1842	, 1627	, 810	, 1187	, 239	, 0  	};
		
		System.out.println("How many cities in your itinerary");
		int howMany = input.nextInt();
		input.nextLine(); // Consume the next line character so that later reading a string would be Ok.
		
		String[] trip = new String[howMany];
		
		/* Read cities from the user and store them to 'trip'*/
		for (int i = 0; i < howMany; i++) {
			System.out.println("Enter a city:");
			String city = input.nextLine();
			trip[i] = city;
		}
		
		/* Add up departure-to-destination distances */
		int dist = 0;
		for (int i = 0; i < howMany -1; i++) {
			String dep = trip[i]; // Departure
			String dst = trip[i+1]; // Destination
			
			int depIndex = MileageApp1b.indexOf(dep);
			/*In this improved version, 
			 * we still have to use a conditional on 'depIndex' to figure out
			 * which separate array variable to index into.
			 * It would be very effective if all seven array variables can be combined into one.
			 */
			int dstIndex = MileageApp1b.indexOf(dst);
			
			int currentDistance = 0;
			if (depIndex == MileageApp1b.CHICAGO) {
				currentDistance = fromChicago[dstIndex];
			}
			if (depIndex == MileageApp1b.BOSTON) {
				currentDistance = fromBoston[dstIndex];
			}
			if (depIndex == MileageApp1b.NEWYORK) {
				currentDistance = fromNewYork[dstIndex];
			}
			if (depIndex == MileageApp1b.ATLANTA) {
				currentDistance = fromAtlanta[dstIndex];
			}
			if (depIndex == MileageApp1b.MIAMI) {
				currentDistance = fromMiami[dstIndex];
			}
			if (depIndex == MileageApp1b.DALLAS) {
				currentDistance = fromDallas[dstIndex];
			}
			if (depIndex == MileageApp1b.HOUSTON) {
				currentDistance = fromHouston[dstIndex];
			}
			
			dist += currentDistance;
			System.out.println("From " + dep + " to " + dst + ": " + currentDistance);
			
		}
		
		System.out.println("Distance: " + dist);
		System.out.println("Bye!");
		
		input.close();

	}

}
