

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		int testCase = 1;
		
		while(testCase<=T) {
			String[] nm = sc.nextLine().split(" ");
			int N = Integer.parseInt(nm[0]);
			int M = Integer.parseInt(nm[1]);
			
			int[][] flies = new int[N][N]; 
			for (int i=0; i<N; i++) {
				String[] input = sc.nextLine().split(" ");
				for (int j=0; j<N; j++) {
					flies[i][j]	= Integer.parseInt(input[j]);			
				}	
			}
			
			//4중 for문이지만 15^4 = 50000정도니까 일단 돌림
			int max = 0; 
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) {
					
					int sum = 0;
					for(int r=0; r<M; r++) {
						for(int c=0; c<M; c++) {
							sum += flies[i+r][j+c];
						}
					}
					if(max<sum) max = sum;
					
				}
			}
			
			System.out.println("#"+testCase+" "+max);
			testCase++;
			
		}
		
		
		
	}	
}
