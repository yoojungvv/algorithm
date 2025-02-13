
import java.util.Scanner;

public class Solution {
	
	public static boolean isPalindrome(char[][] chars, int r1, int c1, int r2, int c2, int len) {
		for (int i=0; i<len/2; i++) {
			if(r1==r2) {
				if(chars[r1][c1+i]!=chars[r2][c2-i]) return false;
			} else {
				if(chars[r1+i][c1]!=chars[r2-i][c2]) return false;
			}
		}
		return true;			
	}
	
	
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int testCase = 1; 
		
		
		while(testCase<=10) {
			int T = Integer.parseInt(sc.nextLine());
			char[][] chars = new char[100][100];
			int max = 1;
			
			//input에서 100행 읽어와서 char배열에 채워주기 
			for(int i=0; i<100; i++) {
				String input = sc.nextLine();
				for(int j=0; j<100; j++) {
					chars[i][j] = input.charAt(j);
				}			
			}
			
			for(int i=0; i<100; i++) {
				// [가로]어떤 문자로 시작해서 같은 문자로 끝나면, isPalindrome 호출해서 검증
				for(int lt = 0; lt<99; lt++) {
					for(int rt = lt+1; rt<100; rt++) {
						int len = rt-lt+1;
						if(isPalindrome(chars, i, lt, i, rt, len)) {
							if(max < len) 
								max = len;
						}
					}
				}				
			}
			

			for(int j=0; j<100; j++) {
				// [세로]어떤 문자로 시작해서 같은 문자로 끝나는 좌표 ArrayList에 기록
				for(int lt = 0; lt<99; lt++) {
					for(int rt = lt+1; rt<100; rt++) {
						int len = rt-lt+1;
						if(isPalindrome(chars,lt, j, rt, j, len)) {
							if(max < len) 
								max = len;
						}
					}		
				}	
			}
			
			
			System.out.println("#"+T+" "+max);
			
			testCase++;
			
		}
		
		
	}	
}

