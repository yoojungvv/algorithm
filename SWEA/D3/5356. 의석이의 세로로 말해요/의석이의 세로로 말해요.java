

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		int testCase = 1; 
		
		while (testCase<=T) {
			StringBuilder sb = new StringBuilder();
			
			char[][] chars = new char[5][15];
			for(int i=0; i<5; i++) {
				String input = sc.nextLine();
				for(int j=0; j<input.length(); j++) {
					chars[i][j] = input.charAt(j);
				}
			}
		
			for(int j=0; j<15; j++) {
				for(int i=0; i<5; i++) {
					if(chars[i][j]!=0) {
						sb.append(chars[i][j]);
					} 	
				}
			}
			
			System.out.println("#"+testCase+" "+sb);	
			
			testCase++;
		}
		
		sc.close();
	}
}
