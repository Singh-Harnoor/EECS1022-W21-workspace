package ForPractise;

import java.util.Scanner;


class Solution{
    public static void main(String []arg){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        int sum = 0;
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            if (0 <= t && t <= 500 &&  0 <= a && b <= 50 && 1 <= n && n <= 15){
                for(int j = 0; j < n; j++){
                    sum += a + Math.pow(2, j)* b;
                    System.out.print(sum + " ");
                    
                }
                System.out.println();
            }
             
            
            
            
        }
        in.close();
    }
}
