package ForPractise;

import java.util.Scanner;

public class ForTest {
	 
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int[] arr = {-1, 5, 6, 8, -2, 4};
		int temp;
		for (int i = 0; i < arr.length; i++) {     
            for (int j = i+1; j < arr.length; j++) {     
               if(arr[i] > arr[j]) {    
                   temp = arr[i];    
                   arr[i] = arr[j];    
                   arr[j] = temp;    
               }     
            }     
        }
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		}
	}

